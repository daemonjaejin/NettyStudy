package study.funzin.notenums;

import java.util.ArrayList;

/**
 * Created by jin on 16. 11. 6.
 */
public class RainbowColor {

    public static final RainbowColor RED=new RainbowColor("RED", 0);

    public static final RainbowColor ORANGE=new RainbowColor("ORANGE", 1);

    public static final RainbowColor YELLOW=new RainbowColor("YELLOW", 2);

    public static final RainbowColor GREEN=new RainbowColor("GREEN", 3);

    public static final RainbowColor BLUE=new RainbowColor("BLUE", 4);

    public static final RainbowColor INDIGO=new RainbowColor("INDIGO", 5);

    public static final RainbowColor VIOLET=new RainbowColor("VIOLET", 6);

    public static ArrayList<RainbowColor> LIST=new ArrayList<RainbowColor>();

    static {
        LIST.add(RED);
        LIST.add(ORANGE);
        LIST.add(YELLOW);
        LIST.add(GREEN);
        LIST.add(BLUE);
        LIST.add(INDIGO);
        LIST.add(VIOLET);
    }

    String name;

    int ordinal;

    /**
     * 무지개색상 기본 생성자
     * @param name 색상명
     * @param order 색상의 순서
     */
    private RainbowColor(String name, int order) {
        this.name=name;
        this.ordinal=order;
    }

    public String getName() {
        return name;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public static RainbowColor get(String name) {
        for (RainbowColor obj: LIST) {
            if (obj.getName().equals(name)) return obj;
        }
        return null;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "." + name + "(" + ordinal +")";
    }

}
