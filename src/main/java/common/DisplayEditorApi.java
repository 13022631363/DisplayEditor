package common;

import common.configContainerManager.ConfigContainerManager;
import common.configFileHelper.ConfigFileHelper;
import common.functionHelper.FunctionHelper;
import common.hudManager.HudManager;
import common.logManager.LogManager;
import common.papiHelper.PapiHelper;

/**
 * @Author loki
 * @Date 2023/1/13 13:57
 */
public interface DisplayEditorApi
{
    /**
     * 日志管理器
     * 各个行为后的日志输出
     */
    LogManager getLogManager ();

    /**
     * 配置文件工具
     * 读取配置文件
     * 校验文件信息
     *
     */
    ConfigFileHelper getConfigFileHelper ();

    /**
     * 1.解析配置文件的逻辑
     * 2.执行逻辑
     */
    FunctionHelper getFunctionHelper ();

    /**
     * 1.存放配置文件内容
     * 2.存放图片名称信息
     */
    ConfigContainerManager getConfigContainerManager ();

    /**
     * hud管理器
     * hud的装配和执行
     */
    HudManager getHudManager ();

    /**
     * papi插件助手
     * 一些papi的操作
     */
    PapiHelper getPapiHelper ();


}
