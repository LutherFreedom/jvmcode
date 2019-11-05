import java.util.ArrayList;
import java.util.List;

/**
 * All rights Reserved, Designed by Luther
 *
 * @auther: Luther
 * @createdTime: 2019/9/10 15:12
 * @version： 0.0.1
 * @copyRight: @2019
 * TODO: JDK 1.6及之前会报 OutOfMemoryError: PermGen space, JDK1.7会一直执行下去
 * VM Option: -XX:PermSize=10M -XX:MaxPermSize=10M -Xlog:gc*
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        //测试String.intern()返回应用的测试
        //在1.6之前 intern会将首次遇到的字符串实例复制到永久代中 str1.intern() 返回的是永久代的应用， 而 str1是StringBuilder new出来的 返回的是堆中的引用，所以false
        //1.7之后 intern不会再做反正了，而是直接在常量池中记录首次出现的实例引用， 所以intern返回的应用于new出来的一致
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("jav").append("a").toString();
        System.out.println(str2.intern() == str2);

        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }

    }
}
