package common.configFileHelper;



/**
 * @Author loki
 * @Date 2023/1/14 22:49
 */
public interface SimpleConfigFileReader
{
    /**
     * 获取config文件中通过key获取value
     * @param nodeName key
     * @param configFileName 指定某个yamlConfigFile
     * @return value
     * @param <T> 返回的值的类型
     */
    <T> T getNode (String configFileName, String nodeName);

}
