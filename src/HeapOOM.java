import java.util.ArrayList;
import java.util.List;

/**
 * All rights Reserved, Designed by Luther
 *
 * @auther: Luther
 * @createdTime: 2019/9/10 14:35
 * @version： 0.0.1
 * @copyRight: @2019
 * TODO:
 * VM Option  -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -verbose:gc -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8
 */
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
