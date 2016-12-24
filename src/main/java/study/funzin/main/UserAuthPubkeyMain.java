package study.funzin.main;

import com.jcraft.jsch.*;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Vector;

/**
 * Created by JE on 2016-11-10.
 */
public class UserAuthPubkeyMain {

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

//            String fileFullName = "D:\\data\\tango\\key\\log\\gemsapi.log.2016-08-01_17.1.log";
            String fileFullName = "D:\\data\\tango\\key\\test.txt";
            String fileName = "test.txt";

//            FileInputStream in = new FileInputStream(fileFullName);
//            channelShell.setInputStream(in);
//            channelExec.setCommand("명령어.sh");

//            try {
//                System.out.println("Directory Path Move1");
//                channelSftp.cd("/home/tango/20161114");
//            }catch (SftpException SE){
//                System.out.println("Directory Create");
//                channelSftp.mkdir("/home/tango/20161114");
//
//                System.out.println("Directory Path Move2");
//                channelSftp.cd("/home/tango/20161114");
//            }

//            System.out.println("Directory Create");
//            channelSftp.mkdir("/home/tango/20161110");
//
//            System.out.println("Directory Path Move2");
//            channelSftp.cd("/home/tango/20161110");

//            boolean check = false;
//
//            ChannelSftp.LsEntrySelector lsSelector = new ChannelSftp.LsEntrySelector(){
//                public int select(ChannelSftp.LsEntry entry){
////                    entry.getFilename();
//                    return CONTINUE;
//                }
//            };

//            Vector<ChannelSftp.LsEntry> v = channelSftp.ls("test.txt");
//
//            for (ChannelSftp.LsEntry entry : v){
//                System.out.println(entry.getFilename());
//            }

//            channelSftp.ls(".", new ChannelSftp.LsEntrySelector() {
//                public int select(ChannelSftp.LsEntry le) {
////                    System.out.println(le);
//                    if (le.getFilename().equals("test.txt")) {
//
//                    }
//                    return ChannelSftp.LsEntrySelector.CONTINUE;
//                }
//            });

//            if(channelSftp.ls(fileName).size() > 0){
//                System.out.println("file Y");
//            }else{
//                System.out.println("file N");
//            }

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

            int modes = ChannelSftp.OVERWRITE;

            channelSftp.put(iss, fileName, modes);

//            channelSftp.put(in, fileName);

            System.out.println("done");

            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            sb.append("test2");
            sb.append("\n");
            sb.append("test3");
            sb.append("\n");

            InputStream is = new ByteArrayInputStream(sb.toString().getBytes("UTF-8"));

            int mode = ChannelSftp.APPEND;

            channelSftp.put(is, fileName, mode);

//            in.close();

            channelSftp.quit();

            System.out.println("quit");

            session.disconnect();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.err.println(e);
            session.disconnect();
        } finally {
            session.disconnect();
        }
    }

}
