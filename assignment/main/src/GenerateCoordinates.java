import java.util.HashSet;
import java.util.Random;


public class GenerateCoordinates {

    public static Node createNode(HashSet<String> coordinateLock) {
        Random r = new Random();
        boolean isUnique;
        String coordinate;
        Double row;
        Double col;
        do {
            row = Double.valueOf(r.nextInt(1001));
            col = Double.valueOf(r.nextInt(1001));
            coordinate = row + "-" + col;
            isUnique = coordinateLock.contains(coordinate);
        } while (isUnique);
        coordinateLock.add(coordinate);
        Node node = new Node();
        node.setRow(row);
        node.setColumn(col);
        return node;
    }
}