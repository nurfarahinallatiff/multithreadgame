import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorManager {

    private static ExecutorService executorService;

    public ExecutorManager(int thread) {
        executorService = Executors.newFixedThreadPool(thread);
    }

    public static ExecutorService getExecutorService() {
        return executorService;
    }
}
