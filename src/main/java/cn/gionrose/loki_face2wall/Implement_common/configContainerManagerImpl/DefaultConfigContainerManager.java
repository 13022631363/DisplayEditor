package cn.gionrose.loki_face2wall.Implement_common.configContainerManagerImpl;

import cn.gionrose.loki_face2wall.common.configContainerManager.Config;
import cn.gionrose.loki_face2wall.common.configContainerManager.ConfigContainer;
import cn.gionrose.loki_face2wall.common.configContainerManager.ConfigContainerManager;

import java.util.List;

/**
 * @Author loki
 * @Date 2023/1/21 18:43
 */
public class DefaultConfigContainerManager implements ConfigContainerManager
{
    private List<ConfigContainer> allConfigContainer;
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
        return config.getConfigContainer();

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
