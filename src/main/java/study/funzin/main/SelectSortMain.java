package study.funzin.main;

/**
 * Created by jin on 16. 12. 11.
 */
public class SelectSortMain {

    public static void main(String [] args){

        int [] intArray = {69, 10, 30, 2, 16, 8, 31, 22};
        for(int number : intArray){
            System.out.println(number);
        }
        System.out.println("=====================================================");
        intArray = selectSort(intArray);
        for(int number : intArray){
            System.out.println(number);
        }

    }

    public static int [] selectSort(int [] a){
        int i, j, min;
        int b[] = new int [a.length];
        for (i=0; i<a.length-1; i++){
            min = i;
            for(j=i+1; j<a.length; j++){
                if(a[j] < a[min]){
                    min = j;
                }
            }
            b = swap(a, min, i);
        }
        return b;
    }

    public static int [] swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        return a;
    }

}
