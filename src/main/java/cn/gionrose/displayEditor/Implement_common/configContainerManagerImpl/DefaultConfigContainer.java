package cn.gionrose.displayEditor.Implement_common.configContainerManagerImpl;

import cn.gionrose.displayEditor.common.configContainerManager.Config;
import cn.gionrose.displayEditor.common.configContainerManager.ConfigContainer;

import java.util.Map;

/**
 * @Author loki
 * @Date 2023/1/21 18:41
 */
public class DefaultConfigContainer implements ConfigContainer
{
    private Config config;

    public DefaultConfigContainer (Config config)
    {
        this.config = config;
    }
    @Override
    public String getName()
    {
        return config.getFileName();
    }

    @Override
    public Config getConfig()
    {
        return config;
    }

    @Override
    public <T> T getData(String dataName)
    {
        return null;
    }

    @Override
    public <T> void changeData(String dataName, T value)
    {

    }

    @Override
    public Map<String, Object> getAllData()
    {
        return null;
    }
}
