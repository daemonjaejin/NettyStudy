package study.funzin.seminar;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by JE on 2016-10-20.
 */
public class EchoClient {

    public static void main(String args[]){

        EventLoopGroup group = new NioEventLoopGroup();

        try{

            Bootstrap bs = new Bootstrap();

            // 서버 애플리케이션의 부트스트랩 설정과 다르게 이벤트 루프 그룹이 하나만 설정되었다.
            // 클라이언트 애플리케이션은 서버와 달리 서버에 연결된 채널 하나만 존재하기 때문에 이벤트 루프 그룹이 하나다.
            bs.group(group)

                    // 클라이언트 애플리케이션이 생성하는 채널의 종류를 설정, NIO 소켓 채널인 NioSocketChannel 클래스로 설정
                    // 즉 서버에 연결된 클라이언트의 소켓 채널은 NIO로 동작하게 된다.
                    .channel(NioSocketChannel.class)

                    // 클라이언트 애플리케이션이므로 채널 파이프라인의 설정에 일반 소켓 채널 클래스인 SocketChannel을 설정
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel sc){
                            ChannelPipeline cp = sc.pipeline();
                            cp.addLast(new EchoClientHandler());
                        }
                    });

            // 비동기 입출력 메서드인 connect를 호출
            // 메서드의 호출 결과로 ChannelFuture 객체를 돌려주는데 이 객체를 통해서 비동기 메서드의 처리 결과를 확인할 수 있다.
            // ChannelFuture 객체의 sync 메서드는 ChannelFuture 객체의 요청이 완료될 때까지 대기한다.
            // 단, 요청이 실패하면 예외를 던진다.
            // 즉, connect 메서드의 처리가 완료될 때까지 다음 라인으로 진행하지 않는다.
            ChannelFuture cf = bs.connect("127.0.0.1", 8888).sync();

            cf.channel().closeFuture().sync();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            group.shutdownGracefully();
        }

    }

}
