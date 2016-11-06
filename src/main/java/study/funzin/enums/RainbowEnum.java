package study.funzin.enums;

/**
 * Created by jin on 16. 11. 6.
 */
public enum RainbowEnum {

    RED,

    ORANGE,

    YELLOW,

    GREEN,

    BLUE,

    INDIGO,

    VIOLET;

    public static RainbowEnum get(String name) {
        try {
            return RainbowEnum.valueOf(name);
        }catch (IllegalArgumentException e){
            return null;
        }

    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "." + name() + "(" + ordinal() + ")";
    }

}
