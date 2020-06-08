import java.util.*;

public class MainTest {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        int n;
        System.out.print("Enter the amount of points wanted: ");
        n=input.nextInt();

        int t;
        System.out.print("Enter the amount of threads wanted: ");
        t=input.nextInt();

        int m;
        System.out.print("Enter the time limit for programme: ");
        m=input.nextInt();

        int name;
        System.out.print("Enter thread name: ");
        name=input.nextInt();

        System.out.println("Value n:"+n);
        System.out.println("Value t:"+t);
        System.out.println("Value m:"+m);
        System.out.println("Name is:"+name);

        int[] points = new int[n];
        for(int i = 0; i < n; i++) {
            points[i] = rand.nextInt(1001);
        }

        for(int i = 0; i < n; i++) {
            if (i != (n-1)){
                System.out.printf("%d,",points[i]);
            }
            else{
                System.out.printf("%d\n",points[i]);
            }
        }

        for(int i = t; i > 0; i--) {
            String palat = String.valueOf(i);
            new Testing123(palat);
        }
    }
}
