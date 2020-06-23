import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Future;

public class Application {

    // TODO: fix documentation cache name to coordinateLock
    private static final HashSet<String> coordinateLock = new HashSet<>();
    private static ArrayList<Node> listOfNode = new ArrayList<>();
    private static ArrayList<Edge> listOfEdge = new ArrayList<>();
    private static List<Future<Edge>> completeEdge = new ArrayList<>();

    // TODO: fix documentation

    /**
     * @param n
     * @param m
     * @param t
     */
    public static void execute(int n, Long m, int t) {

        // expecting timer also part of thread.
        // set as global variable
        new ExecutorManager(t + 1);

        // initiate timer here
        ExecutorManager.getExecutorService().execute(new Timer(m));

        // initiate node logic here
        GenerateCoordinates nodeService = new GenerateCoordinates();
        for (int i = 0; i < n; i++) {
            listOfNode.add(nodeService.createNode(coordinateLock));
        }

        // initiate edge logic here

        // initiate EdgeOperation
        EdgeOperation.init(listOfNode);



        while(listOfEdge.size() < n/2 && !ExecutorManager.getExecutorService().isShutdown()){
            try{
                Future<Edge> f =ExecutorManager.getExecutorService().submit(new CombineNode());
                listOfEdge.add(f.get());
            }catch (Exception e){

            }
        }

        // just one to see whether or not the program works(testing purposes)
        /*if (!ExecutorManager.getExecutorService().isShutdown()) {
            if (listOfNode.size() == n) {
                System.out.println("Verify number of node is true");
            } else {
                System.out.println(String.format("Verify number of node is false. Number:%s", listOfNode.size()));
            }

            if (listOfEdge.size() == n / 2) {
                System.out.println("Verify number of edge is true");
            } else {
                System.out.println(String.format("Verify number of edge is false. Number:%s", listOfEdge.size()));
            }
        }*/
        // termination
        System.out.println("Everything is finished. Shutting down all threads...");
        ExecutorManager.getExecutorService().shutdownNow();
        while (!ExecutorManager.getExecutorService().isShutdown()) {
            // dead loop. Proceed only after all shut down
        }
        System.out.println("Shut down successful.");

        int i = 1;
        String node1;
        String node2;

        for(Edge y : listOfEdge){
            node1 = String.valueOf(y.getNode1());
            node2 = String.valueOf(y.getNode2());
            System.out.print("Edge ID: "+y.getId()+", Node Pair: ");
            for(Node s : listOfNode){
                if(node1.equals(String.valueOf(s))){
                    System.out.print("(Node ID: "+s+" = "+s.getRow()+","+s.getColumn()+"), ");
                }
                if(node2.equals(String.valueOf(s))){
                    System.out.print("(Node ID: "+s+" = "+s.getRow()+","+s.getColumn()+"), ");
                }
            }
            System.out.println();
            i++;
        }

        GUIresult frame = new GUIresult("Test Window");

        frame.setSize(600,600);

        frame.setVisible(true);

        i=1;

        for(Edge w : listOfEdge){
            node1 = String.valueOf(w.getNode1());
            node2 = String.valueOf(w.getNode2());
            for(Node z : listOfNode) {
                if(node1.equals(String.valueOf(z))){
                    String name = String.valueOf(i);
                    frame.addNode(name, ((z.getRow()/2)+50),((z.getColumn()/2)+50));
                    i++;
                }
                if(node2.equals(String.valueOf(z))){
                    String name = String.valueOf(i);
                    frame.addNode(name, ((z.getRow()/2)+50),((z.getColumn()/2)+50));
                    i++;
                }
                if ((i % 2) == 0){
                    frame.addEdge(i-2,i-1);
                }
            }
        }
    }
}
