package study.funzin.send;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

/**
 * Created by JE on 2016-10-05.
 */
public class UDPClient {

    private static final int[] hex_map_data = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, /* 0 ~ 9 */
            -1, -1, -1, -1, -1, -1, -1, /* invalid char */
            10, 11, 12, 13, 14, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, /* A ~ Z */
            -1, -1, -1, -1, -1, -1, /* invalid char */
            10, 11, 12, 13, 14, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }; /* a ~ z */

    private static final byte[] byte_data = { 0x00, 0X01, 0x02, 0x03, 0X04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f };

    public static void main(String args[]){
        try {

            int lastNum = 0;

            int loop = 1000000;

//            String data = "590000040000000000042c000900080045005020000059000f001300323031362d31302d30352031353a35393a35343c040500300101000(0|1|2|3)";
//            String data = "590000040000000000042c000900080045005020000059000f001300323031362d31302d30352031353a35393a35343c040500300101000";
//            String data = "010000040000000000042c000900080045005020000059000f001300323031362d31302d30352031353a35393a35343c040500300101000" + i;

            while (lastNum < loop){
                for (int i = 0; i < 4; i++) {


                    DatagramSocket clientSocket = new DatagramSocket();
//                    InetAddress IPAddress = InetAddress.getByName("219.240.99.75");
                    InetAddress IPAddress = InetAddress.getByName("127.0.0.1");
//                    InetAddress IPAddress = InetAddress.getByName("192.168.219.15");
                    String data = "590000040000000000042c000900080045005020000059000f001300323031362d31302d30352031353a35393a35343c040500300101000" + i;
//                    String data = "010000040000000000042c000900080045005020000059000f001300323031362d31302d30352031353a35393a35343c040500300101000" + i;
                    System.out.println("data : " + data);
                    DatagramPacket sendPacket = new DatagramPacket(toBytes(data), toBytes(data).length, IPAddress, 1800);
                    clientSocket.send(sendPacket);
                    clientSocket.close();
                    Thread.sleep(5000);

                }
                lastNum++;
            }



            System.out.println("lastNum : " + lastNum);

        }catch (Exception e){
            e.getMessage();
        }

    }

    public static byte[] toBytes(String hex_string) {
        if (hex_string == null || hex_string.trim().equals("")) {
            return new byte[0];
        }

        byte[] original_bytes = new byte[hex_string.length() / 2 + (hex_string.length() % 2)];
        for (int i = 0; i < original_bytes.length; i++) {
            char hex_char1 = hex_string.charAt(i * 2);
            char hex_char2 = hex_string.charAt((i * 2) + 1);
            original_bytes[i] = (byte) ((byte_data[hex_map_data[hex_char1 - 48]] << 4) | byte_data[hex_map_data[hex_char2 - 48]]);
        }
        return original_bytes;
    }

}
