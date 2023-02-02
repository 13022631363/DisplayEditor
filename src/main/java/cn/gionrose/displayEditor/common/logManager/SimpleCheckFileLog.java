package cn.gionrose.displayEditor.common.logManager;

import java.util.List;

/**
 * @Author loki
 * @Date 2023/2/2 23:36
 */
public interface SimpleCheckFileLog
{
    /**
     * @return 获取某个yml中对应缺少的图片文件名
     */
    List<String> getNames ();



}
