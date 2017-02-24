package study.funzin.main5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JE on 2017-02-24.
 */
public class forTest2 {

    public static void main(String [] args){

        List<String> list1 = new ArrayList<String>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list1.add("5");

        List<String> list2 = new ArrayList<String>();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("4");
        list2.add("5");

        for (int i = 0; i < list1.size(); i++) {
            System.out.println("i : " + i);
            for (int j = 0; j < list2.size(); j++) {
                System.out.println("j : " + j);
                if(list1.get(i).equals(list2.get(j))){
                    System.out.println("값 : " + list2.get(j));
                    list2.remove(j);
                }
            }
        }

        System.out.println("list1 : " + list1.size());
        System.out.println("list2 : " + list2.size());

    }

}
