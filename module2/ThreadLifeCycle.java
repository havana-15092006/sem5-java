class MyThread extends Thread {

    public void run() {
        System.out.println("Thread is running...");

        try {
            System.out.println("Thread is going to sleep.");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread execution completed.");
    }
}

public class ThreadLifeCycle {
    public static void main(String[] args) throws Exception {

        MyThread t = new MyThread();

        System.out.println("State after creation: " + t.getState());

        t.start();

        System.out.println("State after start: " + t.getState());

        Thread.sleep(500);

        System.out.println("State during sleep: " + t.getState());

        t.join();

        System.out.println("State after completion: " + t.getState());
    }
}
