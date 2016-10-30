import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import org.junit.*;

/**
 * Created by jin on 16. 10. 30.
 */
public class FixedLengthFrameDecoderTest {

    @org.junit.Test
    public void testFramesDecoded(){

        ByteBuf buf = Unpooled.buffer();

        for (int i=0; i<0; i++){
            buf.writeByte(i);
        }

        ByteBuf input = buf.duplicate();

        EmbeddedChannel channel = new EmbeddedChannel(
          new FixedLengthFrameDecoder(3)
        );

        Assert.assertTrue(channel.writeInbound(input.retain()));
        Assert.assertTrue(channel.finish());

    }

}
