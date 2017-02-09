package study.funzin.main5;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.util.Properties;
import java.util.Vector;

/**
 * Created by JE on 2016-11-10.
 */
public class JschMain2 {

    private static Session session;

    public static void main(String[] arg) {
        try {

            // 객체 생성
            JSch jsch = new JSch();

            String user = "tango";
            String host = "192.3.21.162";
            int port = 22;
            String privateKey = "D:\\data\\tango\\key\\id_rsa";

            jsch.addIdentity(privateKey);
//            jsch.addIdentity(privateKey, "tango1!".getBytes()); // 이것도 사용 가능
            System.out.println("identity added ");

            // 세션 객체를 생성한다.(사용자 이름, 접속할 호스트, 접속할 포트)
            session = jsch.getSession(user, host, port);

            // 패스워드 설정
//            session.setPassword("tango123$");
            System.out.println("session created.");

            // 세션과 관련된 정보를 설정한다.
            Properties config = new Properties();
            // 호스트 정보를 검사하지 않는다.
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            // 접속한다.
            session.connect();
            System.out.println("session connected.....");

            // sftp 채널을 연다.
            Channel channel = session.openChannel("sftp");
            channel.setInputStream(System.in);
            channel.setOutputStream(System.out);
            channel.connect();
            System.out.println("shell channel connected....");

            // 채널을 FTP용 채널 객체로 캐스팅한다.
            ChannelSftp channelSftp = (ChannelSftp) channel;

//            ChannelExec channelExec = (ChannelExec) channel;

            try {

                Vector vector = channelSftp.ls("/home/tango/PM/NOTI");
                for (int i = 0; i < vector.size(); i++) {
                    System.out.println(i + " : " + vector.get(i));
                }

            }catch (Exception e){
                e.getMessage();
            }



            channelSftp.disconnect();

            channelSftp.quit();

//            channelExec.disconnect();

//                System.out.println("quit");

            session.disconnect();



        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.err.println(e);
//            session.disconnect();
        } finally {
//            session.disconnect();
        }
    }

}
