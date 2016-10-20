package study.funzin.seminar;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

/**
 * Created by JE on 2016-10-20.
 */
public class EchoClientHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    public void messageReceived(ChannelHandlerContext channelHandlerContext, Object msg){

    }

    @Override
    // 소켓 채널이 최초 활성화 되었을 때 실행된다.
    public void channelActive(ChannelHandlerContext ctx){
        String sendMessage = "Hello, Netty!";

        ByteBuf messageBuffer = Unpooled.buffer();
        messageBuffer.writeBytes(sendMessage.getBytes());

        StringBuilder builder = new StringBuilder();
        builder.append("전송할 문자열 [");
        builder.append(sendMessage);
        builder.append("]");

        System.out.println(builder.toString());

        // 내부적으로 데이터 기록과 전송의 두 가지 메서드를 호출한다.
        // 첫 번째는 채널에 데이터를 기록하는 write 메서드
        // 두 번째는 채널에 기록된 데이터를 서버로 전송하는 flush 메서드
        ctx.writeAndFlush(messageBuffer);
    }

    @Override
    // 데이터 수신 이벤트 처리 메서드, 클라이언트로부터 데이터의 수신이 이루어졌을 때 네티가 자동으로 호출하는 이벤트 메서드
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        // Discard 서버에서 지정한 포트로 접속한 클라이언트가 데이터를 전송하면 자동으로 실행됨

        // 수신된 데이터를 가지고 있는 네티의 바이트 버퍼 객체로부터 문자열 데이터를 읽어온다.
        // java jvm default charset
        String readMessage = ((ByteBuf)msg).toString(Charset.defaultCharset());

        // 콘솔 출력
        StringBuilder builder = new StringBuilder();
        builder.append("수신한 문자열 [");
        builder.append(readMessage);
        builder.append("]");

        System.out.println(builder.toString());

    }

    @Override
    // 수신된 데이터를 모두 읽었을 떄 호출되는 이벤트 메서드
    // ChannelRead 메서드의 수행이 완료되고 나서 호출
    public void channelReadComplete(ChannelHandlerContext ctx){
        // 수산된 데이터를 모두 읽은 후 서버와 연결된 채널을 닫는다.
        // 이후 데이터 송수신 채널은 닫히게 되고 클라이언트 프로그램은 종료된다.
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }

}
