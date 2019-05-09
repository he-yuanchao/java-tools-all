package tools.all.common;

import java.util.Map;

/**
 * 功能描述:  <p></p>
 *
 * @author : yuanchao.he
 * @version 1.0 2019-05-09
 * @since java-tools-all 1.0
 */
public class MapUtils {

    public static <K, V> boolean isEmpty(Map<K, V> map) {
        return map == null || map.size() == 0;
    }

    public static <K, V> boolean isNotEmpty(Map<K, V> map) {
        return map != null || map.size() > 0;
    }
}
