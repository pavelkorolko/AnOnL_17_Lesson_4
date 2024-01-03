import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        //0. Создайте массив целых чисел. Написать программу, которая
        //выводит сообщение о том, входит ли заданное число в массив или нет.
        //zeroTask();

        //1. Создайте массив целых чисел. Удалите все вхождения заданного числа из массива.
        //Если такого числа нет, выведите сообщение об этом.
        //В результате должен быть новый массив без указанного числа.
        //firstTask();

        //2. Создайте и заполните массив случайными числами и выведите max/min/average значения.
        // Для генерации используйте  Math.random(). Пусть размер массива вводится с консоли.
        //secondTask();

        //3. Создайте 2 массива из 5 чисел. Выведите массивы на консоль.
        // Посчитать арифметическое элементов каждого массива и вывести большее значение или их равность.
        thirdTask();

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

                //generating random nums
                arr = generateRandomNums(arr);

                //make visible array
                System.out.println(printArray(arr));
//
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

    public static void firstTask() {
        try {
            System.out.print("Enter the size of array: ");
            int[] arr;
            if (scn.hasNextInt()) {
                int result = scn.nextInt();
                if (result > 0) {
                    arr = new int[result];

                    arr = generateRandomNums(arr);

                    //initial array
                    System.out.println(printArray(arr));

                    System.out.print("Enter the num: ");
                    if (scn.hasNextInt()) {
                        int input = scn.nextInt();

                        boolean flag = true;
                        int count = 0;
                        for (int i = 0; i < arr.length; i++) {
                            if (arr[i] == input) {
                                count++;
                                flag = false;
                            }
                        }

                        int[] temp = new int[arr.length - count];
                        for (int m = 0, k = 0; m < arr.length; m++) {
                            if (arr[m] != input) {
                                temp[k] = arr[m];
                                k++;
                            }
                        }
                        arr = temp;

                        //modified array
                        System.out.println(printArray(arr));

                        if (flag) {
                            System.out.println("There is no a such number!");
                        }
                    } else {
                        throw new Exception("Should be an integer!");
                    }
                } else {
                    throw new Exception("Should be a positive number");
                }
            } else {
                throw new Exception("Should be an integer!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void secondTask() {
        System.out.print("Enter the array size: ");
        if (scn.hasNextInt()) {
            int result = scn.nextInt();
            if (result < 1) {
                System.out.println("Should be a positive number!");
            } else {
                int[] arr = new int[result];

                arr = generateRandomNums(arr);

                //prompt
                System.out.println(printArray(arr));

                //max
                int max = 0;
                int min = arr[0];
                int sum = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] > max) {
                        max = arr[i];
                    }
                    if (arr[i] < min) {
                        min = arr[i];
                    }

                    sum += arr[i];
                }

                double avg = sum / arr.length;

                System.out.printf("Max value %d, min value %d and average value %.2f", max, min, avg);
            }

        } else {
            System.out.println("Should be a number!");
        }
    }

    public static void thirdTask() {
        int[] arr_1 = new int[5];
        int[] arr_2 = new int[5];

        arr_1 = generateRandomNums(arr_1);
        System.out.println(printArray(arr_1));
        double avg_1 = averageValue(arr_1);

        arr_2 = generateRandomNums(arr_2);
        System.out.println(printArray(arr_2));
        double avg_2 = averageValue(arr_2);

        if (avg_1 > avg_2) {
            System.out.printf("Average " + avg_1 + " of first array is bigger!");
        } else if (avg_1 < avg_2) {
            System.out.println("Average " + avg_2 + " of second array is bigger!");
        } else {
            System.out.println("Average " + avg_1 + " values are equal!");
        }
    }

    public static int[] generateRandomNums(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        return arr;
    }

    public static String printArray(int[] arr) {
        StringBuilder str = new StringBuilder();
        str.append("[ ");
        for (int i = 0; i < arr.length; i++) {
            str.append(arr[i] + " ");
        }

        str.append("]");

        return str.toString();
    }

    public static double averageValue(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }
}