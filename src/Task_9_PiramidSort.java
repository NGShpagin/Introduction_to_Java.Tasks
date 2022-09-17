/*
Задача 9. (Сложность: +)
Реализовать алгоритм пирамидальной сортировки (HeapSort)
 */

public class Task_9_PiramidSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        int len = arr.length;
        printArray(arr);
        sort(arr);
        printArray(arr);
    }

    public static void sort(int arr[]) {
        for (int i = arr.length / 2 - 1; i >= 0; i--)
            heap(arr, arr.length, i);

        for (int i = arr.length - 1; i > 0; i--) {
            int n = arr[0];
            arr[0] = arr[i];
            arr[i] = n;
            heap(arr, i, 0);
        }
    }

    public static void heap(int arr[], int len, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < len && arr[left] > arr[largest]) largest = left;
        if (right < len && arr[right] > arr[largest]) largest = right;
        if (largest != i) {
            int n = arr[i];
            arr[i] = arr[largest];
            arr[largest] = n;
            heap(arr, len, largest);
        }
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
