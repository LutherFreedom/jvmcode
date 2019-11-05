import java.util.ArrayList;
import java.util.List;

/**
 * All rights Reserved, Designed by Luther
 *
 * @auther: Luther
 * @createdTime: 2019/10/18 15:04
 * @version： 0.0.1
 * @copyRight: @2019
 * TODO:
 */
public class MonitorTest {
    static class OOMObject{
        public byte[] placeholder = new byte[64 * 1024];
    }
    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i< num;i++){
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(20000);
       fillHeap(3000);
    }
}
