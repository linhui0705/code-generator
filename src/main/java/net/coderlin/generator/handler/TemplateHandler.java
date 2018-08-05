package net.coderlin.generator.handler;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import net.coderlin.generator.bean.Project;
import net.coderlin.generator.bean.TemplateFile;
import net.coderlin.generator.bean.db.Table;
import net.coderlin.generator.constant.FileConstant;
import net.coderlin.generator.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title: TemplateHandler
 * Description:
 *
 * @author Lin Hui
 * Created on 2018-8-5 16:32
 */
public class TemplateHandler {
    private static final Logger logger = LoggerFactory.getLogger(TemplateHandler.class);

    private static TemplateHandler templateHandler = null;

    private Configuration configuration = null;

    private Map<String, Object> root = null;

    private TemplateHandler(Project project) throws IOException {
        configuration = new Configuration(Configuration.VERSION_2_3_28);
        File templateFolder = new File(FileConstant.TEMPLATE_PATH);
        configuration.setDirectoryForTemplateLoading(templateFolder);
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        root = new HashMap<>();
        root.put("project", project);
    }

    public static TemplateHandler getInstance(Project project) throws IOException {
        if (null == templateHandler) {
            return new TemplateHandler(project);
        }
        return templateHandler;
    }

    public void generateCode(TemplateFile templateFile, List<Table> tables) throws IOException, TemplateException {
        Template template = configuration.getTemplate(templateFile.getFileName());
        for (Table table : tables) {
            root.put("table", table);

            File dir = new File(FileConstant.OUT_PATH, templateFile.getExportPath());
            if (!dir.exists()) {
                boolean mkdirsResult = dir.mkdirs();
            }
            StringBuilder nameBuilder = new StringBuilder();
            if (StringUtil.isNotEmpty(templateFile.getPrefix())) {
                nameBuilder.append(templateFile.getPrefix());
            }
            nameBuilder.append(table.getObjectName());
            if (StringUtil.isNotEmpty(templateFile.getSuffix())) {
                nameBuilder.append(templateFile.getSuffix());
            }
            if(StringUtil.isNotEmpty(templateFile.getExtension())){
                nameBuilder.append(".").append(templateFile.getExtension());
            }

            OutputStream os = new FileOutputStream(new File(dir, nameBuilder.toString()));
            Writer writer = new OutputStreamWriter(os);

            template.process(root, writer);

            writer.close();
            os.close();
        }
    }
}
