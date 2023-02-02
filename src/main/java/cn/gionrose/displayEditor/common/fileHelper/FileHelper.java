package cn.gionrose.displayEditor.common.fileHelper;


import org.bukkit.command.CommandSender;

import java.io.File;
import java.util.Map;

/**
 * @Author loki
 * @Date  2023/1/13 14:32
 */
public interface FileHelper
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
    File getFile (String fileName);

    /**
     * 获取多个配置文件
     * @param postFix 指定后缀的文件
     * @param root 指定路径下
     * @return 所有的位置文件
     */
    Map<String, File> getFiles (File root, String postFix);
    /*

      这里的getFiles和上面的其实并不应该在这个类的功能中
      后期修改成定义一个fileReader接口
      然后configFileReader和imageFileReader来继承并实现这几个方法
     */
    /**
     * 获取从配置文件根目录下
     * @param postFix 指定后缀的文件
     * @return 所有的配置文件
     */
    Map<String, File>  getFiles (String postFix);


    /**
     * 移除文件名的后缀
     * @return
     */
    String getRemovePostfixName (String configNameAndPostfix);

}
