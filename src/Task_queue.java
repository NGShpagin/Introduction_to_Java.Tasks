import java.util.Arrays;

public class Task_queue {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(array));
        array = addFirst(array, 1);
        array = addLast(array, 9);
        System.out.println(Arrays.toString(array));
    }

    public static int[] addFirst(int[] array, int element) {
        int[] newArr = new int[]{};
        newArr = Arrays.copyOf(array, array.length+1);
        System.out.println(Arrays.toString(newArr));
        System.arraycopy(array, 0, newArr, 1, array.length);
        newArr[0] = element;
        return newArr;
    }

    public static int[] addLast(int[] array, int element) {
        int[] newArr = new int[]{};
        newArr = Arrays.copyOf(array, array.length+1);
        System.out.println(Arrays.toString(newArr));
        System.arraycopy(array, 0, newArr, 0, array.length);
        newArr[newArr.length-1] = element;
        return newArr;
    }
}
