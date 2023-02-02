package cn.gionrose.displayEditor.Implement_common.configFileHelperImpl;



import cn.gionrose.displayEditor.Implement_common.configContainerManagerImpl.DefaultConfig;
import cn.gionrose.displayEditor.common.fileHelper.SimpleConfigFileReader;
import cn.gionrose.displayEditor.common.interal.DisplayEditor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.*;



/**
 * @Author loki
 * @Date 2023/1/20 22:02
 */
public class DefaultSimpleConfigFileReader implements SimpleConfigFileReader
{
    private String configName;
    private final Map<String, YamlConfiguration> allConfigFiles ;
    private final Map<String,String> allAction = new HashMap<>();
    private final List<Map<String,String>> singletonSettings = new ArrayList<>();
    private final String FUNCTIONS = "functions";
    private final String SETTINGS = "settings";


    {
        Map<String, File> configFilesFileType = getAllConfigFilesFileType();
        allConfigFiles = parseToYamlConfiguration(configFilesFileType);
    }
    public Map<String, File> getAllConfigFilesFileType ()
    {
        return DisplayEditor.getApi().getFileHelper().getFiles(".yml");
    }
    private Map<String, YamlConfiguration> parseToYamlConfiguration (Map<String, File> configFiles)
    {
        Map<String, YamlConfiguration> allConfigFiles = new HashMap<>();
        Set<String> configFileNames = configFiles.keySet();

        for (String configName: configFileNames)
        {
            YamlConfiguration configFile = YamlConfiguration.loadConfiguration(configFiles.get(configName));
            allConfigFiles.put (configName, configFile);
        }
        return allConfigFiles;
    }

    @Override
    public <T> T getNode(String configFileName, String nodeName, Class<T> clazz)
    {
        Set<String> configNames = allConfigFiles.keySet();
        for (String configName : configNames)
        {

            YamlConfiguration config = allConfigFiles.get(configName);
            //如果文件名和容器中的文件名不匹配就接触当前此次循环
            if (!configName.equals (configFileName))
                continue;
            //获取叶子节点的内容
            Object subNode = config.get(nodeName);
            //如果不为空就强制类型转换
            if (subNode != null)
                return (T)subNode;
        }

         //如果获取不到或者文件名未匹配成功就返回null
        return null;
    }




    //构建Config
    public void buildConfigs ()
    {
        Set<String> configNames = allConfigFiles.keySet();
        for (String configName : configNames)
        {
            this.configName = configName;

            //每当读取一个config时先清除单例配置
            singletonSettings.clear ();
            //每当读取一个config时先清除行动配置
            allAction.clear();

            //获取单例列表
            List<Map<String, String>> singleton = getSingleton();
            //获取多例列表拆分后的单例列表
            List<Map<String, String>> more = getMore();
            //获取所有action
            Map<String, String> actions = getActions();
            //如果没有这个节点
            if (singleton != null)
                singletonSettings.addAll (singleton);
            //如果没有这个节点
            if (more != null)
                singletonSettings.addAll (more);
            if (actions == null)
                throw new RuntimeException("名字：" + configName + "的配置文件，请function");

            allAction.putAll(actions);
            System.out.println(singleton);
            System.out.println(more);
            System.out.println(actions);
            //todo 这里可以输出一个日志
            //获取配置文件名字也就是命名空间

            new DefaultConfig(configName,singletonSettings,allAction);
        }

    }

    private Map<String, String> getActions ()
    {

        ConfigurationSection functionsNode = getNode(configName, FUNCTIONS, ConfigurationSection.class);
        Map<String, String> allNodeKeysValuesToMap = getAllNodeKeyValuesToMap(functionsNode, String.class);

        return allNodeKeysValuesToMap.isEmpty() ? null : allNodeKeysValuesToMap;
    }



    /**
     * 获取more的每个数字子节点的设置
     * 并拆分成单例存入单例配置容器中
     * @return
     */
    private List<Map<String, String>> getMore ()
    {


        //获取more节点
        ConfigurationSection moreNode = getNode (configName, SETTINGS + ".more",ConfigurationSection.class);

        if (moreNode == null)
            return null;
        //获取more节点的子节点的名字。但不包括子节点的子节点的名字
        Set<String> keys = moreNode.getKeys(false);

        //拆分
        List<Map<String, String>> splitValuesResult = null;

        for (String key: keys)
        {
            //获取数字子节点
            ConfigurationSection numberNode
                    = getNextNode( moreNode, key);

            //获取数字子节点的 {name: ["222","333","444"]}
            Map<String, ArrayList> allNodeKeyValuesListToMap = getAllNodeKeyValuesToMap(numberNode,ArrayList.class);
            splitValuesResult = splitValuesList(allNodeKeyValuesListToMap);

        }


        return splitValuesResult;
    }

    /**
     * 拆分more获取的StringKey和StringList
     *       name:
     *         - "222"
     *         - "333"
     *         - "444"
     *       size:
     *         - 22
     *         - 33
     *         - 44
     *       yPosition: [ 2221,3332,4443 ]
     *       =========================
     *       以此类推
     *       name:"222"
     *       size:22
     *       yPosition:2221
     * @param allNodeKeyValuesListToMap
     * @return List存放以例子为一组的map
     */
    private List<Map<String, String>> splitValuesList (Map<String, ArrayList> allNodeKeyValuesListToMap)
    {

        //List存放以例子为一组的map
        List<Map<String, String>> splitValuesResult = new ArrayList<>();
        //获取所有的key并转成List
        List<String> keys = allNodeKeyValuesListToMap.keySet().stream().toList();

        for (int i = 0; i < keys.size(); i++)
        {
            for (int o = 0; o < keys.size(); o++)
            {
                /**
                 * 规律
                 *  11 21 31
                 *  12 22 32
                 *  13 23 33
                 */
                //创建一个容器存放一组数据
                //每次都止存一组
                HashMap<String, String> keyValuesMap = new HashMap<>();

                List valuesList = allNodeKeyValuesListToMap.get(keys.get(o));
                String test  = valuesList.get(i).toString();
                //将数据存放
                keyValuesMap.put(keys.get(o),test );
                //添加至最终拆分结果中
                splitValuesResult.add(keyValuesMap);
            }
        }
        //返回
        return splitValuesResult;

    }
    private List<Map<String,String>> getSingleton ()
    {
        //创建临时变量存储 的key value
        //      name: "2"
        //      size: 32
        //      permission: ""
        //      yPosition: 100
        //获取settings.singleton下的部分
        ConfigurationSection singletonNode = getNode(configName
                , SETTINGS + ".singleton"
                , ConfigurationSection.class);

        if (singletonNode == null)
            return null;

        Set<String> keys = singletonNode.getKeys(false);
        for (String key: keys)
        {

           //获取子节点
            ConfigurationSection numberNode
                    = getNextNode (singletonNode,key);
            //获取子节点下的String类型的value。将key和value传回
            Map<String, String> numberNodeKeyValuesMap = getAllNodeKeyValuesToMap(numberNode,String.class);
            //将内容添加到单设置容器中
            singletonSettings.add (numberNodeKeyValuesMap);

        }
        return singletonSettings;

    }

    /**
     * 传入部分节点返回这个节点中所有的key value 但不包括节点
     * @param section 节点
     * @param clazz 类型
     * @return
     * @param <T> 类型
     */
    private <T> Map<String, T>  getAllNodeKeyValuesToMap (ConfigurationSection section,Class<T> clazz)
    {
        Map<String,T> nodeKeyValues = new HashMap();
        Set<String> keys = section.getKeys(true);
        for (String key: keys)
        {

            Object o = section.get(key);

            if (o instanceof ConfigurationSection)
                continue;
            //todo 可能出错。原因获取值的类型未必是ArrayList
            nodeKeyValues.put (key,(T)o);
        }
        return nodeKeyValues;

    }

    /**
     * 获取指定的节点的子节点
     * @param node
     * @param subNodeName
     * @return
     */
    private ConfigurationSection getNextNode (ConfigurationSection node,String subNodeName)
    {
        //获取此节点的当前地址
        String currentPath = node.getCurrentPath();
        //此节点拼接其子节点名
        String nextNodePath  = currentPath + "." + subNodeName;
        //通过getNode方法获取子节点
        return  getNode(configName, nextNodePath, ConfigurationSection.class);

    }

    public Map<String, YamlConfiguration> getAllConfigFiles()
    {
        return allConfigFiles;
    }

    public Map<String, String> getAllAction()
    {
        return allAction;
    }

    public List<Map<String, String>> getSingletonSettings()
    {
        return singletonSettings;
    }
}
