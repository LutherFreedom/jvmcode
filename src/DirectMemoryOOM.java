import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * All rights Reserved, Designed by Luther
 *
 * @auther: Luther
 * @createdTime: 2019/9/10 16:04
 * @version： 0.0.1
 * @copyRight: @2019
 * TODO:
 * VM Option -Xmx20M -XX:MaxDirectMemorySize=10M -Xlog:gc*
 */
public class DirectMemoryOOM {
    private static final int _1Mb = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1Mb);
        }
    }
}
