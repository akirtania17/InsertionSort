package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int userNum = 0;
        int count = 0;
        int UIFunc = -1;
        int[] userSet = new int[25];

        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter Integers. Type -999 to Stop.");

        while (userNum != -999 && count <= 25) {
            userNum = sc.nextInt();

            if (userNum != -999) {
                count += 1;
                userSet[count - 1] = userNum;
            }
        }

        NumberSet nSet = new NumberSet(userSet, count);
        nSet.insertionSort();

        System.out.println("\n~ User Interface ~");
        System.out.println("0. End Program");
        System.out.println("1. Mean");
        System.out.println("2. Median");
        System.out.println("3. Mode");
        System.out.println("4. Display Set");
        System.out.println("5. Input Another Number");

        while (UIFunc != 0) {
            System.out.print("\nChoose a Function: ");
            UIFunc = sc.nextInt();
            while (UIFunc < 0 || UIFunc > 5) {
                System.out.print("Invalid. Re-Enter: ");
            }

            if (UIFunc == 1) {
                System.out.println("Mean: " + nSet.calcMean());
            }
            else if (UIFunc == 2) {
                System.out.println("Median: " + nSet.calcMedian());
            }
            else if (UIFunc == 3) {
                nSet.calcMode();
            }
            else if (UIFunc == 4) {
                nSet.printSet();
            }
            else if (UIFunc == 5) {
                if (count < 25) {
                    int inputNum;

                    System.out.print("Input Number: ");
                    inputNum = sc.nextInt();

                    nSet.addInput(inputNum);
                    nSet.insertionSort();
                }
                else {
                    System.out.println("Set at maximum size.");
                }
            }
        }
    }
}
