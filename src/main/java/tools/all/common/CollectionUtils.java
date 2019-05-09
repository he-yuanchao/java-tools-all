package tools.all.common;

import java.util.Collection;

/**
 * 功能描述:  <p></p>
 *
 * @author : yuanchao.he
 * @version 1.0 2019-05-09
 * @since java-tools-all 1.0
 */
public class CollectionUtils {

    public static <E> boolean isEmpty(Collection<E> collection) {
        return collection == null || collection.size() == 0;
    }

    public static <E> boolean isNotEmpty(Collection<E> collection) {
        return collection != null && collection.size() > 0;
    }
}
