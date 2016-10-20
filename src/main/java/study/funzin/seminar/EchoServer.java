package study.funzin.seminar;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.oio.OioServerSocketChannel;

/**
 * Created by JE on 2016-10-20.
 */
public class EchoServer {

    public static void main(String args[]){

        // 단일 스레드
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        // 블로킹 모드
//        EventLoopGroup bossGroup = new OioEventLoopGroup(1);
        // 하드웨어 코어 수 * 2, 멀티 스레드
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        // 블로킹 모드
//        EventLoopGroup workerGroup = new OioEventLoopGroup();

        try {

            // ServerBootstrap 생성
            ServerBootstrap sb = new ServerBootstrap();

            // ServerBootstrap 에 bossGroup, workerGroup 에서 생성한 NioEventLoopGroup 객체를 인수로 입력한다.
            // 첫 번째 인수는 부모 스레드다. 부모 스레드는 클라이언트 연결 요청의 수락을 담당한다.
            // 두 번째 인수는 연결된 소켓에 대한 I/O 처리를 담당하는 자식 스레드다.
            sb.group(bossGroup, workerGroup)

                    // 서버 소켓(부모 스레드)이 사용할 네트워크 입출력 모드를 설정한다. 여기서는 NioServerSocketChannel 클래스를 설정했기 때문에 NIO 모드로 동작한다.
                    .channel(NioServerSocketChannel.class)
                    // 블로킹 모드
//                    .channel(OioServerSocketChannel.class)

                    // 자식 채널의 초기화 방법을 설정한다. 여기서는 익명 클래스로 채널 초기화 방법을 지정했다.
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        // ChannelInitializer 는 클라이언트로부터 연결된 채널이 초기화될 떄의 기본 동작이 지정된 추상 클래스다.
                        public void initChannel(SocketChannel sc) {
                            // 채널 파이프라인 객체를 생성한다.
                            ChannelPipeline cp = sc.pipeline();
                            // 접속된 클라이언트로부터 수신된 데이터를 처리할 핸들러 지정
                            // 채널 파이프라인에 EchoServerHandler 클래스를 등록한다.
                            // EchoServerHandler 클래스는 이후에 클라이언트의 연결이 생성되었을 때 데이터 처리를 담당한다.
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
