import java.util.concurrent.atomic.AtomicBoolean;

public class Node {
    private double row;
    private double column;
    private AtomicBoolean isConnected = new AtomicBoolean(false);
    private AtomicBoolean isLock = new AtomicBoolean(false);

    public double getRow() {
        return this.row;
    }

    public void setRow(double row) {
        this.row = row;
    }

    public double getColumn() {
        return this.column;
    }

    public void setColumn(double column) {
        this.column = column;
    }

    public AtomicBoolean getIsConnected() {
        return this.isConnected;
    }

    public void setIsConnected(Boolean isConnected) throws InterruptedException {
        AtomicBoolean stat = new AtomicBoolean(isConnected);
        this.isConnected = stat;
    }

    public AtomicBoolean getIsLock() {
        return this.isLock;
    }

    public void setIsLock(Boolean isLock) throws InterruptedException {
        AtomicBoolean stat = new AtomicBoolean(isLock);
        this.isLock = stat;
    }
}