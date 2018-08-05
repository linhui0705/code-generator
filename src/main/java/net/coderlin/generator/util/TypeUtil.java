package net.coderlin.generator.util;

/**
 * Title: TypeUtil
 * Description:
 *
 * @author Lin Hui
 * Created on 2018-7-29 23:39
 */
public class TypeUtil {
    public static String convertToJavaType(String dbType) {
        switch (dbType.toUpperCase()) {
            case "CHAR":
            case "VARCHAR":
            case "TEXT":
                return "String";
            case "BIGINT":
            case "INTEGER":
            case "ID":
                return "Long";
            case "TINYINT":
            case "SMALLINT":
            case "MEDIUMINT":
            case "INT":
                return "Integer";
            case "DATETIME":
            case "TIMESTAMP":
                return "Timestamp";
            case "DATE":
            case "YEAR":
                return "Date";
            case "TIME":
                return "Time";
            case "FLOAT":
                return "Float";
            case "DOUBLE":
                return "Double";

            default:
                return null;
        }
    }
}
