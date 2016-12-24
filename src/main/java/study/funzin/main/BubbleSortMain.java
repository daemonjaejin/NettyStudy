package study.funzin.main;

/**
 * Created by jin on 16. 12. 11.
 */
public class BubbleSortMain {

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

    public static int [] selectSort(int [] intArray){
        int i, j, temp, size;
        size = intArray.length;
        for (i=size-1; i>0; i--){
            for (j=0; j<i; j++){
                if(intArray[j] > intArray[j+1]){
                    temp = intArray[j];
                    intArray[j] = intArray[j+1];
                    intArray[j+1] = temp;
                }
            }
        }
        return intArray;
    }

}
