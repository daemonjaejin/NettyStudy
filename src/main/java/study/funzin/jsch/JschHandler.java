package study.funzin.jsch;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.Vector;

/**
 * Created by JE on 2017-02-14.
 */
public class JschHandler {

    public static Session session;

    public static Channel channel1;

    public static Channel channel2;

    public static Channel channel3;

    public static ChannelSftp channelSftp1;

    public static ChannelSftp channelSftp2;

    public static ChannelSftp channelSftp3;

    public static String privateKey = "D:\\data\\tango\\key\\id_rsa";
    public static String user = "tango";
    public static String host = "112.217.161.178";
    public static Integer port = 10022;
    public static String path = "/home/tango/lee/test";


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
//        handler.jschConnect();
//        handler.selectConnect(2);
//        handler.behavior(2);
//        handler.jschDisConnect();
//        System.out.println("test5");
    }

    public static void selectConnect(Integer number){
        try {
            switch (number){
                case 1 :
                    System.out.println("selectConnect1-1");
                    channelSftp1 = (ChannelSftp) channel1;
                    break;
                case 2 :
                    System.out.println("selectConnect1-2");
                    channelSftp2 = (ChannelSftp) channel2;
                    break;
                case 3 :
                    System.out.println("selectConnect1-3");
                    channelSftp3 = (ChannelSftp) channel3;
                    break;
                default:
            }
            System.out.println("selectConnect2");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void jschConnect(){

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

            channel1 = session.openChannel("sftp");
            channel1.setInputStream(System.in);
            channel1.setOutputStream(System.out);
            channel1.connect();

            channel2 = session.openChannel("sftp");
            channel2.setInputStream(System.in);
            channel2.setOutputStream(System.out);
            channel2.connect();

            channel3 = session.openChannel("sftp");
            channel3.setInputStream(System.in);
            channel3.setOutputStream(System.out);
            channel3.connect();

            System.out.println("jschConnect5");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void jschDisConnect(){
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
            System.out.println("jschDisConnect2");
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

    public static void behavior(Integer number){
        System.out.println("behavior1");
        try {
            switch (number){
                case 1 :
//                    Vector<ChannelSftp.LsEntry> list = channelSftp1.ls(path);
//                    for (ChannelSftp.LsEntry entry : list){
//                        System.out.println("fileName1 : " + entry.getFilename());
//                    }
                    System.out.println("behavior1-1");
                    try {
                        channelSftp1.cd(path);
                        Vector<ChannelSftp.LsEntry> list1 = channelSftp1.ls(path);
                        System.out.println("list1 : " + list1.size());
                        if(list1.size() > 0){

//                            channelSftp1.put(new ByteArrayInputStream("".getBytes()), "test5");

                            String test1 = "test1";
                            StringBuilder sb = new StringBuilder();
                            sb.append("test1");
                            sb.append("\n");
                            InputStream is = new ByteArrayInputStream(sb.toString().getBytes("UTF-8"));
                            Vector<ChannelSftp.LsEntry> file1 = null;
                            try {
                                file1 = channelSftp1.ls(path+"/"+test1);
                            }catch (Exception e){
                                System.out.println(e.getMessage());
                                channelSftp1.put(new ByteArrayInputStream("".getBytes("UTF-8")), test1);
                            }
                            if(file1.size() > 0){
                                for (int i = 0; i < file1.size(); i++) {
                                    System.out.println("fileName : " + file1.get(i).getFilename());
                                }
                                System.out.println("file1 : " + file1.size());
                                channelSftp1.put(is, test1, ChannelSftp.APPEND);
                                System.out.println("behavior1-1-1");
                            }
                            is.close();
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2 :
//                    Vector<ChannelSftp.LsEntry> list2 = channelSftp2.ls(path);
//                    for (ChannelSftp.LsEntry entry : list2){
//                        System.out.println("fileName2 : " + entry.getFilename());
//                    }
                    System.out.println("behavior1-2");
                    try {
                        channelSftp2.cd(path);
                        Vector<ChannelSftp.LsEntry> list2 = channelSftp2.ls(path);
                        System.out.println("list2 : " + list2.size());
                        if(list2.size() > 0){
                            String test2 = "test2";
                            StringBuilder sb = new StringBuilder();
                            sb.append("test2");
                            sb.append("\n");
                            InputStream is = new ByteArrayInputStream(sb.toString().getBytes("UTF-8"));
                            Vector<ChannelSftp.LsEntry> file2 = null;
                            try {
                                file2 = channelSftp2.ls(path+"/"+test2);
                            }catch (Exception e){
                                System.out.println(e.getMessage());
                                channelSftp2.put(new ByteArrayInputStream("".getBytes("UTF-8")), test2);
                            }
                            if(file2.size() > 0){
                                System.out.println("file2 : " + file2.size());
                                channelSftp2.put(is, test2, ChannelSftp.APPEND);
                            }
                            is.close();
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3 :
//                    Vector<ChannelSftp.LsEntry> list3 = channelSftp3.ls(path);
//                    for (ChannelSftp.LsEntry entry : list3){
//                        System.out.println("fileName3 : " + entry.getFilename());
//                    }
                    System.out.println("behavior1-3");
                    try {
                        channelSftp3.cd(path);
                        Vector<ChannelSftp.LsEntry> list3 = channelSftp3.ls(path);
                        System.out.println("list3 : " + list3.size());
                        if(list3.size() > 0){
                            String test3 = "test3";
                            StringBuilder sb = new StringBuilder();
                            sb.append("test3");
                            sb.append("\n");
                            InputStream is = new ByteArrayInputStream(sb.toString().getBytes("UTF-8"));
                            Vector<ChannelSftp.LsEntry> file3 = null;
                            try {
                                file3 = channelSftp3.ls(path+"/"+test3);
                            }catch (Exception e){
                                System.out.println(e.getMessage());
                                channelSftp3.put(new ByteArrayInputStream("".getBytes("UTF-8")), test3);
                            }
                            if(file3.size() > 0){
                                System.out.println("file3 : " + file3.size());
                                channelSftp3.put(is, test3, ChannelSftp.APPEND);
                            }
                            is.close();
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
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
