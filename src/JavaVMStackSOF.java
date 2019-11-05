/**
 * All rights Reserved, Designed by Luther
 *
 * @auther: Luther
 * @createdTime: 2019/9/10 14:50
 * @version： 0.0.1
 * @copyRight: @2019
 * TODO: 如果线程请求的栈深度大于虚拟机所允许的深度，抛出StackOverflowError
 * VM Option -Xss180k (at least 180k) 【-Xss参数减少栈内存容量】
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Exception e) {
            System.out.println("Stack length: " + oom.stackLength);
//            throw e;
        }
    }
}
