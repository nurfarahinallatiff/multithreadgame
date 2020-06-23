import java.util.Random;
import java.util.concurrent.Callable;

public class CombineNode implements Callable<Edge> {

    private int count = 0;

    @Override
    public Edge call() throws Exception {

        Random r = new Random();
        Edge edge = null;

        while (count < 20) {
            // we want the thread to die after executor is ended
            if (ExecutorManager.getExecutorService().isShutdown()) {
                return null;
            }
            int pair1 = r.nextInt(EdgeOperation.getListOfNodeSize());
            int pair2 = r.nextInt(EdgeOperation.getListOfNodeSize());

            if (pair1 == pair2) {
                continue;
            }
            Node one = EdgeOperation.get(pair1);
            Node two = EdgeOperation.get(pair2);

            edge = EdgeOperation.connect(one, two);
            if (edge == null) {
                count++;
            } else {
                break;
            }
        }
        if (count >= 20) {
            throw new IllegalStateException("Counter exceeded!");
        } else if (edge == null) {
            throw new IllegalStateException("Edge cannot be null!");
        }
        return edge;
    }
}
