package net.coderlin.generator.util;

import java.util.List;

/**
 * Title: CollectionUtil
 * Description:
 *
 * @author Lin Hui
 * Created on 2018-7-29 23:21
 */
public class CollectionUtil {
    public static boolean isEmpty(List list) {
        return null == list || list.size() == 0;
    }
}
