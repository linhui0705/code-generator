package net.coderlin.generator.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Title: StringUtil
 * Description:
 *
 * @author Lin Hui
 * Created on 2018-7-29 20:52
 */
public class StringUtil {
    private static final Logger logger = LoggerFactory.getLogger(StringUtil.class);

    private static final String TB_ = "tb_";

    private static final char UNDERLINE = '_';

    public static String convertTable(String tableName) {
        if (tableName.contains(TB_)) {
            logger.info("The tableName Contains [{}], Remove it", TB_);
            tableName = tableName.replaceAll("tb_", "");
        }
        return underlineToPascal(tableName);
    }

    public static String convertColumn(String column) {
        return underlineToCamel(column);
    }

    /**
     * 下划线格式转换为小驼峰格式
     *
     * @param string 需转换的字符串
     * @return 小驼峰格式字符串
     */
    private static String underlineToCamel(String string) {
        if (isEmpty(string)) {
            return "";
        }
        int length = string.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == UNDERLINE) {
                if (++i < length) {
                    stringBuilder.append(Character.toUpperCase(string.charAt(i)));
                }
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 下划线格式转换为小驼峰格式
     *
     * @param string 需转换的字符串
     * @return 大驼峰格式字符串
     */
    private static String underlineToPascal(String string) {
        String pascalString = underlineToCamel(string);
        if (isEmpty(pascalString)) {
            return string;
        }
        return pascalString.substring(0, 1).toUpperCase() + pascalString.substring(1);
    }

    /**
     * 字符串空判断
     *
     * @param string 需判断的字符串
     * @return 是否为空
     */
    public static boolean isEmpty(String string) {
        return null == string || string.length() == 0;
    }

    /**
     * 字符串非空判断
     *
     * @param string 需判断的字符串
     * @return 是否不为空
     */
    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    public static void main(String[] args) {
        logger.info(underlineToCamel("tb_test_hello"));
        logger.info(underlineToCamel("_test_hello"));
        logger.info(underlineToCamel("test_hello_"));
        logger.info(underlineToCamel("test_hello_"));
        logger.info(underlineToCamel("___"));
        logger.info("----------");
        logger.info(underlineToPascal("tb_test_hello"));
        logger.info(underlineToPascal("_test_hello"));
        logger.info(underlineToPascal("test_hello_"));
        logger.info(underlineToPascal("test_hello_"));
        logger.info(underlineToCamel("___"));

        String test = "Mapper.ftl";
        String fileName = test.substring(0, test.indexOf('.'));
        if (fileName.toLowerCase().contains("xml")) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        System.out.println();
    }
}
