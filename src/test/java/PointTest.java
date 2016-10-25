import study.funzin.util.NumberUtil;


/**
 * Created by JE on 2016-10-25.
 */
public class PointTest {

    public static void main(String args[]){
        String word = printEstimatedTime(83559);
        System.out.println("word : " + word);
    }

    public static String printEstimatedTime(Number estimatedTime) {
        if (estimatedTime != null) {
            double value = estimatedTime.doubleValue() / 1000d;
            System.out.println("printEstimatedTime.value : " + value);
            return NumberUtil.toFixed(value, 1);
        }
        return "";
    }

}
