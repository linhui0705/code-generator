package ${project.packageName}.controller;

import ${project.packageName}.model.${table.objectName?cap_first};
import ${project.packageName}.service.${table.objectName?cap_first}Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Title: ${table.objectName?cap_first}Controller
 * Description:
 *
 * @author ${project.author}
 * Created on ${.now?date}
 */
@RestController
@RequestMapping(value = "${table.objectName?uncap_first}")
public class ${table.objectName?cap_first}Controller {
    private static final Logger logger = LoggerFactory.getLogger(${table.objectName?cap_first}Controller.class);

    @Autowired
    private ${table.objectName?cap_first}Service ${table.objectName?uncap_first}Service;

}
