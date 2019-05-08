package tools.all.version;

/**
 * 功能描述:  <p></p>
 *
 * @author : yuanchao.he
 * @version 1.0 2019-05-08
 * @since java-tools-all 1.0
 */
public enum CompareResultEnum {
    SMALLER("A<B", -1), EQUAL("A==B", 0), BIGGER("A>B", 1);

    public String desc;
    public int value;

    CompareResultEnum(String desc, int value) {
        this.desc = desc;
        this.value = value;
    }

    public static CompareResultEnum from(int compare) {
        if (compare == 0) {
            return EQUAL;
        } else if (compare < 0) {
            return SMALLER;
        } else {
            return BIGGER;
        }
    }
}
