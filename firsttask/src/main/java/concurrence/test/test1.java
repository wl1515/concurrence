package concurrence.test;

public class test1 {

    private static volatile int a;

    public static void main(String[] args) {
        a =1;
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
