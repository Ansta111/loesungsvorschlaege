package de.hhu.propra.blatt1;

public class BubbleSort {
    public static int[] bubblesort(int[] array) {
        int temp;
        for(int i=1; i<array.length; i++) {
            for(int j=0; j<array.length-i; j++) {
                if(array[j]>array[j+1]) {
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {

        int[] array={1,5,8,2,7,4};
        int[] sorted=bubblesort(array);

        for (int i : sorted) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
