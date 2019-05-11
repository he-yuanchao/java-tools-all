package tools.all.random;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 功能描述:  <p></p>
 *
 * @author : yuanchao.he
 * @version 1.0 2019-05-09
 * @since java-tools-all 1.0
 */
public class RandomUtil {

    private static char[] CHAR_ARRAY = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b',
        'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '@', '#', '*'};

    /**
     * 随机生成一个长度为10的字符串
     */
    public static String randomString() {
        return randomString(10);
    }

    /**
     * 随机生成一个长度为length的字符串
     */
    public static String randomString(int length) {
        StringBuilder builder = new StringBuilder();
        int max = CHAR_ARRAY.length;
        ThreadLocalRandom random = ThreadLocalRandom.current();
        while (length-- > 0) {
            builder.append(CHAR_ARRAY[random.nextInt(max)]);
        }
        return builder.toString();
    }
}
