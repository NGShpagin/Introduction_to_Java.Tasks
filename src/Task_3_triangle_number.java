/*
Задча 3. (Сложность: +)
Написать программу вычисления n-ого треугольного числа. url
 */

public class Task_3_triangle_number {
    public static void main(String[] args) {
        System.out.println(triangle_rec(4));
        System.out.println(triangle(5));
    }

    // Вариант 1
    public static double triangle(int n) {
        double t = 0.5 * n * (n + 1);
        return t;
    }

    //  Вариант 2
    public static double triangle_rec(int n) {
        double t;
        if (n == 1) return 1;
        else return (triangle_rec(n - 1) + n);
    }
}
