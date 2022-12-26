import java.util.ArrayList;

public class SelectionSort {
    public void selectionSort(ArrayList<Integer> arr, int id){
        if(id >= arr.size()) return;
        int min = id;
        for(int i = id; i < arr.size(); i++){
            if(arr.get(i) < arr.get(min)) min = i;
        }
        int temp = arr.get(id);
        arr.set(id, arr.get(min));
        arr.set(min, temp);
        selectionSort(arr, id + 1); //pass the array minus the part till current id to the same function (recursion)
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

        SelectionSort obj = new SelectionSort();
        obj.selectionSort(my_arr, 0);
        System.out.println("sorted array");
        for(int i = 0; i<my_arr.size(); i++){
            System.out.print(my_arr.get(i));
            System.out.print(" ");
        }
        System.out.println("\n");
    }
}
