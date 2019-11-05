/**
 * All rights Reserved, Designed by Luther
 *
 * @auther: Luther
 * @createdTime: 2019/10/18 16:42
 * @version： 0.0.1
 * @copyRight: @2019
 * TODO:
 */
public class JconsoleThread1 {
    static class SynAddRunable implements Runnable {
        int a, b;

        public SynAddRunable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)) {
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i =0; i< 100; i++){
            new Thread(new SynAddRunable(1,2)).start();
            new Thread(new SynAddRunable(2,1)).start();
        }
    }
}
