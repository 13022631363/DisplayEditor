package Implement_common.configFileHelperImpl;


import Implement_common.DisplayEditorPlugin;
import common.configFileHelper.*;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author loki
 * @Date 2023/1/20 22:12
 */
public class DefaultConfigFileHelper implements ConfigFileHelper
{
    private File baseConfigFolder;
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
        return baseConfigFolder = new File (DisplayEditorPlugin.getINSTANCE().getDataFolder() ,"Customized");
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
    public List<YamlConfiguration> getConfigFiles(File root)
    {
        //创建临时容器
        List<YamlConfiguration> configFileList = new ArrayList<>();
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
            //递归将所有yml文件返回
            List<YamlConfiguration> returnConfigFileList =
                    getConfigFiles(new File(root, aConfigFile.getName ()));
            //如果返回不为空
            //代表是文件夹或者存在yml文件
            if (returnConfigFileList != null)
            {
                //就合并
                configFileList.addAll (returnConfigFileList);
            }

            //这个是文件并且是yml文件
            if (aConfigFile.getName().contains (".yml")) //就存入临时容器中
                configFileList.add (YamlConfiguration.loadConfiguration(aConfigFile));
        }

        return configFileList;
    }

    @Override
    public List<YamlConfiguration> getConfigFiles()
    {
        return getConfigFiles(baseConfigFolder);
    }
}
