package net.coderlin.generator.bean;

/**
 * Title: Config
 * Description:
 *
 * @author Lin Hui
 * Created on 2018-7-29 19:55
 */
public class Project {
    /**
     * 包路径
     */
    private String packageName;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 作者
     */
    private String author;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Project{" +
                "packageName='" + packageName + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
