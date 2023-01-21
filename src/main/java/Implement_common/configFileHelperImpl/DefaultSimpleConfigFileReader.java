package Implement_common.configFileHelperImpl;


import common.DisplayEditor;
import common.configContainerManager.Config;
import common.configFileHelper.SimpleConfigFileReader;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.file.YamlConfigurationOptions;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @Author loki
 * @Date 2023/1/20 22:02
 */
public class DefaultSimpleConfigFileReader implements SimpleConfigFileReader
{
    private List<YamlConfiguration> AllConfigFiles = DisplayEditor.getApi().getConfigFileHelper().getConfigFiles();
    private final String ACTION = "action";
    private final String SETTINGS = "settings";


    private final String MORE = "more";


    @Override
    public <T> T getNode(String configFileName, String nodeName, Class<T> clazz)
    {
         for (YamlConfiguration config: AllConfigFiles)
         {
             //获取config文件的名字 xxx.yml
             String configNameAndPostfix = config.getName();
             //获取.的下标
             int pointIndex = configNameAndPostfix.indexOf(".");
             //截取开始到.的所有字符 xxx 也就是文件名
             String configName = configNameAndPostfix.substring(0, pointIndex);

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
    public Config buildConfig ()
    {
        List<Map<String, String>>  settings
                = new ArrayList<>();
        ConcurrentHashMap<String, List<String>> allAction
                = new ConcurrentHashMap<>();

        for (YamlConfiguration config: AllConfigFiles)
        {
            List<Map<String, String>> singletonSettings = getSingleton(config);
        }
        return null;
    }
    private List<Map<String, String>> getMore (YamlConfiguration config)
    {
        //todo
        return null;
    }
    private List<Map<String,String>> getSingleton (YamlConfiguration config)
    {
        //创建临时变量存储 的key value
        //      name: "2"
        //      size: 32
        //      permission: ""
        //      yPosition: 100
        List<Map<String,String>> singletonSettings = new ArrayList<>();
        String configName = config.getName();

        //获取settings.singleton下的部分
        ConfigurationSection singletonNode = getNode(config.getName()
                , SETTINGS + ".singleton"
                , ConfigurationSection.class);
        Set<String> keys = singletonNode.getKeys(false);
        for (String key: keys)
        {

            String currentPath = singletonNode.getCurrentPath();
            String currentNextNodePath = currentPath + "." + key;
            ConfigurationSection numberNode
                    = getNode(configName, currentNextNodePath, ConfigurationSection.class);

            Map<String, String> numberNodeKeyValuesMap = getAllNodeKeyValuesToMap(numberNode, String.class);
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
    public <T> Map<String, T>  getAllNodeKeyValuesToMap (ConfigurationSection section,Class<T> clazz)
    {
        HashMap<String,T> nodeKeyValues = new HashMap();
        Set<String> keys = section.getKeys(true);
        for (String key: keys)
        {
            String nextPath = section.getCurrentPath() + "." + key;
            Object o = section.get(nextPath);

            if (o instanceof ConfigurationSection)
                continue;

            nodeKeyValues.put (key,(T)o);
        }
        return nodeKeyValues;

    }

}
