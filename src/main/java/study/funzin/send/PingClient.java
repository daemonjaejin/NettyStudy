package study.funzin.send;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by JE on 2017-01-19.
 */
public class PingClient {

    public static void main(String args[]){
        try {
            SocketAddress socketAddress = new InetSocketAddress("112.217.161.178", 10022);
//            Socket s = null;
            Socket socket = null;
            while (true){
                try {
                    socket = new Socket();
//                    socket.setSoTimeout(100);
                    socket.connect(socketAddress, 1000);

//                    s = new Socket ("219.240.99.75", 10022);
//                    s = new Socket ("112.217.161.178", 10022);
//                    s.setSoTimeout(1000);
                    boolean result = socket.isConnected();
                    if(result) System.out.println("서버에 연결됨");
                    else System.out.println("서버에 연결실패");
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("서버 연결 실패!!!");
                }finally {
                    if(socket!=null){
                        System.out.println("서버 is not null");
                        socket.close();
                    }
                }
                Thread.sleep(2000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
