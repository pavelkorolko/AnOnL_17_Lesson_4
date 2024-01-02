import java.util.Scanner;

public class Main {
    private static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        //0. Создайте массив целых чисел. Написать программу, которая
        //выводит сообщение о том, входит ли заданное число в массив или нет.
        //zeroTask();
    }

    public static void zeroTask() {
        try {
            System.out.print("Enter the size of array: ");
            int[] arr;
            if (scn.hasNextInt()) {
                int temp = scn.nextInt();
                if (temp < 1) {
                    throw new Exception("Should be positive number!");
                }
                arr = new int[temp];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = (int) (Math.random() * 10);
                }

                //make visible array
//                System.out.print("[ ");
//                for (int i = 0; i < arr.length; i++) {
//                    System.out.print(arr[i] + " ");
//                }
//                System.out.println("]");
            } else {
                throw new Exception("Should be an integer number!");
            }

            System.out.print("Enter a num: ");

            if (scn.hasNextInt()) {
                int result = scn.nextInt();
                boolean flag = true;

                for (int i = 0; i < arr.length; i++) {
                    if (result == arr[i]) {
                        flag = false;
                        System.out.print("Number " + result + " exists in the array!");
                        break;
                    }
                }

                if (flag) {
                    System.out.printf("No number present in this array!");
                }
            } else {
                System.out.println("Should be an integer number!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}