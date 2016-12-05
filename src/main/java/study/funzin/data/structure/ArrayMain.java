package study.funzin.data.structure;

/**
 * Created by jin on 16. 12. 4.
 */
public class ArrayMain {

    public static void main(String [] args){
        oneArray();
        twoArray();
        threeArray();
    }

    public static void oneArray(){
        int sale[] = new int[]{157, 209, 251, 312};
        for(int i=0; i< sale.length; i++){
            System.out.printf("%d/4분기 : sale[%d]= %d %n", i+1, i, sale[i]);
        }
    }


    public static void twoArray(){
        int sale[][] = new int[][]{{63, 84, 140, 130},{157, 209, 251, 312}};
        for (int i=0; i<2; i++){
            for(int j=0; j<4; j++){
                System.out.printf("%d/4분기 : sale[%d][%d]= %d %n", j+1, i, j, sale[i][j]);
            }
            System.out.println();
        }
    }

    public static void threeArray(){
        int sale[][][] = new int[][][]{{{63, 84, 140, 130},{157, 209, 251, 312}}, {{59, 80, 130, 135},{149, 187, 239, 310}}};
        for (int i=0; i<2; i++){
            System.out.printf("<< %d 팀 >> %n", i+1);
            for(int j=0; j<2; j++){
                for(int k=0; k<4; k++){
                    System.out.printf("%d/4분기 : sale[%d][%d][%d]= %d %n", j+1, i, j, k, sale[i][j][k]);
                }
                System.out.println("----------------------");
            }
            System.out.println();
        }
    }

}
