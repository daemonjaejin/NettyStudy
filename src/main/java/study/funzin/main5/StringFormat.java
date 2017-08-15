package study.funzin.main5;

/**
 * Created by JE on 2017-06-14.
 */
public class StringFormat {

    public static void main(String[] args){
        System.out.println("[example 1]");
        System.out.println("12345678901234567890");
        System.out.println(String.format("%s, %s", "KOREA", "JAPAN"));
        System.out.print("\n");

        System.out.println("[example 2]");
        System.out.println("12345678901234567890");
        System.out.println(String.format("%10s%10s", "KOREA", "JAPAN"));
        System.out.println(String.format("%2$10s%1$10s", "KOREA", "JAPAN"));
        System.out.print("\n");

        System.out.println("[example 3]");
        System.out.println("12345678901234567890");
        System.out.println(String.format("%-10s%-10s", "KOREA", "JAPAN"));
        System.out.print("\n");

        System.out.println("[example 4]");
        System.out.println("12345678901234567890");
        System.out.println(String.format("%d, %d", 12345, 67890));
        System.out.print("\n");

        System.out.println("[example 5]");
        System.out.println("12345678901234567890");
        System.out.println(String.format("%10d%10d", 12345, 67890));
        System.out.println(String.format("%2$10d%1$10d", 12345, 67890));
        System.out.print("\n");

        System.out.println("[example 6]");
        System.out.println("12345678901234567890");
        System.out.println(String.format("%-10d%-10d", 12345, 67890));
        System.out.print("\n");

        System.out.println("[example 7]");
        System.out.println("12345678901234567890");
        System.out.println(String.format("%010d%010d", 12345, 67890));
        System.out.print("\n");

        System.out.println("[example 8]");
        System.out.println("12345678901234567890");
        System.out.println(String.format("%+10d%+10d", 100, -200));
        System.out.print("\n");

        System.out.println("[example 9]");
        System.out.println("12345678901234567890");
        System.out.println(String.format("%+010d%+010d", 100, -200));
        System.out.print("\n");

        System.out.println("[example 10]");
        System.out.println("12345678901234567890");
        System.out.println(String.format("%(10d%(10d", 100, -200));
        System.out.print("\n");

        System.out.println("[example 11]");
        System.out.println("12345678901234567890");
        System.out.println(String.format("%,10d%,10d", 10000, -20000));
        System.out.print("\n");

        System.out.println("[example 12]");
        System.out.println("12345678901234567890");
        System.out.println(String.format("%10x%10x", 2047, 2047));
        System.out.print("\n");

        System.out.println("[example 13]");
        System.out.println("12345678901234567890");
        System.out.println(String.format("%10X%10X", 2047, 2047));
        System.out.print("\n");

        System.out.println("[example 14]");
        System.out.println("12345678901234567890");
        System.out.println(String.format("%10o%10o", 2047, 2047));
        System.out.print("\n");

        System.out.println("[example 15]");
        System.out.println("12345678901234567890");
        System.out.println(String.format("%10.2f%10.2f", 100000.999f, 200000.999f));
        System.out.print("\n");
    }

}
