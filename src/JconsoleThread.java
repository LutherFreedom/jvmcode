import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * All rights Reserved, Designed by Luther
 *
 * @auther: Luther
 * @createdTime: 2019/10/18 16:31
 * @version： 0.0.1
 * @copyRight: @2019
 * TODO:
 */
public class JconsoleThread {
    public static void cratedBusyThread(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    ;
                }
            }
        }, "testBusyThread");
        thread.start();
    }

    public static void createLockThread(final Object lock){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread");
        thread.start();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        cratedBusyThread();
        br.readLine();
        Object obj = new Object();
        createLockThread(obj);
    }
}
