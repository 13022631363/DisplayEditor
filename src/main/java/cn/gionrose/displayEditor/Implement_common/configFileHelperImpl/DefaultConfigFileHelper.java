package cn.gionrose.displayEditor.Implement_common.configFileHelperImpl;


import cn.gionrose.displayEditor.DisplayEditorPlugin;
import cn.gionrose.displayEditor.common.configFileHelper.*;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author loki
 * @Date 2023/1/20 22:12
 */
public class DefaultConfigFileHelper implements ConfigFileHelper
{
    private final File baseConfigFolder = new File (DisplayEditorPlugin.getINSTANCE().getDataFolder() ,"Customized");;
    @Override
    public SimpleConfigFileReader getConfigFileReader()
    {
        return new DefaultSimpleConfigFileReader();
    }

    @Override
    public SimpleImageFileReader getImageFileReader()
    {
        return new DefaultSimpleImageFileReader();
    }

    @Override
    public SimpleFileChecker getFileChecker()
    {
        return null;
    }

    @Override
    public SimpleFileWriter getFileWriter()
    {
        return null;
    }

    @Override
    public File getBaseConfigFolder()
    {
        return baseConfigFolder;
    }

    @Override
    public void sendLog(CommandSender sender)
    {

    }

    @Override
    public File getFile(String fileName)
    {
        return new File (baseConfigFolder,fileName);
    }

    @Override
    public Map<String, File> getFiles(File root, String postFix)
    {
        //创建临时容器
        Map<String, File> fileMap = new HashMap<>();
        //判断提供的路径文件是否是文件夹类型
        if (!root.isDirectory())
        {
            //如果不是就结束并返回空
            return null;
        }
        //如果是文件夹就获取它包下所有的文件
        File[] fileArray = root.listFiles();
        //遍历
        for (File file : fileArray)
        {
            String nameAndPostfix = file.getName();
            //递归将所有yml文件返回
            Map<String, File> returnFileMap =
                    getFiles(new File(root, file.getName ()),postFix);
            //如果返回不为空
            //代表是文件夹或者存在yml文件
            if (returnFileMap != null)
            {
                //就合并
                fileMap.putAll (returnFileMap);
            }

            //这个是文件并且是yml文件
            if (nameAndPostfix.contains (postFix)) //就存入临时容器中
                fileMap.put (getRemovePostfixName(nameAndPostfix), file);
        }

        return fileMap;
    }

    @Override
    public Map<String, File> getFiles(String postFix)
    {
        return getFiles(baseConfigFolder, postFix);
    }

    @Override
    public String getRemovePostfixName(String nameAndPostfix)
    {

        //获取.的下标
        int pointIndex = nameAndPostfix.indexOf(".");
        //截取开始到.的所有字符 xxx 也就是文件名
        return nameAndPostfix.substring(0, pointIndex);
    }
}
