package cn.gionrose.displayEditor.common.configContainerManager;


import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author loki
 * @Date 2023/1/19 13:11
 */
public interface Config
{
    /**
     * 获取主命名空间
     * @return
     */
    String getNamespace ();

    /**
     * 获取文件名，与命名空间为同一个
     * @return
     */
    String getFileName ();

    /**
     * 获取设置信息
     * @return
     */
    List<Map<String, String>>  getSettings ();

    /**
     * 获取函数行为
     * @return
     */
    Map<String, String> getAction ();

    /**
     * 获取配置的容器
     * @return
     */
    ConfigContainer getConfigContainer ();

}
