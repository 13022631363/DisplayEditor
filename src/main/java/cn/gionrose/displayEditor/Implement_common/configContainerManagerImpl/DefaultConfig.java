package cn.gionrose.displayEditor.Implement_common.configContainerManagerImpl;

import cn.gionrose.displayEditor.common.configContainerManager.Config;
import cn.gionrose.displayEditor.common.configContainerManager.ConfigContainer;
import cn.gionrose.displayEditor.common.interal.DisplayEditor;

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
    private Map<String, String> allAction;

    private ConfigContainer container = DisplayEditor.getApi().getConfigContainerManager().register
            (DisplayEditor.getApi().getConfigContainerManager().createContainer(this));



    public DefaultConfig (String namespace, List<Map<String, String>> settings,
                          Map<String, String> allAction)
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
    public Map<String, String> getAction()
    {
        return allAction;
    }

    @Override
    public ConfigContainer getConfigContainer()
    {
        return container;
    }

    @Override
    public String toString()
    {
        return "DefaultConfig{" +
                "namespace='" + namespace + '\'' +
                ", settings=" + settings +
                ", allAction=" + allAction +
                ", container=" + container +
                '}';
    }
}
