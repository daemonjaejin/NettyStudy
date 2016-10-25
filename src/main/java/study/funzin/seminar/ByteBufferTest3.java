package study.funzin.seminar;

import org.junit.Assert;
import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * Created by JE on 2016-10-24.
 */
public class ByteBufferTest3 {

    @Test
    public void test(){

        ByteBuffer firstBuffer = ByteBuffer.allocate(11);
        // 11바이트를 저장할 수 있는 초기화된 바이트 버퍼의 position, limit, capacity 속성값을 출력한다.
        System.out.println("바이트 버퍼 초기값 : " + firstBuffer);

        // position 1증가
        firstBuffer.put((byte)1);
        // position 1증가
        firstBuffer.put((byte)2);
        Assert.assertEquals(2, firstBuffer.position());

        // rewind 메서드 호출
        firstBuffer.rewind();
        // 위에서 변경하여 position 속성이 0
        Assert.assertEquals(0, firstBuffer.position());

        // 바이트 버퍼에 저장된 첫 번째 값을 조회할 수 있게 되었다.
        Assert.assertEquals(1, firstBuffer.get());
        // position 1증가
        Assert.assertEquals(1, firstBuffer.position());

        System.out.println(firstBuffer);

    }

}
