/*
Задача 11. (Сложность: +)
Реализовать волновой алгоритм
 */

public class Task_11_WaveAlgoritm {
    public static void main(String[] args) {
        int[][] arr = new int[7][7];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == 0 || j == 0 || i == arr.length - 1 || j == arr.length - 1) arr[i][j] = -1;
                else arr[i][j] = 0;
            }
        }
//        arr[1][3] = -3; // exit 1
        arr[5][5] = -3; // exit 2
//        arr[1][2] = -1; // wall
        arr[1][1] = 1; // start
//        arr[2][2] = -1; // wall
//        arr[2][3] = -1; // wall
//        arr[2][4] = -1; // wall
        arr[4][2] = -1; // wall
//        arr[4][3] = -1; // wall
//        arr[4][4] = -1; // wall
        PrintArray(arr);
        WaveAlg(arr, 1);
        System.out.println();
        PrintArray(arr);
        MinWay(arr);
        System.out.println();
        PrintArray(arr);
    }

    public static void WaveAlg(int[][] arr, int startPoint) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == startPoint) {
                    if (arr[i][j - 1] == -3 || arr[i + 1][j] == -3 || arr[i][j + 1] == -3 || arr[i - 1][j] == -3)
                        return;
                    if (arr[i][j - 1] == 0) arr[i][j - 1] = startPoint + 1;
                    if (arr[i + 1][j] == 0) arr[i + 1][j] = startPoint + 1;
                    if (arr[i][j + 1] == 0) arr[i][j + 1] = startPoint + 1;
                    if (arr[i - 1][j] == 0) arr[i - 1][j] = startPoint + 1;
                }
            }
        }
        WaveAlg(arr, startPoint + 1);
    }


    public static void MinWay(int[][] arr) {
        int min = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == -3) {
                    if ((min == -1 || arr[i][j - 1] < min) && arr[i][j - 1] != -1 && arr[i][j - 1] != 0)
                        min = arr[i][j - 1];
                    if ((min == -1 || arr[i + 1][j] < min) && arr[i + 1][j] != -1 && arr[i + 1][j] != 0)
                        min = arr[i + 1][j];
                    if ((min == -1 || arr[i][j + 1] < min) && arr[i][j + 1] != -1 && arr[i][j + 1] != 0)
                        min = arr[i][j + 1];
                    if ((min == -1 || arr[i - 1][j] < min) && arr[i - 1][j] != -1 && arr[i - 1][j] != 0)
                        min = arr[i-1][j];
                }
            }
        }
        System.out.printf("Min way = %d\n", min);
        int l = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == min && (arr[i][j - 1] == -3 || arr[i + 1][j] == -3 || arr[i][j + 1] == -3 || arr[i - 1][j] == -3)) {
                    while (arr[i][j - 1] != 1 && arr[i + 1][j] != 1 && arr[i][j + 1] != 1 && arr[i - 1][j] != 1) {
                        if (arr[i][j - 1] == min - l) {
                            arr[i][j - 1] = min;
                            j -= 1;
                            l++;
                        } else if (arr[i + 1][j] == min - l) {
                            arr[i + 1][j] = min;
                            i += 1;
                            l++;
                        } else if (arr[i][j + 1] == min - l) {
                            arr[i][j + 1] = min;
                            j += 1;
                            l++;
                        } else if (arr[i - 1][j] == min - l) {
                            arr[i - 1][j] = min;
                            i -= 1;
                            l++;
                        }
                    }
                    System.out.printf("Steps = %d\n", l);
                    return;
                }
            }
        }
    }


    public static void PrintArray(int[][] arr) {
        for (int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(ints[j] + "\t");
            }
            System.out.println();
        }
    }
}
