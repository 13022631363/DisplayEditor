package cn.gionrose.displayEditor.Implement_common.configFileHelperImpl;


import cn.gionrose.displayEditor.DisplayEditorPlugin;
import cn.gionrose.displayEditor.common.configFileHelper.*;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author loki
 * @Date 2023/1/20 22:12
 */
public class DefaultConfigFileHelper implements ConfigFileHelper
{
    private final File baseConfigFolder = new File (DisplayEditorPlugin.getINSTANCE().getDataFolder() ,"Customized");;
    @Override
    public SimpleConfigFileReader getConfigFileReader()
    {
        return new DefaultSimpleConfigFileReader();
    }

    @Override
    public SimpleImageFileReader getImageFileReader()
    {
        return null;
    }

    @Override
    public SimpleFileChecker getFileChecker()
    {
        return null;
    }

    @Override
    public SimpleFileWriter getFileWriter()
    {
        return null;
    }

    @Override
    public File getBaseConfigFolder()
    {
        return baseConfigFolder;
    }

    @Override
    public void sendLog(CommandSender sender)
    {

    }

    @Override
    public YamlConfiguration getConfigFile(String fileName)
    {
        return YamlConfiguration.loadConfiguration(new File (baseConfigFolder,fileName));
    }

    @Override
    public Map<String, YamlConfiguration> getConfigFiles(File root)
    {
        //创建临时容器
        Map<String, YamlConfiguration> configFileMap = new HashMap<>();
        //判断提供的路径文件是否是文件夹类型
        if (!root.isDirectory())
        {
            //如果不是就结束并返回空
            return null;
        }
        //如果是文件夹就获取它包下所有的文件
        File[] configFileArray = root.listFiles();
        //遍历
        for (File aConfigFile : configFileArray)
        {
            String configNameAndPostfix = aConfigFile.getName();
            //递归将所有yml文件返回
            Map<String, YamlConfiguration> returnConfigFileMap =
                    getConfigFiles(new File(root, aConfigFile.getName ()));
            //如果返回不为空
            //代表是文件夹或者存在yml文件
            if (returnConfigFileMap != null)
            {
                //就合并
                configFileMap.putAll (returnConfigFileMap);
            }

            //这个是文件并且是yml文件
            if (configNameAndPostfix.contains (".yml")) //就存入临时容器中
                configFileMap.put (getRemovePostfixConfigName(configNameAndPostfix), YamlConfiguration.loadConfiguration(aConfigFile));
        }

        return configFileMap;
    }

    @Override
    public Map<String, YamlConfiguration> getConfigFiles()
    {
        return getConfigFiles(baseConfigFolder);
    }

    @Override
    public String getRemovePostfixConfigName(String configNameAndPostfix)
    {

        //获取.的下标
        int pointIndex = configNameAndPostfix.indexOf(".");
        //截取开始到.的所有字符 xxx 也就是文件名
        return configNameAndPostfix.substring(0, pointIndex);
    }
}
