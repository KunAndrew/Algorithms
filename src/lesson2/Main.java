package lesson2;

import java.util.Arrays;

public class Main {
    public static int[] arr;
    public static int realLength = 0;

    public static void main(String[] args) {
        arr = new int[100000];
        for (int i = 0; i <= arr.length - 1; i++) {
            addToArr((int) (Math.random() * 100));
        }
//        long start = System.currentTimeMillis();
//        selectionSort(arr);
//        long finish = System.currentTimeMillis();
//        long timeConsumedMillis = finish - start;
//        System.out.println("Selection sort " + timeConsumedMillis);

//        long start2 = System.currentTimeMillis();
//        insertionSort(arr);
//        long finish2 = System.currentTimeMillis();
//        long timeConsumedMillis2 = finish2 - start2;
//        System.out.println("insertion sort " + timeConsumedMillis2);

        long start3 = System.currentTimeMillis();
        mergeSort(arr);
        long finish3 = System.currentTimeMillis();
        long timeConsumedMillis3 = finish3 - start3;
        System.out.println("merge sort " + timeConsumedMillis3);


    }

    public static void addToArr(int num) {
        arr[realLength] = num;
        realLength++;
    }

    public static void delete(int ix) {
        for (int i = ix; i < realLength; i++) {
            arr[i] = arr[i + 1];
        }
        if (realLength > 0) {
            realLength--;
        }
    }

    public static boolean find(int value) {
        for (int i = 0; i < realLength; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    public static boolean binaryFind(int value) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (value == arr[mid]) {
                return true;
            } else {
                if (value < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIx]) {
                    minIx = j;
                }
            }
            swap(arr, i, minIx);
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > tmp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = tmp;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSortInt(arr, tmp, 0, arr.length - 1);
    }

    private static void mergeSortInt(int[] arr, int[] tmp, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSortInt(arr, tmp, lo, mid);
        mergeSortInt(arr, tmp, mid + 1, hi);
        merge(arr, tmp, lo, mid, hi);
    }

    private static void merge(int[] arr, int[] tmp, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            tmp[k] = arr[k];
        }
    }
}
