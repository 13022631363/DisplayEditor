package cn.gionrose.loki_face2wall.Implement_common.interal;

import cn.gionrose.loki_face2wall.Implement_common.configFileHelperImpl.DefaultConfigFileHelper;

import cn.gionrose.loki_face2wall.common.configContainerManager.ConfigContainerManager;
import cn.gionrose.loki_face2wall.common.configFileHelper.ConfigFileHelper;
import cn.gionrose.loki_face2wall.common.functionHelper.FunctionHelper;
import cn.gionrose.loki_face2wall.common.hudManager.HudManager;
import cn.gionrose.loki_face2wall.common.interal.DisplayEditor;
import cn.gionrose.loki_face2wall.common.interal.DisplayEditorApi;
import cn.gionrose.loki_face2wall.common.logManager.LogManager;
import cn.gionrose.loki_face2wall.common.papiHelper.PapiHelper;

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
