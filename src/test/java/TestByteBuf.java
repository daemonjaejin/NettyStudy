import org.junit.Assert;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;

/**
 * Created by JE on 2016-10-24.
 */
public class TestByteBuf {

    @Test
    public void createTest(){

        // 11개의 char 형 데이터를 저장할 수 있는 힙 버퍼를 생성한다.
        CharBuffer heapBuffer = CharBuffer.allocate(11);
        // heapBuffer 의 capacity 속성이 11인지 검사한다.
        Assert.assertEquals(11, heapBuffer.capacity());
        // heapBuffer 가 다이렉트 버퍼인지 검사한다.
        // isDirect 메서드는 주어진 버퍼가 allocateDirect 메서드를 사용하여 생성되었는지 검사한다.
        Assert.assertEquals(false, heapBuffer.isDirect());

        // 11개의 byte 형 데이터를 저장할 수 있는 다이렉트 버퍼를 생성한다.
        ByteBuffer directBuffer = ByteBuffer.allocateDirect(11);
        Assert.assertEquals(11, directBuffer.capacity());
        Assert.assertEquals(true, directBuffer.isDirect());

        // 11개의 데이터가 저장된 int 형 배열을 생성한다.
        int [] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0};
        // 위에서 생성한 array 배열을 감싸는 int 형 버퍼를 생성한다.
        // 이때 생성된 버퍼는 JVM 의 힙 영역에 생성된다.
        IntBuffer intHeapBuffer = IntBuffer.wrap(array);
        Assert.assertEquals(11, intHeapBuffer.capacity());
        Assert.assertEquals(false, intHeapBuffer.isDirect());

    }

}
