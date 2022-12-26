import java.util.ArrayList;
public class BubbleSort {
    public void bubbleSort(ArrayList<Integer> arr){
        for (int i=0; i<arr.size(); i++){
            for (int j=0; j<arr.size()-(i+1); j++){
                if (arr.get(j)>arr.get(j+1)){
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j+1));
                    arr.set(j+1, temp);
                }
            }
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

        BubbleSort x = new BubbleSort();
        x.bubbleSort(my_arr);

        System.out.println("bubble sorted array");
        for(int i = 0; i<my_arr.size(); i++){
            System.out.print(my_arr.get(i));
            System.out.print(" ");
        }
        System.out.println("\n");
    }
}
