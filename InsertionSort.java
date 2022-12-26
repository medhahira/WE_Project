import java.util.ArrayList;
public class InsertionSort {
    public void insertionSort(ArrayList <Integer> arr){
        int key;
        for (int i = 1; i<arr.size(); i++){
            key = arr.get(i);
            int j = i-1;
            while(j>=0 && arr.get(j) >= key){
                arr.set(j+1, arr.get(j));
                j-=1;
            }
            arr.set(j+1, key);
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

        InsertionSort x = new InsertionSort();
        x.insertionSort(my_arr);

        System.out.println("insertion sorted array");
        for(int i = 0; i<my_arr.size(); i++){
            System.out.print(my_arr.get(i));
            System.out.print(" ");
        }
        System.out.println("\n");
    }
}
