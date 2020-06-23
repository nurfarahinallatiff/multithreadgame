import javax.swing.*;

public class Main {

    public static String[] getValues(){
        String[] array = new String[3];
        array[0] = JOptionPane.showInputDialog("Enter number of nodes: ");
        array[1] = JOptionPane.showInputDialog("Enter time limit(seconds): ");
        array[2] = JOptionPane.showInputDialog("Enter number of threads: ");
        return array;
    }

    public static void main(String[] args) {
        //TODO: enable later
        /*Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n, m and t respectively:");
        int n = scanner.nextInt();
        Long m = scanner.nextLong();
        int t = scanner.nextInt();

        Application run = new Application();
        run.execute(n, m, t);
        Application run = new Application();
        run.execute(12, 5L, 10);*/
        ///*
        int n;
        Long m;
        int t;

        String[] s1;
        s1 = getValues();
        n = Integer.parseInt(s1[0]);
        m = Long.valueOf(s1[1]);
        t = Integer.parseInt(s1[2]);

        System.out.println("N = "+n);
        System.out.println("M = "+m);
        System.out.println("T = "+t);

        Application run = new Application();
        run.execute(n, m, t);
        //*/
    }
}
