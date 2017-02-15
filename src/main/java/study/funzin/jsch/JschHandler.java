package study.funzin.jsch;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.util.Properties;
import java.util.Vector;

/**
 * Created by JE on 2017-02-14.
 */
public class JschHandler {

    public static Session session;

    public static Channel channel;

    public static ChannelSftp channelSftp1;

    public static ChannelSftp channelSftp2;

    public static ChannelSftp channelSftp3;

    private String user = "tango";
    private String host = "112.217.161.178";
    private Integer port = 10022;
    private String privateKey = "D:\\data\\tango\\key\\id_rsa";
    private String path = "/home/tango/lee/test";


    public static void main(String [] args){
        JschHandler handler = new JschHandler();
        System.out.println("test1");
        handler.jschConnect();
        System.out.println("test2");
        handler.selectConnect(1);
        System.out.println("test3");
        handler.behavior(1);
        handler.jschDisConnect();
        System.out.println("test4");
        handler.jschConnect();
        handler.selectConnect(2);
        handler.behavior(2);
        handler.jschDisConnect();
        System.out.println("test5");
    }

    public void selectConnect(Integer number){
        try {
            switch (number){
                case 1 :
                    System.out.println("selectConnect1-1");
                    channelSftp1 = (ChannelSftp) channel;
                    break;
                case 2 :
                    System.out.println("selectConnect1-2");
                    channelSftp2 = (ChannelSftp) channel;
                    break;
                case 3 :
                    System.out.println("selectConnect1-3");
                    channelSftp3 = (ChannelSftp) channel;
                    break;
                default:
            }
            System.out.println("selectConnect2");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void jschConnect(){

        System.out.println("jschConnect1");

        JSch jsch = new JSch();
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");

        System.out.println("jschConnect2");

        try {

            System.out.println("jschConnect3");

            jsch.addIdentity(privateKey);
            session = jsch.getSession(user, host, port);
            session.setConfig(config);
            session.connect();

            System.out.println("jschConnect4");

            channel = session.openChannel("sftp");
            channel.setInputStream(System.in);
            channel.setOutputStream(System.out);
            channel.connect();

            System.out.println("jschConnect5");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void jschDisConnect(){
        try {
            System.out.println("jschDisConnect1");
            if(channelSftp1!=null && channelSftp1.isConnected()){
                channelSftp1.disconnect();
            }
            if(channelSftp2!=null && channelSftp2.isConnected()){
                channelSftp2.disconnect();
            }
            if(channelSftp3!=null && channelSftp3.isConnected()){
                channelSftp3.disconnect();
            }
//            System.out.println("jschDisConnect2");
//            if(channel!=null && channel.isConnected()){
//                channel.disconnect();
//            }
            System.out.println("jschDisConnect3");
            if(session!=null && session.isConnected()) {
                session.disconnect();
            }
            System.out.println("jschDisConnect4");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("jschDisConnect5");
    }

    public void behavior(Integer number){
        System.out.println("behavior1");
        try {
            switch (number){
                case 1 :
                    Vector<ChannelSftp.LsEntry> list = channelSftp1.ls(path);
                    for (ChannelSftp.LsEntry entry : list){
                        System.out.println("fileName1 : " + entry.getFilename());
                    }
                    break;
                case 2 :
                    Vector<ChannelSftp.LsEntry> list2 = channelSftp2.ls(path);
                    for (ChannelSftp.LsEntry entry : list2){
                        System.out.println("fileName2 : " + entry.getFilename());
                    }
                    break;
                case 3 :
                    Vector<ChannelSftp.LsEntry> list3 = channelSftp3.ls(path);
                    for (ChannelSftp.LsEntry entry : list3){
                        System.out.println("fileName3 : " + entry.getFilename());
                    }
                    break;
                default:

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("behavior2");
    }



}
