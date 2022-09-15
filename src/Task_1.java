/*
Реализовать функцию возведения числа a в степень b. a, b <- Z. Сводя количество выполняемых дейсвтий к минимуму.
Пример 1: a = 3, b = 2, ответ: 9
Пример 2: a = 2, b = -2, ответ: 0.25
Пример 3: a = 3, b = 0, ответ: 1
Пример 4: a = 0, b = 0, ответ: не определенно
Пример 5: входные данные находятся в файле input.txt в виде:
    a 3
    b 10
    Результат нужно сохранить в файле output.txt. (Ответ: 1000)
 */

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
