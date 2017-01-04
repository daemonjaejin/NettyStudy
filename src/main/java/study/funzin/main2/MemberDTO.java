package study.funzin.main2;

/**
 * Created by jin on 16. 12. 31.
 */
public class MemberDTO {

    public String name = "name";
//    public static String name = "name";

    public MemberDTO(String name){
        this.name = name;
    }



    public static void staticMethod(){
        System.out.println("staticMethod");
//        System.out.println(name);
    }

}
