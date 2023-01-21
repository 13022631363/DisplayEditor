package Implement_common;

import Implement_common.configFileHelperImpl.DefaultConfigFileHelper;
import common.DisplayEditor;
import common.DisplayEditorApi;
import common.configContainerManager.ConfigContainerManager;
import common.configFileHelper.ConfigFileHelper;
import common.functionHelper.FunctionHelper;
import common.hudManager.HudManager;
import common.logManager.LogManager;
import common.papiHelper.PapiHelper;

/**
 * @Author loki
 * @Date 2023/1/21 18:11
 */
public class DefaultDisplayEditorApi implements DisplayEditorApi
{
    private final ConfigFileHelper defaultConfigFileHelper = new DefaultConfigFileHelper();

    {
        DisplayEditor.register(this);
    }
    @Override
    public LogManager getLogManager()
    {
        return null;
    }

    @Override
    public ConfigFileHelper getConfigFileHelper()
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
        return null;
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
