package study.funzin.main3;

/**
 * Created by jin on 17. 1. 9.
 */
public class JavaLang {

    public static void main(String [] args){

        JavaLang sample = new JavaLang();
//        sample.numberTypeCheck();
//        sample.numberTypeCheck2();
//        sample.numberMinMaxCheck();
//        sample.systemPropertiesCheck();
//        sample.numberMinMaxCheck();
//        sample.printStreamCheck();
//        sample.printNull();
//        sample.mathCheck1();
//        sample.matchCheck2();
//        sample.matchCheck3();
        sample.matchCheck4();

    }

    public void numberTypeCheck(){
        String value1 = "3";
        String value2 = "5";
        byte byte1 = Byte.parseByte(value1);
        byte byte2 = Byte.parseByte(value2);

        System.out.println(byte1 + byte2);

        Integer refInt1 = Integer.parseInt(value1);
        Integer refInt2 = Integer.parseInt(value2);

        System.out.println(refInt1 + refInt2 + "7");

    }

    public void numberTypeCheck2(){
        Integer refInt1;
        refInt1 = 100;
        System.out.println(refInt1.doubleValue());
    }

    public void numberMinMaxCheck(){

        long startTime = System.currentTimeMillis();
        long startNanoTime = System.nanoTime();

        System.out.println("Byte min=" + Byte.MAX_VALUE + " max="+Byte.MAX_VALUE);
        System.out.println("Short min=" + Short.MAX_VALUE + " max="+Short.MAX_VALUE);
        System.out.println("Integer min=" + Integer.MAX_VALUE + " max="+Integer.MAX_VALUE);
        System.out.println("Long min=" + Long.MAX_VALUE + " max="+Long.MAX_VALUE);
        System.out.println("Float min=" + Float.MAX_VALUE + " max="+Float.MAX_VALUE);
        System.out.println("Double min=" + Double.MAX_VALUE + " max="+Double.MAX_VALUE);
        System.out.println("Character min=" + (int)Character.MAX_VALUE + " max="+(int)Character.MAX_VALUE);
        System.out.println("Integer BINARY min=" + Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println("Integer BINARY max=" + Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println("Integer HEX min=" + Integer.toHexString(Integer.MIN_VALUE));
        System.out.println("Integer HEX max=" + Integer.toHexString(Integer.MAX_VALUE));

        System.out.println("Milli second=" + (System.currentTimeMillis()-startTime));
        System.out.println("Nano second=" + (System.nanoTime()-startNanoTime));

    }

    public void systemPropertiesCheck(){
        System.out.println("java.version="+System.getProperty("java.version"));
        System.out.println("JAVA_HOME="+System.getenv("JAVA_HOME"));
    }

    public void printStreamCheck(){
        byte b = 127;
        short s = 32767;
        System.out.println(b);
        System.out.println(s);
        printInt(b);
        printInt(s);
    }

    public void printInt(int value){
        System.out.println(value);
    }

    public void printNull(){
        Object obj = null;
        System.out.println(obj);
//        System.out.println(obj.toString());
        System.out.println(obj + " is object's value");
    }

    public void mathCheck1(){
        double number1 = 45;
        double number2 = -45;

        System.out.println("Math.abs(45)="+Math.abs(number1));
        System.out.println("Math.abs(-45)="+Math.abs(number2));

        System.out.println("Math.signum(45)="+Math.signum(number1));
        System.out.println("Math.signum(-45)="+Math.signum(number2));

        System.out.println("Math.min(45, -45)="+Math.max(number1, number2));
        System.out.println("Math.max(45, -45)="+Math.max(number1, number2));
    }

    public void matchCheck2(){
        double [] numbers = new double[]{
                3.15, 3.62, -3.15, -3.62
        };
        for (double number : numbers){
            System.out.println(number);
            System.out.println("Math.round()="+Math.round(number));
            System.out.println("Math.rint()="+Math.rint(number));
            System.out.println("Math.ceil()="+Math.ceil(number));
            System.out.println("Math.floor()="+Math.floor(number));
        }
    }

    public void matchCheck3(){
        System.out.println("Math.sqrt(1)="+Math.sqrt(1));
        System.out.println("Math.sqrt(2)="+Math.sqrt(2));
        System.out.println("Math.cbrt(8)="+Math.cbrt(8));
        System.out.println("Math.cbrt(27)="+Math.cbrt(27));
        System.out.println("Math.pow(2,2)="+Math.pow(2, 2));
        System.out.println("Math.scalb(2,4)="+Math.scalb(2, 4));
        System.out.println("Math.hypot(3,4)="+Math.hypot(3, 4));
        System.out.println("Math.sqrt(Math.pow(3,2)+Math.pow(4,2))="+Math.sqrt(Math.pow(3, 2) + Math.pow(4, 2))); }
    
    public void matchCheck4(){
        double number1 = 45;
        double number2 = 90;

        double radian45 = Math.toRadians(number1);
        double radian90 = Math.toRadians(number2);

        System.out.println("Radian value of 45 degree is "+radian45);
        System.out.println("Radian value of 90 degree is "+radian90);
        System.out.println("Math.sin(radian45)="+Math.sin(radian45));
        System.out.println("Math.sin(radian90)="+Math.sin(radian90));
        System.out.println("Math.cos(radian45)="+Math.cos(radian45));
        System.out.println("Math.cos(radian90)="+Math.cos(radian90));
        System.out.println("Math.tan(radian45)="+Math.tan(radian45));
        System.out.println("Math.tan(radian90)="+Math.tan(radian90));

    }

}
