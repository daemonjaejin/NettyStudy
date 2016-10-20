package study.funzin.seminar;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by JE on 2016-10-20.
 */
// 상속 받아서 재정의
public class DiscardServerHandler extends SimpleChannelInboundHandler<Object>{

    @Override
    public void messageReceived(ChannelHandlerContext channelHandlerContext, Object msg){

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        // Discard 서버에서 지정한 포트로 접속한 클라이언트가 데이터를 전송하면 자동으로 실행됨
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }

}
