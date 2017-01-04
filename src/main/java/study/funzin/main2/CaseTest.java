package study.funzin.main2;

/**
 * Created by jin on 16. 12. 31.
 */
public class CaseTest {

    public static void main(String [] aaa){
        noBreak();
        yesBreak();
        strCase();
    }

    public static void noBreak(){
        int i  = 2;
        switch (i){
            case 0 :
                System.out.println(0);
            case 1 :
                System.out.println(1);
            case 2 :
                System.out.println(2);
            case 3 :
                System.out.println(3);
            case 4 :
                System.out.println(4);
            case 5 :
                System.out.println(5);
            default:
                System.out.println("no");
        }
        System.out.println("=============================================================================");
    }

    public static void yesBreak(){
        int i  = 2;
        switch (i){
            case 0 :
                System.out.println(0);
                break;
            case 1 :
                System.out.println(1);
                break;
            case 2 :
                System.out.println(2);
                break;
            case 3 :
                System.out.println(3);
                break;
            case 4 :
                System.out.println(4);
                break;
            case 5 :
                System.out.println(5);
                break;
            default:
                System.out.println("no");
        }
        System.out.println("=============================================================================");
    }

    public static void strCase(){
        String word  = "이";
        switch (word){
            case "영" :
                System.out.println(0);
                break;
            case "일" :
                System.out.println(1);
                break;
            case "이" :
                System.out.println(2);
                break;
            case "삼" :
                System.out.println(3);
                break;
            case "사" :
                System.out.println(4);
                break;
            case "오" :
                System.out.println(5);
                break;
            default:
                System.out.println("no str");
        }
        System.out.println("=============================================================================");
    }

}
