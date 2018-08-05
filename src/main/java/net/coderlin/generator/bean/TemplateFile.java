package net.coderlin.generator.bean;

/**
 * Title: TemplateFile
 * Description:
 *
 * @author Lin Hui
 * Created on 2018-8-5 13:50
 */
public class TemplateFile {
    /**
     * 模板文件名称
     */
    private String fileName;

    /**
     * 文件名前缀
     */
    private String prefix;

    /**
     * 文件名后缀
     */
    private String suffix;

    /**
     * 导出扩展名
     */
    private String extension;

    /**
     * 导出路径
     */
    private String exportPath;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getExportPath() {
        return exportPath;
    }

    public void setExportPath(String exportPath) {
        this.exportPath = exportPath;
    }

    @Override
    public String toString() {
        return "TemplateFile{" +
                "fileName='" + fileName + '\'' +
                ", prefix='" + prefix + '\'' +
                ", suffix='" + suffix + '\'' +
                ", extension='" + extension + '\'' +
                ", exportPath='" + exportPath + '\'' +
                '}';
    }
}
