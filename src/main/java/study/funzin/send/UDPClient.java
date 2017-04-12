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

            String [] arr = {"3b01", "3c01", "3d01", "3e01"};

            int lastNum = 0;

            int loop = 1000000;

//            String data = "590000040000000000042c000900080045005020000059000f001300323031362d31302d30352031353a35393a35343c040500300101000(0|1|2|3)";
//            String data = "590000040000000000042c000900080045005020000059000f001300323031362d31302d30352031353a35393a35343c040500300101000";
//            String data = "010000040000000000042c000900080045005020000059000f001300323031362d31302d30352031353a35393a35343c040500300101000" + i;

            while (lastNum < loop){
                for (int i = 0; i < 4; i++) {


                    DatagramSocket clientSocket = new DatagramSocket();
                    InetAddress IPAddress = InetAddress.getByName("219.240.99.75");
//                    InetAddress IPAddress = InetAddress.getByName("127.0.0.1");
//                    InetAddress IPAddress = InetAddress.getByName("192.168.219.15");
                    //origin1
//                    String data = "590000040000000000042c000900080045005020000059000f001300323031362d31302d30352031353a35393a35343c040500300101000" + i;
                    //origin2
//                    String data = "590000040000000003042c000900080045005020000059000f001300323031362d31302d30352031353a35393a35343c040500300101000" + i;
                    //other origin
//                    String data = "010000040000000000042c000900080045005020000059000f001300323031362d31302d30352031353a35393a35343c040500300101000" + i;

                    //GW_ALM_RPT
                    //alarm16
//                    String data = "590000040000000000042c000900080045005020000059000f001300323031362d31302d30352031353a35393a35343c0405003b0101000" + i;
                    //alarm17
//                    String data = "590000040000000000042c000900080045005020000059000f001300323031362d31302d30352031353a35393a35343c0405003c0101000" + i;
                    //alarm18
//                    String data = "590000040000000000042c000900080045005020000059000f001300323031362d31302d30352031353a35393a35343c0405003d0101000" + i;
                    //alarm19
//                    String data = "590000040000000000042c000900080045005020000059000f001300323031362d31302d30352031353a35393a35343c0405003e0101000" + i;

                    //GET_ALM_RSP
                    // 0
//                    String data = "590000040000000003046F000500010000090008004500502000106c003c0446002c010100002d010100002e010100002f0101000030010100003101010000320101000033010100003401010000350101000036010100003701010000" +
//                            "39010100003a010100003b010100003c010100003d010100003e01010000";

                    // 1
//                    String data = "590000040000000003046F000500010000090008004500502000106c003c0446002c010100012d010100012e010100012f0101000130010100013101010001320101000133010100013401010001350101000136010100013701010001" +
//                            "39010100013a010100013b010100013c010100013d010100013e01010001";

                    // 2
//                    String data = "590000040000000003046F000500010000090008004500502000106c003c0446002c010100022d010100022e010100022f0101000230010100023101010002320101000233010100023401010002350101000236010100023701010002" +
//                            "39010100023a010100023b010100023c010100023d010100023e01010002";

                    // 3
//                    String data = "590000040000000003046F000500010000090008004500502000106c003c0446002c010100032d010100032e010100032f0101000330010100033101010003320101000333010100033401010003350101000336010100033701010003" +
//                            "39010100033a010100033b010100033c010100033d010100033e01010003";

                    //PROFILE_ACT
                    String data = "590000000000000008007d0009000800450050200000590036000100053c0446002c010100032d010100032e010100032f0101000330010100033101010003320101000333010100033401010003350101000336010100033701010003" +
                            "39010100033a010100033b010100033c010100033d010100033e010100035d000a00323031362e31312e3238";


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
