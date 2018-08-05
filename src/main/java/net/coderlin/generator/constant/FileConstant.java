package net.coderlin.generator.constant;

/**
 * Title: FileConstant
 * Description:
 *
 * @author Lin Hui
 * Created on 2018-8-5 14:32
 */
public class FileConstant {
    /**
     * 程序根路径
     */
    public static final String ROOT_PATH = System.getProperty("user.dir");

    /**
     * 配置文件路径
     */
    public static final String CONFIG_YML_PATH = ROOT_PATH + "/config.yml";

    /**
     * 模板文件夹路径
     */
    public static final String TEMPLATE_PATH = ROOT_PATH + "/templates";

    /**
     * 导出生成代码路径
     */
    public static final String OUT_PATH = ROOT_PATH + "/out";
}
