package tools.all.version;

/**
 * 功能描述:  <p></p>
 *
 * @author : yuanchao.he
 * @version 1.0 2019-05-08
 * @since java-tools-all 1.0
 */
public enum VersionOrderByEnum implements Compare {
    ASC("from small to big") {
        @Override
        public CompareResultEnum compare(String versionA, String versionB) {
            return VersionUtil.compare(versionA, versionB);
        }
    }, DESC("from big to small") {
        @Override
        public CompareResultEnum compare(String versionA, String versionB) {
            return VersionUtil.compare(versionB, versionA);
        }
    };

    public String desc;

    VersionOrderByEnum(String desc) {
        this.desc = desc;
    }
}
