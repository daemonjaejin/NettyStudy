package study.funzin.main2;

/**
 * Created by jin on 16. 12. 31.
 */
public class RefernceType {

    public static void main(String args[]){
        MemberDTO.staticMethod();

        RefernceType refernceType = new RefernceType();

//        refernceType.checkMemberDTOName();

        refernceType.callPassByValue();
    }

    public void checkMemberDTOName(){
        MemberDTO dto1 = new MemberDTO("Sangmin");
        System.out.println(dto1.name);
        MemberDTO dto2 = new MemberDTO("Sungchoon");
        System.out.println(dto1.name);
    }

    public void callPassByValue(){
        int a = 10;
        String b = "b";
        MemberDTO memberDTO = new MemberDTO("Sangmin");
        passByValue(a, b, memberDTO);
        System.out.println("callPassByValue");
        System.out.println("a : " + a);
        System.out.println("b : " + b);
        System.out.println("memberDTO.name : " + memberDTO.name);

    }

    public void passByValue(int a, String b, MemberDTO memberDTO){
        a = 20;
        b = "z";
        memberDTO.name = "SungChoon";
//        memberDTO = new MemberDTO("SungChoon");
        System.out.println("passByValue");
        System.out.println("a : " + a);
        System.out.println("b : " + b);
        System.out.println("memberDTO.name : " + memberDTO.name);

    }

}
