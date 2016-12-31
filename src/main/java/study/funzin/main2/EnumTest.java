package study.funzin.main2;

/**
 * Created by jin on 16. 12. 31.
 */
public enum EnumTest {

    ONE(1000),
    TWO(2000),
    THREE(3000);

    private final int timeSecond;

    EnumTest(int timeSecond){
        this.timeSecond = timeSecond;
    }

    public int getTimeSecond(){
        return this.timeSecond;
    }

}
