package cn.gionrose.displayEditor.Implement_common.configFileHelperImpl;


import cn.gionrose.displayEditor.common.fileHelper.SimpleImageFileReader;
import cn.gionrose.displayEditor.common.interal.DisplayEditor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author loki
 * @Date 2023/2/1 21:40
 */
public class DefaultSimpleImageFileReader implements SimpleImageFileReader
{
    private final Map<String, Map<String ,File>> allImageFiles = new HashMap<>();
    private final Map<String, File> allConfigFilesFileType =
            ((DefaultSimpleConfigFileReader)
            DisplayEditor.getApi().getFileHelper().getConfigFileReader()).getAllConfigFilesFileType();

    {
        init();
    }
    private void init ()
    {
        Set<String> configNames = allConfigFilesFileType.keySet();

        for (String configName: configNames)
        {

            //当前yml文件的路径文件夹
            File theYmlFileParentFile = allConfigFilesFileType.get (configName).getParentFile();

            //读取当前yml文件所在文件夹的所有图片
            Map<String, File> imageFiles = DisplayEditor.getApi().getFileHelper().getFiles(theYmlFileParentFile, ".png");
            allImageFiles.put (configName, imageFiles);
        }

    }

    public Map<String, Map<String, File>> getAllImageFiles()
    {
        return allImageFiles;
    }
}
