package common.configContainerManager;

import java.util.Map;

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
    Config getConfig ();

    /**
     * 通过key获取value
     * @param dataName key
     * @return value
     * @param <T> 返回类型泛型
     */
    <T> T getData (String dataName);

    /**
     * 通过key来改变value
     * @param dataName key
     * @param value 提供的value
     * @param <T> 提供value的泛型类型
     */
    <T> void  changeData (String dataName, T value);

    /**
     * 获取所有key value
     * @return config内的所有keyvalue
     */
    Map<String, Object> getAllData ();



}
