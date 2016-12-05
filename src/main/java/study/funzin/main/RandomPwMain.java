package study.funzin.main;

/**
 * Created by jin on 16. 12. 4.
 */
public class RandomPwMain {

    public static void main(String []  args){
        System.out.println(randomPw());
    }

    public static String randomPw(){

        char pwCollectionSpCha[]  = new char[] {'!','@','#','$','%','^','&','*','(',')'};
        char pwCollectionNum[]   = new char[] {'1','2','3','4','5','6','7','8','9','0',};
        char pwCollectionAll[]  = new char[] {'1','2','3','4','5','6','7','8','9','0',
                'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
                'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                '!','@','#','$','%','^','&','*','(',')'};
        return getRandPw(1, pwCollectionSpCha) + getRandPw(8, pwCollectionAll) + getRandPw(1, pwCollectionNum);
    }

    public static String getRandPw(int size, char[] pwCollection){
        String ranPw = "";
        for (int i = 0; i < size; i++) {
            int selectRandomPw = (int) (Math.random() * (pwCollection.length));
            ranPw += pwCollection[selectRandomPw];
        }
        return ranPw;
    }

}
