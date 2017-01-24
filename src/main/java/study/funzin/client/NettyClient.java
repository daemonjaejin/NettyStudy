package study.funzin.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by JE on 2017-01-23.
 */
public class NettyClient {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 13000;
    public static final int MESSAGE_SIZE = 256;

    public static void main(String args[]){

        if(args.length > 0){
            for (int i = 0; i < args.length; i++) {
                System.out.println("입력받은 문자 : " + args[i]);
            }
        }

        NettyClient nettyClient = new NettyClient();
        nettyClient.connect(HOST, PORT);
    }

    public void connect(String host, int port){

        EventLoopGroup group = new NioEventLoopGroup();

        try {

            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel sc) throws Exception{
                            ChannelPipeline cp = sc.pipeline();
                            cp.addLast(new NettyClientHandler());
                        }
                    });

            ChannelFuture cf = b.connect(host, port).sync();
            cf.channel().closeFuture().sync();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            group.shutdownGracefully();
        }

    }

}
