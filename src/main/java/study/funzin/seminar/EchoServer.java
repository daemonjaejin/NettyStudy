package study.funzin.seminar;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.oio.OioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

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

                    // 채널에서 발생하는 모든 이벤트를 로그로 출력해준다.
                    // 인수는 출력할 로그의 레벨을 지정한다.
                    .handler(new LoggingHandler(LogLevel.INFO))

                    // 자식 채널의 초기화 방법을 설정한다. 여기서는 익명 클래스로 채널 초기화 방법을 지정했다.
                    // childHandler 메서드를 통해서 연결된 클라이언트 소켓 채널이 사용할 채널 파이프라인을 설정한다.
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        // ChannelInitializer 는 클라이언트로부터 연결된 채널이 초기화될 떄의 기본 동작이 지정된 추상 클래스다.
                        // 클라이언트 소켓 채널이 생성될 때 자동으로 호출되는데 이때 채널 파이프라인의 설정을 수행한다.
                        public void initChannel(SocketChannel sc) {
                            // 채널 파이프라인 객체를 생성한다.
                            // initChannel 메서드의 인자로 입력된 소켓 채널(즉, 연결된 클라이언트 소켓 채널)에 설정된 채널 파이프라인을 가져오게 되는데,
                            // 네티의 내부에서는 클라이언트 소켓 채널을 생서할 때 빈 채널 파이프라인 객체를 생성하여 할당한다.
                            ChannelPipeline cp = sc.pipeline();
                            // 클라이언트 소켓 채널의 파이프라인에 등록
                            // 서버 소켓채널로 연결된 클라이언트 채널에 파이프라인을 설정하는 역할을 수행
                            cp.addLast(new LoggingHandler(LogLevel.INFO));
                            // 네티가 제공하는 HTTP 서버 코덱이다.
                            // 인바운드와 아웃바운드 핸들러를 모두 구현한다.
//                            cp.addLast(new HttpServerCodec());
                            // 접속된 클라이언트로부터 수신된 데이터를 처리할 핸들러 지정
                            // 채널 파이프라인에 EchoServerHandler 클래스를 등록한다.
                            // EchoServerHandler 클래스는 이후에 클라이언트의 연결이 생성되었을 때 데이터 처리를 담당한다.
                            // 이벤트 핸들러인 EchoServerHandler 를 채널 파이프라인에 등록하려면 채널 파이프라인의 addLast 메서드를 사용한다.
                            cp.addLast(new EchoServerHandler());
                            // 두 번째 핸들러
//                            cp.addLast(new EchoServerHandler2());
                        }

                    })

                    // 동시에 수용할 클라이언트의 연결 요청 수
//                    .option(ChannelOption.SO_BACKLOG, 1)
                    // 커널 버퍼에 남은 데이터를 상대방 소켓 채널로 모두 전송하고 즉시 연결을 끊는다.
//                    .childOption(ChannelOption.SO_LINGER, 0)
            ;

            // 부트스트랩 클래스의 bind 메서드로 접속할 포트 지정
            ChannelFuture cf = sb.bind(8888).sync();

            cf.channel().closeFuture().sync();

            // 위 부분을 풀어서 작성한 것이다.
            // 에코서버가 8888번 포트를 사용하도록 비동기 bind 메서드를 호출한다.
            // 부트스트랩 클래스의 bind 메서드는 포트 바인딩이 완료되기 전에 ChannelFuture 객체를 돌려준다.
            ChannelFuture bindFuture = sb.bind(8888);
            // ChannelFuture 인터페이스의 sync 메서드는 주어진 ChannelFuture 객체의 작업이 완료될 때까지 블롴킹하는 메서드다.
            // bind 메서드의 처리가 완료될 때 sync 메서드도 같이 완료된다.
            bindFuture.sync();
            // bindFuture 객체를 통해서 채널을 얻어온다. 여기서 얻어진 채널은 8888번 포트에 바인딩된 서버 채널이다.
            Channel serverChannel = bindFuture.channel();
            // 바인드가 완료된 서버 채널의 CloseFuture 객체를 돌려준다.
            // 네티 내부에서는 채널이 생성될 때 CloseFuture 객체도 같이 생성되므로 closeFuture 메서드가 돌려주는 CloseFuture 객체는 항상 동일한 객체다.
            ChannelFuture closeFuture = serverChannel.closeFuture();
            // CloseFuture 객체는 채널의 연결이 종료될 때 연결 종료 이벤트를 받는다.
            // 채널이 생성될 때 같이 생성되는 기본 CloseFuture 객체에는 아무 동작도 설정되어 있지 않으므로 이벤트를 받았을 때 아무 동작도 하지 않는다.
            closeFuture.sync();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }

    }

}
