package study.funzin.send;

import java.net.Socket;

/**
 * Created by JE on 2017-01-19.
 */
public class PingClient {

    public static void main(String args[]){
        try {
            Socket s = null;
            while (true){
                try {
                    s = new Socket ("219.240.99.75", 10022);
                    boolean result = s.isConnected();
                    if(result) System.out.println("서버에 연결됨");
                    else System.out.println("서버에 연결실패");
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("서버 연결 실패!!!");
                }finally {
                    if(s!=null){
                        System.out.println("서버 is not null");
                        s.close();
                    }
                }
                Thread.sleep(2000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
