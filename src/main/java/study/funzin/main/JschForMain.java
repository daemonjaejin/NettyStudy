package study.funzin.main;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by JE on 2016-11-10.
 */
public class JschForMain {

    private static Session session;

    public static void main(String[] arg) {
        try {




            // 객체 생성
            JSch jsch = new JSch();

            String user = "tango";
            String host = "112.217.161.178";
            int port = 10022;
            String privateKey = "D:\\data\\tango\\key\\id_rsa";

            jsch.addIdentity(privateKey, "tango1!");
//            jsch.addIdentity(privateKey, "tango1!".getBytes()); // 이것도 사용 가능
            System.out.println("identity added ");

            // 세션 객체를 생성한다.(사용자 이름, 접속할 호스트, 접속할 포트)
            session = jsch.getSession(user, host, port);

            // 패스워드 설정
//            session.setPassword("tango123$");
            System.out.println("session created.");

            // 세션과 관련된 정보를 설정한다.
            java.util.Properties config = new java.util.Properties();
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

            String fileName = "test.txt";

            boolean check = false;

            try {
                channelSftp.ls("test.txt");
                check = true;
            }catch (Exception e){
                e.getMessage();
            }

            System.out.println("check : " + check);

            StringBuilder sbs = new StringBuilder();
            sbs.append("test");

            InputStream iss = new ByteArrayInputStream(sbs.toString().getBytes("UTF-8"));

            int mode = ChannelSftp.OVERWRITE;

            if(check) mode = ChannelSftp.APPEND;

            channelSftp.put(iss, fileName, mode);

            System.out.println("done");

            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            sb.append("test2");
            sb.append("\n");
            sb.append("test3");
            sb.append("\n");

            InputStream is = new ByteArrayInputStream(sb.toString().getBytes("UTF-8"));

            for (int i=0; i<10000; i++){
                channelSftp.put(is, fileName, mode);
            }

//            in.close();

            channelSftp.quit();

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
