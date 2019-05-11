package tools.all.size;

import java.math.BigDecimal;

/**
 * 功能描述:  <p></p>
 *
 * @author : yuanchao.he
 * @version 1.0 2019-05-11
 * @since java-tools-all 1.0
 */
public class FileSizeUtil {

    private static final String[] UNIT_NAME = {"B", "KB", "MB", "GB", "TB", "PB", "EB"};

    private static final double DECIMAL = 1024;

    /**
     * 返回 bytes 转换之后的可打印字符串
     */
    public static String toPrintSizeString(long bytes) {
        double value = (double) bytes;
        for (String name : UNIT_NAME) {
            if (value < DECIMAL) {
                return String.format("%.2f%s", value, name);
            } else {
                value = new BigDecimal(value / DECIMAL).setScale(2, BigDecimal.ROUND_DOWN)
                    .doubleValue();
            }
        }
        return String.format("%.2f%s", value, UNIT_NAME[UNIT_NAME.length - 1]);
    }
}
