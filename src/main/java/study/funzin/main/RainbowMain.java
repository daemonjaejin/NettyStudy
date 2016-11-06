package study.funzin.main;

import study.funzin.enums.RainbowEnum;
import study.funzin.notenums.RainbowColor;

import java.util.List;

/**
 * Created by jin on 16. 11. 6.
 */
public class RainbowMain {

    public static void main(String[] args) {
        main_list();

        String[] colors=new String[]{"RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "INDIGO", "VIOLET", "WHITE"};
        int testCnt=10000000;

        test1(colors, testCnt);
        test2(colors, testCnt);
    }

    public static void main_list() {
        System.out.println("===== RainbowColor 목록 =====");
        List<RainbowColor> list=RainbowColor.LIST;
        for (int i=0;i<list.size();++i) {
            System.out.println("list[" + i + "] ==> " + list.get(i));
        }
        System.out.println();

        System.out.println("===== RainbowEnum 목록 =====");
        RainbowEnum[] list2=RainbowEnum.values();
        for (int i=0;i<list2.length;++i) {
            System.out.println("list[" + i + "] ==> " + list2[i]);
        }
        System.out.println();

    }

    public static void test1(String[] colors, int testcnt) {

        System.out.println("===== RainbowColor 테스트 =====");
        long t1=System.currentTimeMillis();
        for (int cnt=0;cnt<testcnt;++cnt) {
            for (int i=0;i<colors.length;++i) {
                if (cnt==0) System.out.println(colors[i] + " ==> " + RainbowColor.get(colors[i]));
            }
        }
        System.out.println("::걸린시간 " + (System.currentTimeMillis()-t1) + " ms");
        System.out.println();

    }

    public static void test2(String[] colors, int testcnt) {

        System.out.println("===== RainbowEnum 테스트 =====");
        long t1=System.currentTimeMillis();
        for (int cnt=0;cnt<testcnt;++cnt) {
            for (int i=0;i<colors.length;++i) {
                if (cnt==0) System.out.println(colors[i] + " ==> " + RainbowEnum.get(colors[i]));
            }
        }
        System.out.println("::걸린시간 " + (System.currentTimeMillis()-t1) + " ms");
        System.out.println();
    }

}
