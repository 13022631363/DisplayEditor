package common.configContainerManager;

/**
 * @Author loki
 * @Date 2023/1/14 23:36
 */
public interface ConfigContainer
{
    /**
     * 配置文件名字
     * @return
     */
    String getName ();

    /**
     * 获取配置文件对象
     */
    void getConfig ();


}
