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
        List<YamlConfiguration> configFileList = new ArrayList<>();

        if (!root.isDirectory())
        {

            return null;
        }

        File[] configFileArray = root.listFiles();

        for (File aConfigFile : configFileArray)
        {
            List<YamlConfiguration> returnConfigFileList =
                    getConfigFiles(new File(root, aConfigFile.getName ()));

            if (returnConfigFileList != null)
            {
                configFileList.addAll (returnConfigFileList);
            }


            if (aConfigFile.getName().contains (".yml"))
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
