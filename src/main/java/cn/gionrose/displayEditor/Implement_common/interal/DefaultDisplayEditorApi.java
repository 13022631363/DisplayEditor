package cn.gionrose.displayEditor.Implement_common.interal;

import cn.gionrose.displayEditor.Implement_common.configContainerManagerImpl.DefaultConfigContainerManager;
import cn.gionrose.displayEditor.Implement_common.configFileHelperImpl.DefaultConfigFileHelper;

import cn.gionrose.displayEditor.common.configContainerManager.ConfigContainerManager;
import cn.gionrose.displayEditor.common.fileHelper.FileHelper;
import cn.gionrose.displayEditor.common.functionHelper.FunctionHelper;
import cn.gionrose.displayEditor.common.hudManager.HudManager;
import cn.gionrose.displayEditor.common.interal.DisplayEditor;
import cn.gionrose.displayEditor.common.interal.DisplayEditorApi;
import cn.gionrose.displayEditor.common.logManager.LogManager;
import cn.gionrose.displayEditor.common.papiHelper.PapiHelper;

/**
 * @Author loki
 * @Date 2023/1/21 18:11
 */
public class DefaultDisplayEditorApi implements DisplayEditorApi
{
    private final FileHelper defaultConfigFileHelper = new DefaultConfigFileHelper();
    private final ConfigContainerManager defaultConfigContainerManager = new DefaultConfigContainerManager();

    {
        DisplayEditor.register(this);
    }
    @Override
    public LogManager getLogManager()
    {
        return null;
    }

    @Override
    public FileHelper getFileHelper()
    {
        return defaultConfigFileHelper;
    }

    @Override
    public FunctionHelper getFunctionHelper()
    {
        return null;
    }

    @Override
    public ConfigContainerManager getConfigContainerManager()
    {
        return defaultConfigContainerManager;
    }

    @Override
    public HudManager getHudManager()
    {
        return null;
    }

    @Override
    public PapiHelper getPapiHelper()
    {
        return null;
    }
}
