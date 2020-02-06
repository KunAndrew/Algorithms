package lesson1;

public class Main {
    public static int[] arr = {1, 3, 5, 7, 2, -1, -6};

    public static void twoMax(int[] arr) {
        int temp;
        int numFirst;
        int numMax = arr[0];
        if (arr[1] > numMax) {
            numFirst = numMax;
            numMax = arr[1];
        } else {
            numFirst = arr[1];
        }
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > numMax) {
                temp = numMax;
                numMax = arr[i];
                numFirst = temp;
            }
            if (arr[i] > numFirst & arr[i] < numMax)
                numFirst = arr[i];

//            System.out.println("Max  " + numMax);
//            System.out.println("First : " + numFirst);
        }
        System.out.println("Max number: " + numMax);
        System.out.println("First number before max: " + numFirst);
    }

    public static void threeNumbers(int[] arr) {
        outer:     for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = j; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        if (i==j | i==k | k==j){
                            continue outer;
                        }
                        System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
       // twoMax(arr);
        threeNumbers(arr);
    }
}
