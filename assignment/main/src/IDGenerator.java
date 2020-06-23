import java.util.Random;

public class IDGenerator {

    public static String randomAlphaNumeric(int length) {
        int init = 65;
        int offset = 32;

        Random r = new Random();

        String result = "";
        for (int i = 0; i < length; i++) {
            boolean isSmall = r.nextBoolean();
            int var = r.nextInt(26);
            char rand;
            if (isSmall) {
                int sum = init + var + offset;
                rand = (char) sum;
            } else {
                int sum = init + var;
                rand = (char) sum;
            }
            result += rand;
        }

        return result;
    }
}