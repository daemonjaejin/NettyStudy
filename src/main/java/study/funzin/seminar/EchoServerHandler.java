package study.funzin.seminar;

import com.sun.org.apache.xerces.internal.impl.io.UTF8Reader;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;

import java.nio.charset.Charset;

/**
 * Created by JE on 2016-10-20.
 */
// 상속 받아서 재정의
public class EchoServerHandler extends SimpleChannelInboundHandler<Object>{

    private static final byte[] CONTENT = {'H', 'E', 'L', 'L', 'O'};

    @Override
    public void messageReceived(ChannelHandlerContext channelHandlerContext, Object msg){

    }

    @Override
    // 데이터 수신 이벤트 처리 메서드, 클라이언트로부터 데이터의 수신이 이루어졌을 때 네티가 자동으로 호출하는 이벤트 메서드
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        // Discard 서버에서 지정한 포트로 접속한 클라이언트가 데이터를 전송하면 자동으로 실행됨

        //수신한 객체가 HttpRequest 일 때, HttpResponse 객체를 생성하고 헤더와 메세지를 저장한다.
        if(msg instanceof HttpRequest){
            HttpRequest req = (HttpRequest) msg;
            System.out.println(req.getUri());
            if(HttpHeaders.is100ContinueExpected(req)){
                ctx.write(new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.CONTINUE));
            }
            boolean keepAlive = HttpHeaders.isKeepAlive(req);
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer(CONTENT));
            if(keepAlive){
                ctx.write(response).addListener(ChannelFutureListener.CLOSE);
            }
        }

        // 수신된 데이터를 가지고 있는 네티의 바이트 버퍼 객체로부터 문자열 데이터를 읽어온다.
        // java jvm default charset
        // 인수인 msg 객체에 수신된 데이터가 담겨 있으며 ByteBuf 인터페이스로 변환했다.
        // 네티 내부에서는 모든 데이터가 ByteBuf로 관리된다.
        String readMessage = ((ByteBuf)msg).toString(Charset.defaultCharset());

        // 콘솔 출력
        System.out.println("수신한 문자열 [" + readMessage + ']');

        // ChannelHandlerContext는 인터페이스 객체로서 채널 파이프라인에 대한 이벤트를 처리한다.
        // 서버에 연결된 클라이언트 채널로 입력받은 데이터를 그래도 전송한다.
        ctx.write(msg);

        // 채널에 파이프라인에 channelRead 이벤트를 발생시킨다.
//        ctx.fireChannelRead(msg);

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx){
        // ChannelRead 이벤트의 처리가 완료된 후 자동으로 수행되는 이벤트 메서드로서 채널 파이프라인에 저장된 버퍼를 전송하는 flush 메서드를 호출한다.
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }

}
