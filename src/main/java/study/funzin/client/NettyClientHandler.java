package study.funzin.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by JE on 2017-01-23.
 */
public class NettyClientHandler extends ChannelHandlerAdapter{

    private final ByteBuf message;

    public NettyClientHandler(){
        message = Unpooled.buffer(NettyClient.MESSAGE_SIZE);
        byte []  str = "abcefg".getBytes();
        message.writeBytes(str);
    }

    // 채널이 활성화 되면 동작할 코드를 정의합니다.
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 메시지를 쓴 후 플러쉬합니다.
//        ctx.writeAndFlush(message);
//        ctx.writeAndFlush(ctx.flush());
    }

    @Override
    public void read(io.netty.channel.ChannelHandlerContext ctx) throws java.lang.Exception {
        System.out.println("read");
        ctx.flush();
    }

    @Override
    public void write(io.netty.channel.ChannelHandlerContext ctx, java.lang.Object msg, io.netty.channel.ChannelPromise promise) throws java.lang.Exception {
        System.out.println("msg : " + msg);
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)throws Exception {
        // 받은 메시지를 ByteBuf형으로 캐스팅합니다.
        ByteBuf byteBufMessage = (ByteBuf) msg;
        // 읽을 수 있는 바이트의 길이를 가져옵니다.
        int size = byteBufMessage.readableBytes();

        // 읽을 수 있는 바이트의 길이만큼 바이트 배열을 초기화합니다.
        byte [] byteMessage = new byte[size];
        // for문을 돌며 가져온 바이트 값을 연결합니다.
        for(int i = 0 ; i < size; i++){
            byteMessage[i] = byteBufMessage.getByte(i);
        }

        // 바이트를 String 형으로 변환합니다.
        String str = new String(byteMessage);

        // 결과를 콘솔에 출력합니다.
        System.out.println(str);

        // 그후 컨텍스트를 종료합니다.
//        ctx.close();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}