import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    Opgave 3
    Lav et program hvor der kan indtastes mindst 20 forskellige tal, som så bliver sorteret og printet ud i
    rækkefølge fra størst til mindst.
 */

public class Sorter {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        List<Integer> myList = new ArrayList<Integer>();

        System.out.println("Enter number of items to sort");
        int amountOfItems = in.nextInt();

        while (amountOfItems < 20) {
            System.out.println("Number is too low!");
            System.out.println("Enter number of items to sort");
            amountOfItems = in.nextInt();
        }

        for (int i = 1; i <= amountOfItems; i++) {
            System.out.println("Add a number to the sorter");
            int x = in.nextInt();
            myList.add(x);
        }

        int len = myList.toArray().length;
        int [] array = new int[len];

        for (int i = 0; i < len; i++) {
            array[i] = myList.get(i);
        }

        bubbleSort(array,len);
    }

    public static void bubbleSort(int [] sort_arr, int len){

        for (int i=0; i<len-1; ++i){

            for(int j=0; j<len-i-1; ++j){

                if(sort_arr[j+1] > sort_arr[j]){

                    int swap = sort_arr[j];
                    sort_arr[j] = sort_arr[j+1];
                    sort_arr[j+1] = swap;

                }
            }
        }

        for (int i = 0; i < sort_arr.length; i++) {
            System.out.println(sort_arr[i]);
        }
    }
}
