class LifeCycleDemo extends Thread {

    public void run() {
        System.out.println("Thread is running...");

        try {
            System.out.println("Thread is going to sleep.");
            Thread.sleep(2000); // Timed Waiting state
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }

        System.out.println("Thread has completed.");
    }

    public static void main(String[] args) throws InterruptedException {

        LifeCycleDemo t = new LifeCycleDemo();

        // New state
        System.out.println("After creation: " + t.getState());

        // Runnable state
        t.start();
        System.out.println("After start(): " + t.getState());

        // Wait for the thread to finish
        t.join();

        // Terminated state
        System.out.println("After completion: " + t.getState());
    }
}
