package cn.gionrose.displayEditor.Implement_common.configContainerManagerImpl;

import cn.gionrose.displayEditor.common.configContainerManager.Config;
import cn.gionrose.displayEditor.common.configContainerManager.ConfigContainer;
import cn.gionrose.displayEditor.common.configContainerManager.ConfigContainerManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author loki
 * @Date 2023/1/21 18:43
 */
public class DefaultConfigContainerManager implements ConfigContainerManager
{
    private List<ConfigContainer> allConfigContainer = new ArrayList<>();
    @Override
    public List<ConfigContainer> getAll()
    {
        return allConfigContainer;
    }

    @Override
    public ConfigContainer getConfigContainer(String fileNameOrNamespace)
    {
        for (ConfigContainer configContainer: allConfigContainer )
        {
            String fileName = configContainer.getConfig().getFileName();

            if (fileName.equals(fileNameOrNamespace))
                return configContainer;
        }
        return null;
    }

    @Override
    public ConfigContainer createContainer(Config config)
    {
        return new DefaultConfigContainer(config);

    }

    @Override
    public ConfigContainer register(ConfigContainer configContainer)
    {
        allConfigContainer.add(configContainer);
        return configContainer;
    }

    @Override
    public void unregister(ConfigContainer configContainer)
    {
        allConfigContainer.remove(configContainer);
    }
}
