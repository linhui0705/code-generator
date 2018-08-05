package net.coderlin.generator;

import com.esotericsoftware.yamlbeans.YamlException;
import freemarker.template.TemplateException;
import net.coderlin.generator.bean.BaseConfig;
import net.coderlin.generator.bean.TemplateFile;
import net.coderlin.generator.bean.db.Field;
import net.coderlin.generator.bean.db.Table;
import net.coderlin.generator.constant.FileConstant;
import net.coderlin.generator.handler.DbHandler;
import net.coderlin.generator.handler.TemplateHandler;
import net.coderlin.generator.handler.YamlHandler;
import net.coderlin.generator.util.CollectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Title: Main
 * Description:
 *
 * @author Lin Hui
 * Created on 2018-8-5 14:22
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException, TemplateException {
        YamlHandler yamlHandler = new YamlHandler();
        BaseConfig config = yamlHandler.readConfig(FileConstant.CONFIG_YML_PATH);

        //数据库连接
        DbHandler dbHandler = DbHandler.getInstance(config.getDataSource());

        //扫描表和字段
        List<Table> tables;
        List<String> selectedTables = config.getTables();
        if (CollectionUtil.isEmpty(selectedTables)) {
            tables = dbHandler.scanTables();
        } else {
            tables = dbHandler.scanTables(selectedTables);
        }

        //输出扫描数据库表结果
        for (Table table : tables) {
            logger.info("----- {} START -----", table.getTableName());
            table.getFields().forEach(field -> logger.info(field.toString()));
            logger.info("----- {} END -----", table.getTableName());
        }

        //获取导出模板
        TemplateHandler templateHandler = TemplateHandler.getInstance(config.getProject());

        File templateFolder = new File(FileConstant.TEMPLATE_PATH);
        if (!templateFolder.exists()) {
            logger.error("找不到模板文件夹");
            throw new RuntimeException("找不到模板文件夹");
        }
        List<TemplateFile> templateFiles = config.getTemplates();
        for (TemplateFile templateFile : templateFiles) {
            templateHandler.generateCode(templateFile, tables);
        }

        //关闭数据库连接
        dbHandler.close();
    }
}
