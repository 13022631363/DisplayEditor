package common.configContainerManager;

/**
 * @Author loki
 * @Date 2023/1/13 14:35
 */
public interface ConfigContainerManager
{
    /**
     * 获取配置文件容器
     * @return 返回配置文件容器
     */
    ConfigContainer createContainer (/*放入配置文件对象*/);

    /**
     * 注册配置文件容器到配置文件管理器的总容器中
     * @return
     */
    ConfigContainer register (/*放入配置文件容器*/);

    void unregister ();

}
