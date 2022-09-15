/*
Задча 4. (Сложность: +)
Написать программу, показывающую последовательность действий для игры “Ханойская башня”
 */

import java.util.ArrayList;
import java.util.List;

public class Task_4_HanoiTower {
    public static void main(String[] args) {
        int disks = 4;
        int step = 0;
        List<Integer> first_pir = fill(disks);
        List<Integer> second_pir = new ArrayList<Integer>();
        List<Integer> third_pir = new ArrayList<Integer>();
        System.out.printf("Было:\nБашня 1: %s\n", first_pir.toString());
        System.out.printf("Башня 2: %s\n", second_pir.toString());
        System.out.printf("Башня 3: %s\n", third_pir.toString());
        if (disks % 2 == 0) {
            step = rec_solve(disks, first_pir, second_pir, third_pir, 0);
        }
        else {
            step = rec_solve(disks, first_pir, third_pir, second_pir, 0);
        }

        System.out.printf("\nСтало\nБашня 1: %s\n", first_pir.toString());
        System.out.printf("Башня 2: %s\n", second_pir.toString());
        System.out.printf("Башня 3: %s\n", third_pir.toString());
        System.out.printf("Кол-во ходов: %d", step);

    }

    public static int rec_solve(int disks, List<Integer> first_pir, List<Integer> second_pir, List<Integer> third_pir, int step) {
        if (third_pir.size() != disks) {
            if (first_pir.size() != 0 && (second_pir.size() == 0 || second_pir.get(0) > first_pir.get(0))) {
                second_pir.add(0, first_pir.get(0));
                first_pir.remove(0);
            } else {
                first_pir.add(0, second_pir.get(0));
                second_pir.remove(0);
            }
            step += 1;
            return rec_solve(disks, third_pir, first_pir, second_pir, step);
        }
        return step;
    }

    public static List<Integer> fill(int disks) {
        List<Integer> first_pir = new ArrayList<Integer>();
        for (int i = 1; i <= disks; i++) {
            first_pir.add(i);
        }
        return first_pir;
    }
}
