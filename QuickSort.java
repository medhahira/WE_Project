import java.util.ArrayList;

public class QuickSort {
    public void quickSort(ArrayList<Integer> arr, int si, int ei){
        if(si >= ei) return;
        int pivot = arr.get(ei);
        int i = si;
        int j = si;
        while(j < ei){
            if(arr.get(j) <= pivot){
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
                i++;
            }
            j++;
        }
        int temp = arr.get(i);
        arr.set(i, arr.get(ei));
        arr.set(ei, temp);
        quickSort(arr, si, i-1);
        quickSort(arr, i + 1, ei);
        return;
    }
    public static void main(String[] args) {
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
        System.out.println();

        QuickSort obj = new QuickSort();
        obj.quickSort(my_arr, 0, my_arr.size() - 1);
        System.out.println("sorted array");
        for(int i = 0; i<my_arr.size(); i++){
            System.out.print(my_arr.get(i));
            System.out.print(" ");
        }
        System.out.println();
    }
}
