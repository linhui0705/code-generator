package net.coderlin.generator.bean.db;

import net.coderlin.generator.util.StringUtil;
import net.coderlin.generator.util.TypeUtil;

/**
 * Title: Field
 * Description:
 * 数据库字段
 *
 * @author Lin Hui
 * Created on 2018-7-29 12:28
 */
public class Field {

    /**
     * 数据库字段名称
     */
    private String columnName;

    /**
     * 数据库字段类型
     */
    private String dbType;

    /**
     * 字段长度
     */
    private Integer columnSize;

    /**
     * 小数点
     */
    private Integer decimalDigits;

    /**
     * 是否为空
     */
    private Boolean nullable;

    /**
     * 数据库字段注释
     */
    private String remark;

    /**
     * Java类变量名称
     */
    private String name;

    /**
     * Java类字段类型
     */
    private String javaType;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
        this.name = StringUtil.convertColumn(columnName);
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
        this.javaType = TypeUtil.convertToJavaType(dbType);
    }

    public Integer getColumnSize() {
        return columnSize;
    }

    public void setColumnSize(Integer columnSize) {
        this.columnSize = columnSize;
    }

    public Integer getDecimalDigits() {
        return decimalDigits;
    }

    public void setDecimalDigits(Integer decimalDigits) {
        this.decimalDigits = decimalDigits;
    }

    public Boolean getNullable() {
        return nullable;
    }

    public void setNullable(Boolean nullable) {
        this.nullable = nullable;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    @Override
    public String toString() {
        return "Field{" +
                "columnName='" + columnName + '\'' +
                ", dbType='" + dbType + '\'' +
                ", columnSize=" + columnSize +
                ", decimalDigits=" + decimalDigits +
                ", nullable=" + nullable +
                ", remark='" + remark + '\'' +
                ", name='" + name + '\'' +
                ", javaType='" + javaType + '\'' +
                '}';
    }
}
