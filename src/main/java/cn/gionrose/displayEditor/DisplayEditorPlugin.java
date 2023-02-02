package cn.gionrose.displayEditor;


import cn.gionrose.displayEditor.Implement_common.configFileHelperImpl.DefaultSimpleConfigFileReader;
import cn.gionrose.displayEditor.Implement_common.configFileHelperImpl.DefaultSimpleImageFileReader;
import cn.gionrose.displayEditor.Implement_common.interal.DefaultDisplayEditorApi;
import cn.gionrose.displayEditor.common.configContainerManager.ConfigContainer;
import cn.gionrose.displayEditor.common.interal.DisplayEditorApi;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @Author loki
 * @Date 2023/1/10 12:55
 */
public class DisplayEditorPlugin extends JavaPlugin
{
    private static JavaPlugin INSTANCE;

    @Override
    public void onEnable ()
    {
        INSTANCE = this;
        DisplayEditorApi defaultDisplayEditorApi = new DefaultDisplayEditorApi();

        DefaultSimpleConfigFileReader configFileReader = (DefaultSimpleConfigFileReader) defaultDisplayEditorApi.getFileHelper().getConfigFileReader();
        configFileReader.buildConfigs();

        List<ConfigContainer> all = defaultDisplayEditorApi.getConfigContainerManager().getAll();
        for (ConfigContainer configContainer: all)
        {
            System.out.println(configContainer.getConfig());
        }
        DefaultSimpleImageFileReader imageFileReader = (DefaultSimpleImageFileReader) defaultDisplayEditorApi.getFileHelper().getImageFileReader();
        Map<String, Map<String, File>> allImageFiles = imageFileReader.getAllImageFiles();
        Set<String> imageDirNames = allImageFiles.keySet();
        for (String imageDirName: imageDirNames)
        {
            Map<String, File> imageFiles = allImageFiles.get(imageDirName);
            Set<String> imageFileNames = imageFiles.keySet();
            for (String imageFileName: imageFileNames)
            {
                File file = imageFiles.get(imageFileName);
                System.out.println (file.getName());
            }
        }

    }
    @Override
    public void onDisable ()
    {

    }
    public static JavaPlugin getINSTANCE()
    {
        return INSTANCE;
    }
}
