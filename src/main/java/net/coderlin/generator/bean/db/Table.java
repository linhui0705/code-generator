package net.coderlin.generator.bean.db;

import net.coderlin.generator.util.StringUtil;

import java.util.List;

/**
 * Title: Table
 * Description:
 * 数据库表
 *
 * @author Lin Hui
 * Created on 2018-7-29 17:51
 */
public class Table {
    public Table() {
    }

    public Table(String tableName) {
        this.tableName = tableName;
        this.objectName = StringUtil.convertTable(tableName);
    }

    public Table(String tableName, String comment) {
        this.tableName = tableName;
        this.comment = comment;
        this.objectName = StringUtil.convertTable(tableName);
    }

    /**
     * 数据库表名称
     */
    private String tableName;

    /**
     * 数据库表注释
     */
    private String comment;

    /**
     * 对象名称
     */
    private String objectName;

    /**
     * 字段List
     */
    private List<Field> fields;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
        this.objectName = StringUtil.convertTable(tableName);
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableName='" + tableName + '\'' +
                ", comment='" + comment + '\'' +
                ", objectName='" + objectName + '\'' +
                ", fields=" + fields +
                '}';
    }
}
