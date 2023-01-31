package cn.gionrose.displayEditor;


import cn.gionrose.displayEditor.Implement_common.configFileHelperImpl.DefaultSimpleConfigFileReader;
import cn.gionrose.displayEditor.Implement_common.interal.DefaultDisplayEditorApi;
import cn.gionrose.displayEditor.common.configContainerManager.Config;
import cn.gionrose.displayEditor.common.configContainerManager.ConfigContainer;
import cn.gionrose.displayEditor.common.configFileHelper.SimpleConfigFileReader;
import cn.gionrose.displayEditor.common.interal.DisplayEditor;
import cn.gionrose.displayEditor.common.interal.DisplayEditorApi;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;


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

        DefaultSimpleConfigFileReader configFileReader = (DefaultSimpleConfigFileReader) defaultDisplayEditorApi.getConfigFileHelper().getConfigFileReader();
        configFileReader.buildConfigs();

        List<ConfigContainer> all = defaultDisplayEditorApi.getConfigContainerManager().getAll();
        for (ConfigContainer configContainer: all)
        {
            System.out.println(configContainer.getConfig());
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
