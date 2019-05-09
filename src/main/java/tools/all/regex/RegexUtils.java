package tools.all.regex;

import static tools.all.regex.Regex.ascii;
import static tools.all.regex.Regex.chinese;
import static tools.all.regex.Regex.codeAndMobile;
import static tools.all.regex.Regex.color;
import static tools.all.regex.Regex.date;
import static tools.all.regex.Regex.decmal;
import static tools.all.regex.Regex.decmal1;
import static tools.all.regex.Regex.decmal2;
import static tools.all.regex.Regex.decmal3;
import static tools.all.regex.Regex.decmal4;
import static tools.all.regex.Regex.decmal5;
import static tools.all.regex.Regex.email;
import static tools.all.regex.Regex.idcard;
import static tools.all.regex.Regex.intege;
import static tools.all.regex.Regex.intege1;
import static tools.all.regex.Regex.intege2;
import static tools.all.regex.Regex.ip4;
import static tools.all.regex.Regex.isCarVin;
import static tools.all.regex.Regex.isFloat;
import static tools.all.regex.Regex.isInteger;
import static tools.all.regex.Regex.isUFloat;
import static tools.all.regex.Regex.isUInteger;
import static tools.all.regex.Regex.letter;
import static tools.all.regex.Regex.letterAndSpace;
import static tools.all.regex.Regex.letter_l;
import static tools.all.regex.Regex.letter_u;
import static tools.all.regex.Regex.mobile;
import static tools.all.regex.Regex.notempty;
import static tools.all.regex.Regex.num;
import static tools.all.regex.Regex.num1;
import static tools.all.regex.Regex.num2;
import static tools.all.regex.Regex.picture;
import static tools.all.regex.Regex.qq;
import static tools.all.regex.Regex.rar;
import static tools.all.regex.Regex.tel;
import static tools.all.regex.Regex.url;
import static tools.all.regex.Regex.username;
import static tools.all.regex.Regex.zipcode;

import org.apache.commons.lang3.StringUtils;

/**
 * 功能描述:  <p></p>
 *
 * @author : yuanchao.he
 * @version 1.0 2019-05-09
 * @since java-tools-all 1.0
 */
public class RegexUtils {

    /**
     * 手机号
     */
    public static boolean isMobile(String input) {
        return matches(mobile, input);
    }

    public static boolean isCodeAndMobile(String input) {
        return matches(codeAndMobile, input);
    }

    /**
     * 整数
     */
    public static boolean isIntege(String input) {
        return matches(intege, input);

    }

    /**
     * 正整数
     */
    public static boolean isintege1(String input) {
        return matches(intege1, input);
    }

    /**
     * 负整数
     */
    public static boolean isIntege2(String input) {
        return matches(intege2, input);
    }

    /**
     * 数字
     */
    public static boolean isNum(String input) {
        return matches(num, input);
    }

    /**
     * 正数（正整数 + 0）
     */
    public static boolean isNum1(String input) {
        return matches(num1, input);
    }

    /**
     * 负数（负整数 + 0）
     */
    public static boolean isNum2(String input) {
        return matches(num2, input);
    }

    /**
     * 浮点数
     */
    public static boolean isDecmal(String input) {
        return matches(decmal, input);
    }

    /**
     * 正浮点数
     */
    public static boolean isDecmal1(String input) {
        return matches(decmal1, input);
    }

    /**
     * 负浮点数
     */
    public static boolean isDecmal2(String input) {
        return matches(decmal2, input);
    }

    /**
     * 浮点数
     */
    public static boolean isDecmal3(String input) {
        return matches(decmal3, input);
    }

    /**
     * 非负浮点数（正浮点数 + 0）
     */
    public static boolean isDecmal4(String input) {
        return matches(decmal4, input);
    }

    /**
     * 非正浮点数（负浮点数 + 0）
     */
    public static boolean isDecmal5(String input) {
        return matches(decmal5, input);
    }

    /**
     * 邮件
     */
    public static boolean isEmail(String input) {
        return matches(email, input);
    }

    /**
     * 颜色
     */
    public static boolean isColor(String input) {
        return matches(color, input);
    }

    /**
     * url
     */
    public static boolean isUrl(String input) {
        return matches(url, input);
    }

    /**
     * 中文
     */
    public static boolean isChinese(String input) {
        return matches(chinese, input);
    }

    /**
     * ascii码
     */
    public static boolean isAscii(String input) {
        return matches(ascii, input);
    }

    /**
     * 邮编
     */
    public static boolean isZipcode(String input) {
        return matches(zipcode, input);
    }

    /**
     * IP地址
     */
    public static boolean isIP4(String input) {
        return matches(ip4, input);
    }

    /**
     * 非空
     */
    public static boolean isNotEmpty(String input) {
        return matches(notempty, input);
    }

    /**
     * 图片
     */
    public static boolean isPicture(String input) {
        return matches(picture, input);
    }

    /**
     * 压缩文件
     */
    public static boolean isRar(String input) {
        return matches(rar, input);
    }

    /**
     * 日期
     */
    public static boolean isDate(String input) {
        return matches(date, input);
    }

    /**
     * qq
     */
    public static boolean isQQ(String input) {
        return matches(qq, input);
    }

    /**
     * 电话号码的函数(包括验证国内区号;国际区号;分机号)
     */
    public static boolean isTel(String input) {
        return matches(tel, input);
    }

    /**
     * 用来用户注册。匹配由数字、26个英文字母或者下划线组成的字符串
     */
    public static boolean isUserName(String input) {
        return matches(username, input);
    }

    /**
     * 字母
     */
    public static boolean isLetter(String input) {
        return matches(letter, input);
    }

    public static boolean isLetterAndSpace(String input) {
        return matches(letterAndSpace, input);
    }

    /**
     * 小写字母
     */
    public static boolean isLowLetter(String input) {
        return matches(letter_l, input);
    }

    /**
     * 大写字母
     */
    public static boolean isUpperLetter(String input) {
        return matches(letter_u, input);
    }

    /**
     * 身份证
     */
    public static boolean isIDCard(String input) {
        return matches(idcard, input);
    }

    public static boolean isFloat(String input) {
        return matches(isFloat, input);
    }

    public static boolean isUFloat(String input) {
        return matches(isUFloat, input);
    }

    public static boolean isInteger(String input) {
        return matches(isInteger, input);
    }

    public static boolean isUInteger(String input) {
        return matches(isUInteger, input);
    }

    public static boolean isCarVin(String carVin) {
        return matches(isCarVin, carVin);
    }

    public static boolean matches(String regex, String input) {
        if (StringUtils.isBlank(input)) {
            return false;
        }
        if (input.matches(regex)) {
            return true;
        }
        return false;
    }
}
