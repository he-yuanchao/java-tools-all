package tools.all.range;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tools.all.common.CollectionUtils;

/**
 * 功能描述:  <p></p>
 *
 * @author : yuanchao.he
 * @version 1.0 2019-05-09
 * @since java-tools-all 1.0
 */
public class RangeUtil {

    /**
     * 将整数集合变为一个有序的区间组合
     */
    public static ArrayList<Range> fromCollection(Collection<Integer> integers) {
        if (CollectionUtils.isEmpty(integers)) {
            return new ArrayList<>();
        }

        Set<Integer> set = new HashSet<>(integers);
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        ArrayList<Range> result = Lists.newArrayList();
        Range current = new Range(list.get(0), list.get(0));
        for (int index = 1; index < list.size(); index++) {
            if (list.get(index) == current.getUpperBound() + 1) {
                current.setUpperBound(current.getUpperBound() + 1);
            } else {
                result.add(current);
                current = new Range(list.get(index), list.get(index));
            }
        }
        result.add(current);

        return result;
    }

    /**
     * 在有序的区间组合内进行查找
     */
    public static Range binarySearch(ArrayList<Range> list, int number) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        int lowerIndex = 0;
        int upperIndex = list.size() - 1;
        int middleIndex = (upperIndex + lowerIndex) / 2;
        while (middleIndex <= upperIndex && middleIndex >= lowerIndex) {
            Range item = list.get(middleIndex);
            if (item.contains(number)) {
                return item;
            } else if (item.getLowerBound() > number) {
                upperIndex = middleIndex - 1;
                middleIndex = (upperIndex + lowerIndex) / 2;
            } else {
                lowerIndex = middleIndex + 1;
                middleIndex = (upperIndex + lowerIndex) / 2;
            }
        }
        return null;
    }

    /**
     * 在有序区间内查找
     */
    public static boolean contains(ArrayList<Range> list, int number) {
        return binarySearch(list, number) != null;
    }
}
