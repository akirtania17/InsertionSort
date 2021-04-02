package com.company;

import java.util.Arrays;

public class NumberSet {

    private int[] set;
    private int count;

    public NumberSet(int[] set, int count) {
        this.set = set;
        this.count = count;
    }

    public void insertionSort() {
        int i;
        int key;
        int j;

        for(i = 0; i < count; i++) {
            key = set[i];
            j = i-1;

            while (j >= 0 && set[j] > key) {
                set[j+1] = set[j];
                j -= 1;
            }
            set[j+1] = key;
        }
    }

    public double calcMean() {
        double mean = 0;

        for (int i = 0; i < count; i++) {
            mean += set[i];
        }
        mean /= (double)count;
        return mean;
    }

    public double calcMedian() {
        double median = 0;

        if (count % 2 == 1) {
            median = set[(count/2) + 1];
        }
        else {
            int sum = set[count/2 - 1] + set[count/2];
            median = ((double)sum) / 2.0;
        }
        return median;
    }

    public void calcMode() {
        int mode = 0;
        int maxFrequency = 0;

        for (int i = 0; i < count; i++) {
            int frequency = 0;

            for (int j = 0; j < count; j++) {
                if (set[j] == set[i]) {
                    frequency++;
                }
            }
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mode = set[i];
            }
        }
        if (maxFrequency == 1) {
            System.out.println("Mode: None");
        }
        else {
            System.out.println("Mode: " + mode);
        }
    }

    public void printSet() {
        int[] concatSet = new int[count];
        for (int i = 0; i < count; i++) {
            concatSet[i] = set[i];
        }
        System.out.println(Arrays.toString(concatSet));
    }

    public void addInput(int x) {
        set[count] = x;
        count += 1;
    }
}
