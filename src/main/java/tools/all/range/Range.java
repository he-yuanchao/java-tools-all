package tools.all.range;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

/**
 * 功能描述:  <p></p>
 *
 * @author : yuanchao.he
 * @version 1.0 2019-05-09
 * @since java-tools-all 1.0
 */
@Getter
@Setter
public class Range {

    @JSONField(name = "l")
    private int lowerBound;

    @JSONField(name = "u")
    private int upperBound;

    public Range(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public boolean contains(int number) {
        return number >= lowerBound && number <= upperBound;
    }

    public String toString() {
        return String.format("[%d,%d]", this.lowerBound, this.upperBound);
    }
}
