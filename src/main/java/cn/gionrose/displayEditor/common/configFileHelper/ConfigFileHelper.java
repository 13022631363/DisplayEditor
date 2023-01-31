package cn.gionrose.displayEditor.common.configFileHelper;


import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @Author loki
 * @Date  2023/1/13 14:32
 */
public interface ConfigFileHelper
{
    /**
     * 配置文件读取器
     */
    SimpleConfigFileReader getConfigFileReader ();

    /**
     * 图片文件读取器
     */
    SimpleImageFileReader getImageFileReader ();

    /**
     * 图片和配置的文件校验器
     */
    SimpleFileChecker getFileChecker ();

    /**
     * 配置与图片写入器
     */
    SimpleFileWriter getFileWriter ();


    /**
     * 获取配置文件根目录
     */
    File getBaseConfigFolder ();


    /**
     * 发送日志
     */
    void sendLog (/*传入日志内容,*/ CommandSender sender);


    /**
     * 获取单个配置文件 (默认在BaseConfigFolder下获取)
     * @param fileName 文件名
     * @return 配置文件文件
     */
    YamlConfiguration getConfigFile (String fileName);

    /**
     * 获取多个配置文件
     * @param root 指定路径下
     * @return 所有的位置文件
     */
    Map<String, YamlConfiguration> getConfigFiles (File root);

    /**
     * 获取从配置文件根目录下
     * @return 所有的配置文件
     */
    Map<String, YamlConfiguration>  getConfigFiles ();


    /**
     * 移除文件名的后缀
     * @return
     */
    String getRemovePostfixConfigName (String configNameAndPostfix);

}
