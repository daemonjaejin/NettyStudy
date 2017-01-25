package study.funzin.type;

/**
 * Created by JE on 2017-01-24.
 */
public class TypeMain {

    public static void main(String args[]){
        TypeMain tm = new TypeMain();
//        tm.byteConfirm();
        tm.charConfirm();
    }

    public void byteConfirm(){
        byte a = 0177;
        byte b = -0177;

        //첫번째 자리 : 8*8*8*0
        //두번째 자리 : 8*8*1
        //세번째 자리 : 8*7
        //네번째 자리 : 1*7
        // 음수 -127 ~ 127 양수 까지의 범위

        System.out.println(a);
        System.out.println(b);
    }

    public void charConfirm(){
        char a = 65535;
        char b = 65510;
        //오직 양수로만 이루어져 있음
        // 0 ~ 65535 까지의 범위
        System.out.println(a);
        System.out.println(b);
    }

}
