package cn.gionrose.loki_face2wall.common.interal;



/**
 * @Author loki
 * @Date 2023/1/13 14:19
 */
public class DisplayEditor
{
    private static DisplayEditorApi api;

    public static DisplayEditorApi getApi ()
    {
        if (api == null)
            throw new RuntimeException("DisplayEditor可能未加载");
        return api;
    }
    public static void register (DisplayEditorApi api)
    {
        DisplayEditor.api = api;
    }
}
