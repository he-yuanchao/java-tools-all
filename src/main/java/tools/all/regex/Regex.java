package tools.all.regex;

/**
 * 功能描述:  <p></p>
 *
 * @author : yuanchao.he
 * @version 1.0 2019-05-09
 * @since java-tools-all 1.0
 */
public interface Regex {

    /**
     * 手机号
     */
    String mobile = "^(13|15|18|17|16)[0-9]{9}$";

    /**
     * 带前缀的手机号，如 +86
     */
    String codeAndMobile = "^\\+[0-9]{2}\\-(13|15|18|17|16)[0-9]{9}$";

    /**
     * 整数
     */
    String intege = "^-?[1-9]\\d*$";
    /**
     * 正整数
     */
    String intege1 = "^[1-9]\\d*$";
    /**
     * 负整数
     */
    String intege2 = "^-[1-9]\\d*$";
    /**
     * 数字
     */
    String num = "^([+-]?)\\d*\\.?\\d+$";
    /**
     * 正数（正整数 + 0）
     */
    String num1 = "^[1-9]\\d*|0$";
    /**
     * 负数（负整数 + 0）
     */
    String num2 = "^-[1-9]\\d*|0$";
    /**
     * 浮点数
     */
    String decmal = "^([+-]?)\\d*\\.\\d+$";
    /**
     * 正浮点数
     */
    String decmal1 = "^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*$";
    /**
     * 负浮点数
     */
    String decmal2 = "^-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*)$";
    /**
     * 浮点数
     */
    String decmal3 = "^-?([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*|0?.0+|0)$";
    /**
     * 非负浮点数（正浮点数 + 0）
     */
    String decmal4 = "^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*|0?.0+|0$";
    /**
     * 非正浮点数（负浮点数 + 0）
     */
    String decmal5 = "^(-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*))|0?.0+|0$";
    /**
     * 邮件
     */
    String email = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
    /**
     * 颜色
     */
    String color = "^[a-fA-F0-9]{6}$";
    /**
     * url
     */
    String url = "^http[s]?=\\/\\/([\\w-]+\\.)+[\\w-]+([\\w-./?%&=]*)?$";
    /**
     * 仅中文
     */
    String chinese = "^[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$";
    /**
     * 仅ACSII字符
     */
    String ascii = "^[\\x00-\\xFF]+$";
    /**
     * 邮编
     */
    String zipcode = "^\\d{6}$";
    /**
     * ip地址
     */
    String ip4 = "^(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)$";
    /**
     * 非空
     */
    String notempty = "^\\S+$";
    /**
     * 图片
     */
    String picture = "(.*)\\.(jpg|bmp|gif|ico|pcx|jpeg|tif|png|raw|tga)$";
    /**
     * 压缩文件
     */
    String rar = "(.*)\\.(rar|zip|7zip|tgz)$";
    /**
     * 日期
     */
    String date = "^\\d{4}(\\-|\\/|\\.)\\d{1,2}\\1\\d{1,2}$";
    /**
     * QQ号码
     */
    String qq = "^[1-9]*[1-9][0-9]*$";
    /**
     * 电话号码的函数(包括验证国内区号;国际区号;分机号)
     */
    String tel = "^(([0\\+]\\d{2,3}-)?(0\\d{2,3})-)?(\\d{7,8})(-(\\d{1,}))?$";
    /**
     * 用来用户注册。匹配由数字、26个英文字母或者下划线组成的字符串
     */
    String username = "^\\w+$";
    /**
     * 字母
     */
    String letter = "^[A-Za-z]+$";
    /**
     * 字母+空格
     */
    String letterAndSpace = "^[A-Za-z ]+$";
    /**
     * 大写字母
     */
    String letter_u = "^[A-Z]+$";
    /**
     * 小写字母
     */
    String letter_l = "^[a-z]+$";
    /**
     * 身份证
     */
    String idcard = "^[1-9]([0-9]{14}|[0-9]{17})$";
    /**
     * 判断字符串是否为浮点数
     */
    String isFloat = "^[-]?\\d+(\\.\\d+)?$";
    /**
     * 判断字符串是否为正浮点数
     */
    String isUFloat = "^\\d+(\\.\\d+)?$";
    /**
     * 判断是否是整数
     */
    String isInteger = "^[-]?\\d+$";
    /**
     * 判断是否是正整数
     */
    String isUInteger = "^\\d+$";
    /**
     * 判断车辆Vin码
     */
    String isCarVin = "^[1234567890WERTYUPASDFGHJKLZXCVBNM]{13}[0-9]{4}$";
}
