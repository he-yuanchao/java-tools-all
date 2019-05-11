package tools.all.version;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * 功能描述:  <p>版本比较工具类</p>
 *
 * @author : yuanchao.he
 * @version 1.0 2019-05-08
 * @since java-tools-all 1.0
 */
public class VersionUtil {

    private static Cache<String, int[]> cache = CacheBuilder.newBuilder().expireAfterWrite(1,
        TimeUnit.HOURS).maximumSize(1000).build();

    private static final int[] EMPTY_INT_ARRAY = new int[0];

    /**
     * version1 > version2  return 1 version1 < version2  return -1 version1 == version2 return 0
     */
    public static CompareResultEnum compare(String version1, String version2) {
        int[] left = toIntArray(version1);
        int[] right = toIntArray(version2);
        if (left.length == 0 && right.length == 0) {
            return CompareResultEnum.EQUAL;
        } else if (left.length != 0 && right.length != 0) {
            int index = 0;
            while (index < left.length && index < right.length) {
                if (left[index] == right[index]) {
                    index += 1;
                } else {
                    return CompareResultEnum.from(left[index] - right[index]);
                }
            }
            if (index == left.length && index == right.length) {
                return CompareResultEnum.EQUAL;
            }
            return CompareResultEnum.from(index - left.length);
        } else {
            return left.length == 0 ? CompareResultEnum.SMALLER : CompareResultEnum.BIGGER;
        }
    }

    /**
     * 对版本数据从小到大排序
     */
    public static List<String> orderByASC(List<String> versions) {
        return orderBy(versions, VersionOrderByEnum.ASC);
    }

    /**
     * 对版本数据从大到小排序
     */
    public static List<String> orderByDESC(List<String> versions) {
        return orderBy(versions, VersionOrderByEnum.DESC);
    }

    private static List<String> orderBy(List<String> versions, VersionOrderByEnum orderBy) {
        if (versions == null) {
            return new LinkedList<>();
        }
        Collections.sort(versions, (o1, o2) -> orderBy.compare(o1, o2).value);
        return versions;
    }

    private static int[] toIntArray(final String version) {
        if (StringUtils.isEmpty(version)) {
            return EMPTY_INT_ARRAY;
        }
        try {
            return cache.get(version, () -> toIntArray0(version));
        } catch (Exception e) {
            return toIntArray0(version);
        }
    }

    private static int[] toIntArray0(String version) {
        String[] array = version.split("\\.");
        int[] intArray = new int[array.length];
        for (int index = 0; index < array.length; index++) {
            intArray[index] = NumberUtils.toInt(array[index].trim());
        }
        return intArray;
    }
}
