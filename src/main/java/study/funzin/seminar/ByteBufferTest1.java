package study.funzin.seminar;

import java.nio.ByteBuffer;

/**
 * Created by JE on 2016-10-24.
 */
public class ByteBufferTest1 {

    public static void main(String args[]){
        ByteBuffer firstBuffer = ByteBuffer.allocate(11);
        System.out.println("바이트 버퍼 초기값 : " + firstBuffer);
    }

}
