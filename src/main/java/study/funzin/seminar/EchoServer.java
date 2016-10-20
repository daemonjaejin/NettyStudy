package study.funzin.seminar;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by JE on 2016-10-20.
 */
public class EchoServer {

    public static void main(String args[]){

        // 단일 스레드
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        // 하드웨어 코어 수 * 2, 멀티 스레드
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {

            // ServerBootstrap 생성
            ServerBootstrap sb = new ServerBootstrap();

            // ServerBootstrap 에 bossGroup, workerGroup 에서 생성한 NioEventLoopGroup 객체를 인수로 입력한다.
            // 첫 번째 인수는 부모 스레드다. 부모 스레드는 클라이언트 연결 요청의 수락을 담당한다.
            // 두 번째 인수는 연결된 소켓에 대한 I/O 처리를 담당하는 자식 스레드다.
            sb.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        public void initChannel(SocketChannel sc){
                            ChannelPipeline cp = sc.pipeline();
                            //접속된 클라이언트로부터 수신된 데이터를 처리할 핸들러 지정
                            cp.addLast(new EchoServerHandler());
                        }

                    })
            ;

            //부트스트랩 클래스의 bind 메서드로 접속할 포트 지정
            ChannelFuture cf = sb.bind(8888).sync();

            cf.channel().closeFuture().sync();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }

    }

}
