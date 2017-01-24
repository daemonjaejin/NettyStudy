package study.funzin.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;

/**
 * Created by JE on 2017-01-23.
 */
public class NettyServerHandler extends ChannelHandlerAdapter{

    @Override
    public void channelRead(io.netty.channel.ChannelHandlerContext ctx, java.lang.Object msg) throws java.lang.Exception {
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
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(io.netty.channel.ChannelHandlerContext ctx) throws java.lang.Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(io.netty.channel.ChannelHandlerContext ctx, java.lang.Throwable cause) throws java.lang.Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
