package study.funzin.main2;


import study.funzin.handler.TailerListenerAdapter;

/**
 * Created by JE on 2016-12-29.
 */
public class ShowLinesListener2 extends TailerListenerAdapter {

    @Override
    public void handle(String line, long position, String fileName, long lineNum, long lineNumber){
        System.out.println("lineNum : " + lineNum);
        System.out.println(line);
        System.out.println("position : " + position);
        if(fileName.equals("20170105-13") && position > 20){
//            System.out.println(line);
//            System.out.println(position);
//            System.out.println(fileName);
        }else{
//            System.out.println("line : " + line);
//            System.out.println("position : " + position);
//            System.out.println("fileName: " + fileName);
        }
    }

}
