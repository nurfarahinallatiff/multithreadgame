import java.util.ArrayList;

public class EdgeOperation {

    private static ArrayList<Node> innerListOfNode;

    public static void init(ArrayList<Node> listOfNode) {
        innerListOfNode = listOfNode;
    }

    public static Integer getListOfNodeSize() {
        return innerListOfNode.size();
    }

    public static Node get(int index) {
        return innerListOfNode.get(index);
    }

    public synchronized static Edge connect(Node n1, Node n2) throws InterruptedException {
        // better algo can be done
        if (n1.getIsLock().get() || n2.getIsLock().get() || n1.getIsConnected().get() || n2.getIsConnected().get()) {
            return null;
        } else {
            n1.setIsLock(true);
            n2.setIsLock(true);
            Edge edge = new Edge();
            edge.setId(IDGenerator.randomAlphaNumeric(12));
            edge.setNode1(n1);
            edge.setNode2(n2);
            n1.setIsConnected(true);
            n2.setIsConnected(true);
            n1.setIsLock(false);
            n2.setIsLock(false);
            return edge;
        }
    }
}
