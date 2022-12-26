import java.util.ArrayList;

public class OddEvenSort {
    public void oddEvenSort(ArrayList<Integer> arr){
        int n = arr.size();
        boolean checkSorted = false;
        while(!checkSorted){
            checkSorted = true;
            //odd portion
            for(int i = 1; i < n-2; i += 2){
                if(arr.get(i) > arr.get(i+1)){
                    int temp = arr.get(i);
                    arr.set(i, arr.get(i+1));
                    arr.set(i+1, temp);
                    checkSorted = false;
                }
            }
            //even portion
            for(int i = 0; i < n-1; i += 2){
                if(arr.get(i) > arr.get(i+1)){
                    int temp = arr.get(i);
                    arr.set(i, arr.get(i+1));
                    arr.set(i+1, temp);
                    checkSorted = false;
                }
            }
        }
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

        OddEvenSort obj = new OddEvenSort();
        obj.oddEvenSort(my_arr);
        System.out.println("sorted array");
        for(int i = 0; i<my_arr.size(); i++){
            System.out.print(my_arr.get(i));
            System.out.print(" ");
        }
        System.out.println();
    }
}
