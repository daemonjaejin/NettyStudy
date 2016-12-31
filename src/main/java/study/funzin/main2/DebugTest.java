package study.funzin.main2;

/**
 * Created by jin on 16. 12. 31.
 */
public class DebugTest {

    public static void main(String [] args){
        System.out.println("main !!!");

        int sum = add(1, 3);
        System.out.println(sum);

        System.out.println(NormalClass.word2);

        NormalClass normalClass = new NormalClass();
        System.out.println(normalClass.str());
        System.out.println(normalClass.str2());

        System.out.println(normalClass);

        NormalClass normalClass2 = new NormalClass();
        System.out.println(normalClass2.str());
        System.out.println(normalClass2.str2());

        System.out.println(normalClass2);

    }

    public static Integer add(int num1, int num2){
        return num1+num2;
    }

}
