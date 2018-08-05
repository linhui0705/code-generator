<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${project.packageName}.mapper.${table.objectName?cap_first}Mapper">
    <resultMap id="BaseResultMap" type="${project.packageName}.model.${table.objectName?cap_first}">
    <#list table.fields as field>
        <<#if field.columnName=="id">id<#else>result</#if> column="${field.columnName}" property="${field.name}"/>
    </#list>
    </resultMap>

    <sql id="BaseColumn">
    <#list table.fields as field>
        ${field.columnName}<#if field_has_next>,</#if>
    </#list>
    </sql>

    <sql id="BaseTable">
        ${table.tableName}
    </sql>

    <insert id="insert" resultMap="BaseResultMap">
        INSERT INTO <include refid="BaseTable"/>(<#list table.fields as field>${field.columnName}<#if field_has_next>,</#if></#list>)
        VALUES(<#list table.fields as field>${r'#{'}${field.name}${r'}'}<#if field_has_next>,</#if></#list>)
    </insert>

    <update id="delete">
        UPDATE <include refid="BaseTable"/>
        SET is_deleted = 1, gmt_modified = NOW()
        WHERE id = ${r'#{id}'}
    </update>

    <update id="update">
        UPDATE <include refid="BaseTable"/>
        SET <#list table.fields as field><#if !(field.columnName=="id"||field.columnName=="is_deleted"||field.columnName=="gmt_create"||field.columnName=="gmt_modified")>${field.columnName}=${r'#{'}${field.name}${r'}'}</#if><#if !(field.columnName=="id"||field.columnName=="is_deleted"||field.columnName=="gmt_create"||field.columnName=="gmt_modified")>,</#if></#list>gmt_modified=NOW()
        WHERE id = ${r'#{id}'}
    </update>

    <select id="list" resultMap="BaseResultMap">
        SELECT <include refid="BaseColumn"/>
        FROM <include refid="BaseTable"/>
    </select>
</mapper>