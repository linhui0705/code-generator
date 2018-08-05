package ${project.packageName}.service.impl;

import ${project.packageName}.mapper.${table.objectName?cap_first}Mapper;
import ${project.packageName}.model.${table.objectName?cap_first};
import ${project.packageName}.service.${table.objectName?cap_first}Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title: ${table.objectName?cap_first}ServiceImpl
 * Description:
 *
 * @author ${project.author}
 * Created on ${.now?date}
 */
@Service(value = "${table.objectName?uncap_first}Service")
public class ${table.objectName?cap_first}ServiceImpl implements ${table.objectName?cap_first}Service {
    private static final Logger logger = LoggerFactory.getLogger(${table.objectName?cap_first}ServiceImpl.class);

    @Autowired
    private ${table.objectName?cap_first}Mapper ${table.objectName?uncap_first}Mapper;

}
