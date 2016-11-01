import study.funzin.util.NumberUtil;


/**
 * Created by JE on 2016-10-25.
 */
public class PointTest {

    public static void main(String args[]){

        int [] intArr = {83603, 85856, 83895, 83507, 83502, 83509, 83992, 83698, 83599};
        for (int i = 0; i < intArr.length; i++) {
            String word = printEstimatedTime(intArr[i]);
            System.out.println("word : " + word);
        }

    }

    public static String printEstimatedTime(Number estimatedTime) {
        if (estimatedTime != null) {
            double value = estimatedTime.doubleValue() / 1000d;
//            System.out.println("printEstimatedTime.value : " + value);
            return NumberUtil.toFixed(value, 1);
        }
        return "";
    }

}
