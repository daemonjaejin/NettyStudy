package study.funzin.enums;

/**
 * Created by JE on 2016-11-25.
 */
public enum NumberEnum {

    test (1);

    private final int value;

    public int getValue(){
        return value;
    }

    NumberEnum(int value){
        this.value = value;
    }

}
