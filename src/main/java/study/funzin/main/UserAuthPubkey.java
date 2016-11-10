package study.funzin.main;

import com.jcraft.jsch.*;

import java.io.FileInputStream;

/**
 * Created by JE on 2016-11-10.
 */
public class UserAuthPubkey {

    public static void main(String[] arg) {
        try {

            // 객체 생성
            JSch jsch = new JSch();

            String user = "tango";
            String host = "112.217.161.178";
            int port = 10022;
            String privateKey = "D:\\tango\\key\\id_rsa";

            jsch.addIdentity(privateKey, "tango1!");
//            jsch.addIdentity(privateKey, "tango1!".getBytes()); // 이것도 사용 가능
            System.out.println("identity added ");

            // 세션 객체를 생성한다.(사용자 이름, 접속할 호스트, 접속할 포트)
            Session session = jsch.getSession(user, host, port);

            // 패스워드 설정
//            session.setPassword("tango123$");
            System.out.println("session created.");

            // 세션과 관련된 정보를 설정한다.
            java.util.Properties config = new java.util.Properties();
            // 호스트 정보를 검사하지 않는다.
            config.put("StrictHostKeyChecking", "no");
//            config.put("StrictHostKeyChecking", "yes");
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

            // 채널을 Shell용 채널 객체로 캐스팅한다.
//            ChannelShell channelShell = (ChannelShell) channel;

            // 채널을 SSH용 채널 객체로 캐스팅한다.
//            ChannelExec channelExec = (ChannelExec) channel;

            // 채널을 DirectTCPIP용 채널 객체로 캐스팅한다.
//            ChannelDirectTCPIP channelDirectTCPIP = (ChannelDirectTCPIP)channel;

            // 채널을 ChannelForwardedTCPIP용 채널 객체로 캐스팅한다.
//            ChannelForwardedTCPIP channelForwardedTCPIP = (ChannelForwardedTCPIP)channel;

            String fileFullName = "D:\\tango\\key\\test.txt";
            String fileName = "test.txt";

            FileInputStream in = new FileInputStream(fileFullName);
//            channelShell.setInputStream(in);
//            channelExec.setCommand("명령어.sh");

            try {
                System.out.println("Directory Path Move1");
                channelSftp.cd("/home/tango/20161110");
            }catch (SftpException SE){
                System.out.println("Directory Create");
                channelSftp.mkdir("/home/tango/20161110");

                System.out.println("Directory Path Move2");
                channelSftp.cd("/home/tango/20161110");
            }

//            System.out.println("Directory Create");
//            channelSftp.mkdir("/home/tango/20161110");
//
//            System.out.println("Directory Path Move2");
//            channelSftp.cd("/home/tango/20161110");


            channelSftp.put(in, fileName);

            channelSftp.exit();
            System.out.println("done");

            in.close();

            channelSftp.quit();

            System.out.println("quit");

            session.disconnect();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
