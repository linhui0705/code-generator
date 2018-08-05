package net.coderlin.generator.handler;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import net.coderlin.generator.bean.BaseConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Title: YamlHandler
 * Description:
 *
 * @author Lin Hui
 * Created on 2018-8-5 14:54
 */
public class YamlHandler {
    private static final Logger logger = LoggerFactory.getLogger(YamlReader.class);

    /**
     * 读取配置文件
     * @param path 配置文件路径
     * @return
     * @throws FileNotFoundException
     * @throws YamlException
     */
    public BaseConfig readConfig(String path) throws FileNotFoundException, YamlException {
        YamlReader reader = new YamlReader(new FileReader(path));
        BaseConfig config = reader.read(BaseConfig.class);
        logger.debug("BASE_CONFIG: {}", config);
        return config;
    }
}
