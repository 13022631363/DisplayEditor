package common.configContainerManager;

import java.util.List;

/**
 * @Author loki
 * @Date 2023/1/13 14:35
 */
public interface ConfigContainerManager
{
    /**
     * 获取所有配置文件容器
     * @return 所有配置文件容器
     */
    List<ConfigContainer> getAll ();
    /**
     * 通过命名空间或者配置文件名来获取配置文件容器
     * @param FileNameOrNamespace 命名空间或者配置文件名
     * @return 配置文件容器
     */
    ConfigContainer getConfigContainer (String FileNameOrNamespace);
    /**
     * 获取配置文件容器
     * @param config 配置文件对象
     *  @return 返回配置文件容器
     */
    ConfigContainer createContainer (Config config);

    /**
     * 注册配置文件容器到配置文件管理器的总容器中
     * @param configContainer 配置文件容器
     * @return 配置文件容器
     */
    ConfigContainer register (ConfigContainer configContainer);

    /**
     * 在配置文件总容器中删除某个配置文件容器
     * @param configContainer 要删除的配置文件容器
     */
    void unregister (ConfigContainer configContainer);

}
