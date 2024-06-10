import java.util.*;
import java.io.*;

public class Qsort{
    public static void bubbleSort(int[] arr, int l, int r){
        for(int i = l; i < r; i++){
            for(int j = i+1; j<r; j++){
                if(arr[i]>arr[j]) swap(i, j, arr);
            }
        }
    }
    public static void insertionSort(int i )
    public static void main(String[] args) {
        int[] arr = {5,1,3,7,4,6,9,2};
        bubbleSort(arr, 0, arr.length-1);
        for(Integer i : arr){
            System.out.print(i + " ");
        }
    }
    public static void quickSort(int[] arr, int l, int r){
        if(l >= r) return;
        int pi = partition(l, r, arr);
        quickSort(arr, pi+1, r);
        quickSort(arr, l, pi-1);
    }
    public static int partition(int l, int r, int[] arr){
        int pivot = arr[r];
        int ptr = l - 1;
        for(int i = l; i < r; i++){
            if(arr[i] < pivot){
                ptr++;
                swap(ptr, i, arr);
            }
        }
        swap(ptr+1, r, arr);
        return ptr + 1;
    }
    public static void swap(int target, int target2, int[] arr)
    {
        int temp = arr[target2];
        arr[target2] = arr[target];
        arr[target] = temp;
    }
}