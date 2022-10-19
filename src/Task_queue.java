import java.util.Arrays;

public class Task_queue {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 3};
        System.out.println(Arrays.toString(array));
        array = addFirst(array, 1);
        array = addLast(array, 9);
        System.out.println(Arrays.toString(array));
        array = deriveAllEl(array, 3);
        System.out.println(Arrays.toString(array));
    }

    public static int[] addFirst(int[] array, int element) {
        int[] newArr = new int[]{};
        newArr = Arrays.copyOf(array, array.length + 1);
        System.out.println(Arrays.toString(newArr));
        System.arraycopy(array, 0, newArr, 1, array.length);
        newArr[0] = element;
        return newArr;
    }

    public static int[] addLast(int[] array, int element) {
        int[] newArr = new int[]{};
        newArr = Arrays.copyOf(array, array.length + 1);
        System.out.println(Arrays.toString(newArr));
        System.arraycopy(array, 0, newArr, 0, array.length);
        newArr[newArr.length - 1] = element;
        return newArr;
    }

    // Извлекает из массива все вхождения элемента
    public static int[] deriveAllEl(int[] array, int element) {
        int[] newArr = new int[array.length];
        int index = 0;
        int count = 0; // кол-во вхождений искомого элемента в массив
        for (int j : array) {
            if (j == element) count++;
            else {
                newArr[index] = j;
                index++;
            }
        }
        int[] newArr1 = new int[newArr.length-count];
        System.arraycopy(newArr, 0, newArr1, 0, newArr1.length);
        return newArr1;
    }
}
