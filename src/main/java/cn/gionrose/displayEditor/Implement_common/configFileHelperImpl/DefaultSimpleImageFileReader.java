package cn.gionrose.displayEditor.Implement_common.configFileHelperImpl;


import cn.gionrose.displayEditor.common.configFileHelper.SimpleImageFileReader;
import cn.gionrose.displayEditor.common.interal.DisplayEditor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author loki
 * @Date 2023/2/1 21:40
 */
public class DefaultSimpleImageFileReader implements SimpleImageFileReader
{
    private  Map<String, Map<String ,File>> allImageFiles = new HashMap<>();
    private final Map<String , YamlConfiguration> allConfigFiles  =
            ((DefaultSimpleConfigFileReader) DisplayEditor.getApi().getConfigFileHelper().getConfigFileReader()).getAllConfigFiles();

    {
        init();
    }
    private void init ()
    {
        Set<String> configNames = allConfigFiles.keySet();

        for (String configName: configNames)
        {

            //当前yml文件的路径
            File file = new File(allConfigFiles.get(configName).getCurrentPath());
            //读取当前yml文件所在文件夹的所有图片
            Map<String, File> imageFiles = DisplayEditor.getApi().getConfigFileHelper().getFiles(file, ".png");
            allImageFiles.put (configName, imageFiles);
        }

    }

    public Map<String, Map<String, File>> getAllImageFiles()
    {
        return allImageFiles;
    }
}
