package net.coderlin.generator.bean;

import java.util.List;

/**
 * Title: BaseConfig
 * Description:
 *
 * @author Lin Hui
 * Created on 2018-7-29 19:57
 */
public class BaseConfig {
    /**
     * 数据源配置
     */
    private DbConfig dataSource;

    /**
     * 项目参数
     */
    private Project project;

    /**
     * 指定生成的表
     */
    private List<String> tables;

    /**
     * 模板配置
     */
    private List<TemplateFile> templates;

    public DbConfig getDataSource() {
        return dataSource;
    }

    public void setDataSource(DbConfig dataSource) {
        this.dataSource = dataSource;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<String> getTables() {
        return tables;
    }

    public void setTables(List<String> tables) {
        this.tables = tables;
    }

    public List<TemplateFile> getTemplates() {
        return templates;
    }

    public void setTemplates(List<TemplateFile> templates) {
        this.templates = templates;
    }

    @Override
    public String toString() {
        return "BaseConfig{" +
                "dataSource=" + dataSource +
                ", project=" + project +
                ", tables=" + tables +
                ", templates=" + templates +
                '}';
    }
}
