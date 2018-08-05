package ${project.packageName}.mapper;

import ${project.packageName}.model.${table.objectName?cap_first};

import java.util.List;

/**
 * Title: ${table.objectName?cap_first}Mapper
 * Description:
 *
 * @author ${project.author}
 * Created on ${.now?date}
 */
public interface ${table.objectName?cap_first}Mapper {
    int insert(${table.objectName?cap_first} ${table.objectName?uncap_first});

    int delete(Long id);

    int update(${table.objectName?cap_first} ${table.objectName?uncap_first});

    List<${table.objectName?cap_first}> list();
}