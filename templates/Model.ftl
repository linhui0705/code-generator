package ${project.packageName}.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Title: ${table.objectName?cap_first}
 * Table: ${table.tableName}
 *
 * @author ${project.author}
 * Created on ${.now?date}
 */
public class ${table.objectName?cap_first} {
<#list table.fields as field>
    /**
     * 数据库字段: ${field.columnName}
     * <#if field.remark??>数据库备注: ${field.remark}</#if>
     * ${field.dbType}(${field.columnSize},${field.decimalDigits})
     */
    private ${field.javaType} ${field.name};
</#list>

<#list table.fields as field>
    public void set${field.name?cap_first}(${field.javaType} ${field.name}){
        this.${field.name} = ${field.name};
    }

    public ${field.javaType} get${field.name?cap_first}(){
        return this.${field.name};
    }

</#list>
}