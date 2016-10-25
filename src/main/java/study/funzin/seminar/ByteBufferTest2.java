package study.funzin.seminar;

import java.nio.ByteBuffer;

/**
 * Created by JE on 2016-10-24.
 */
public class ByteBufferTest2 {

    public static void main(String args[]){

        ByteBuffer firstBuffer = ByteBuffer.allocate(11);
        // 11바이트를 저장할 수 있는 초기화된 바이트 버퍼의 position, limit, capacity 속성값을 출력한다.
        System.out.println("바이트 버퍼 초기값 : " + firstBuffer);

        // 바이트 버퍼 객체는 데이터 저장을 위한 put 메서드에 자바의 기본형 데이터만을 입력할 수 있다.
        // 바이트 버퍼에 저장할 "Hello world" 문자열 데이터를 바이트 배열로 변환한다.
        byte[] source = "Hello world!".getBytes();

        // 바이트 버퍼에 입력할 데이터인 "Hello world!" 데이터의 바이트 길이만큼 반복 수행한다.
        for (byte item : source){
            // ByteBuffer 클래스의 put(byte b) 메서드는 바이트 버퍼에 한 바이트를 기록하고 position 의 위치를 1 증가시킨다.
            firstBuffer.put(item);
            System.out.println("현재 상태 : " + firstBuffer);
        }

    }

}
