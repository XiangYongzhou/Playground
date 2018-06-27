package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by xiangyongzhou on 18/6/21.
 */
public class InsertionSort {
    // Complete the insertionSort function below.
    static int insertionSort(int[] arr) {
        int result = sort(arr, 0, arr.length -1);
        int i = 0;
        i++;
        return result;
    }

    private static int merge(int arr[], int l, int m, int r) {
        int resultCount = 0;
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                if (L[i] < R[j]) {
                    resultCount++;
                }
                i++;

            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
        return resultCount;
    }

    // Main function that sorts arr[l..r] using
    // merge()
    private static int sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            int leftCount = sort(arr, l, m);
            int rightCount = sort(arr , m+1, r);

            // Merge the sorted halves
            int mergeCount = merge(arr, l, m, r);
            return leftCount + rightCount + mergeCount;
        } else {
            return 0;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("foo.out"));

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] arr = {2, 1, 3, 1, 2};
        System.out.println(insertionSort(arr));
        for (int tItr = 0; tItr < 2; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");


            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int result = insertionSort(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
