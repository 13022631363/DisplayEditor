package cn.gionrose.loki_face2wall.Implement_common.configContainerManagerImpl;

import cn.gionrose.loki_face2wall.common.configContainerManager.Config;
import cn.gionrose.loki_face2wall.common.configContainerManager.ConfigContainer;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author loki
 * @Date 2023/1/21 18:20
 */
public class DefaultConfig implements Config
{
    private String namespace;
    private List<Map<String, String>> settings;
    private ConcurrentHashMap<String, List<String>> allAction;


    public DefaultConfig (String namespace, List<Map<String, String>> settings,
                          ConcurrentHashMap<String, List<String>> allAction)
    {
        this.namespace = namespace;
        this.settings = settings;
        this.allAction = allAction;
    }
    @Override
    public String getNamespace()
    {
        return namespace;
    }

    @Override
    public String getFileName()
    {
        return namespace;
    }

    @Override
    public List<Map<String, String>>  getSettings()
    {
        return settings;
    }

    @Override
    public ConcurrentHashMap<String, List<String>> getAction()
    {
        return allAction;
    }

    @Override
    public ConfigContainer getConfigContainer()
    {
        return new DefaultConfigContainer(this);
    }
}
