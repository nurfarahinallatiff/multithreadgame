import java.util.concurrent.TimeUnit;

public class Timer implements Runnable {

    private Long waiting;

    public Timer(Long waiting) {
        this.waiting = waiting;
    }

    @Override
    public void run() {
        try {
            System.out.println("Timer start");
            TimeUnit.SECONDS.sleep(waiting);
            System.out.println("Time limit exceed! Shutting down all thread now...");
            ExecutorManager.getExecutorService().shutdownNow();
        } catch (InterruptedException e) {
            // log?
        }
    }
}
