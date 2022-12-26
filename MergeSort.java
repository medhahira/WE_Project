import java.util.ArrayList;
public class MergeSort {
    public void merge(ArrayList <Integer> arr, int low, int medium, int high){
        int num1 = medium - low + 1;
        int num2 = high - medium;

        ArrayList <Integer> arr1 = new ArrayList<>();
        ArrayList <Integer> arr2 = new ArrayList<>();
        for (int i = 0; i<num1; i++){
            arr1.add(arr.get(low+i));
        }
        for (int i = 0; i<num2; i++){
            arr2.add(arr.get(1+medium+i));
        }
        int arr1_0 = 0; //intial index of arr1
        int arr2_0 = 0; //initial index of arr2
        int arr_0 = low; //initial index of arr

        //condition to check the max number of elements in the respective arrays
        while(arr1_0 < num1 && arr2_0 < num2){
            if (arr1.get(arr1_0) <= arr2.get(arr2_0)){
                arr.set(arr_0, arr1.get(arr1_0));
                arr1_0+=1;
            } else {
                arr.set(arr_0, arr2.get(arr2_0));
                arr2_0+=1;
            }
            arr_0+=1;
        }
        if (arr1_0 < num1){
            while(arr1_0<num1){
                arr.set(arr_0, arr1.get(arr1_0));
                arr1_0+=1;
                arr_0+=1;
            }
        }
        if (arr2_0 < num2){
            while(arr2_0<num2){
                arr.set(arr_0, arr2.get(arr2_0));
                arr2_0+=1;
                arr_0+=1;
            }
        }
    }

    public void mergeSort(ArrayList <Integer> arr, int low, int high){
        if (low<high){
            int medium = low + (high-low)/2;
            mergeSort(arr, low, medium);
            mergeSort(arr, medium+1, high);
            merge(arr, low, medium, high);
        }
    }

    public static void main(String args[]){
        ArrayList <Integer> my_arr = new ArrayList<>();
        my_arr.add(10);
        my_arr.add(19);
        my_arr.add(1);
        my_arr.add(3);
        my_arr.add(2);
        my_arr.add(8);
        my_arr.add(6);
        my_arr.add(9);
        my_arr.add(89);
        my_arr.add(32);
        for(int i = 0; i<my_arr.size(); i++){
            System.out.print(my_arr.get(i));
            System.out.print(" ");
        }
        System.out.println("\n");

        MergeSort x = new MergeSort();

        x.mergeSort(my_arr, 0, my_arr.size()-1);
        System.out.println("sorted array");
        for(int i = 0; i<my_arr.size(); i++){
            System.out.print(my_arr.get(i));
            System.out.print(" ");
        }
        System.out.println("\n");
    }
}
