package study.funzin.enums;

/**
 * Created by JE on 2016-11-25.
 */
public enum TLVSIDEnum400 {

    Alarm1_Grade(300),
    Alarm2_Grade(301),
    Alarm3_Grade(302),
    Alarm4_Grade(303),
    Alarm5_Grade(304),
    Alarm6_Grade(305),
    Alarm7_Grade(306),
    Alarm8_Grade(307),
    Alarm9_Grade(308),
    Alarm10_Grade(309),
    Alarm11_Grade(310),
    Alarm12_Grade(311),
    Alarm13_Grade(312),
    Alarm14_Grade(313),
    Alarm15_Grade(314)

    ;

    private final int value;

    TLVSIDEnum400(int value){
        this.value = value;
    }


    public int getValue() {
        return value;
    }

    public static TLVSIDEnum400 fromInt(int text) {
        for (TLVSIDEnum400 b : TLVSIDEnum400.values()) {
            if (text == b.value) {
                return b;
            }
        }
        return null;
    }

    public static TLVSIDEnum400 fromInt2(int text){

        return null;
    }

}
