import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader num = new BufferedReader(new FileReader("Task_1_numbers.txt"));
        String str;
        while ((str = num.readLine()) != null) {
            System.out.printf(str);
        }
        num.close();
    }

    public static int pow(int value, int powValue) {
        return (int) Math.pow(value, powValue);
    }
}
