package cn.gionrose.loki_face2wall;


import org.bukkit.plugin.java.JavaPlugin;



/**
 * @Author loki
 * @Date 2023/1/10 12:55
 */
public class DisplayEditorPlugin extends JavaPlugin
{
    private static JavaPlugin INSTANCE;

    @Override
    public void onEnable ()
    {
        INSTANCE = this;
    }
    @Override
    public void onDisable ()
    {

    }
    public static JavaPlugin getINSTANCE()
    {
        return INSTANCE;
    }
}
