package com.asahi.common;

/**
 * 分类的枚举
 */
public enum Kind {
    RILI("rili"), DONGMAN("dongman"), FENGJING("fengjing"), MEINV("meinv"), YOUXI("youxi"), YINGSHI("yingshi"),
    DONGTAI("dongtai"), WEIMEI("weimei"), SHEJI("sheji"), KEAI("keai"), QICHE("qiche"), HUAHUI("huahui"),
    DONGWU("dongwu"), JIERI("jieri"), RENWU("renwu"), MEISHI("meishi"), SHUIGUO("shuiguo"), JIANZHU("jianzhu"),
    TIYU("tiyu"), JUNSHI("junshi"), FEIZHULIU("feizhuliu"), QITA("qita"), WANGZHERONGYAO("s/wangzherongyao"), HUYAN("s/huyan"), LOL("s/lol");
    String kind;

    Kind(String kind) {
        this.kind = kind;
    }
    //输入类别时判断一下是否在其中
    public static boolean contains(String test) {
        for (Kind c : Kind.values()) {
            if (c.kind.equals(test)) {
                return true;
            }
        }
        return false;
    }
}
