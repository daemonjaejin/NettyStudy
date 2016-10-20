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
public class DiscardServer {

    public static void main(String args[]){

        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {

            ServerBootstrap sb = new ServerBootstrap();
            sb.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        public void initChannel(SocketChannel sc){
                            ChannelPipeline cp = sc.pipeline();
                            //접속된 클라이언트로부터 수신된 데이터를 처리할 핸들러 지정
                            cp.addLast(new DiscardServerHandler());
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
