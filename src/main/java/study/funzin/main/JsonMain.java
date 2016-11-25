package study.funzin.main;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import study.funzin.enums.*;
import study.funzin.util.DateUtil;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by JE on 2016-11-25.
 */
public class JsonMain {

    private static final String DATE_TYPE = "yyyy-MM-dd HH:mm:ss SSS";

    public static void main(String [] args){
        String pldJson = "{\"1094\":[{\"19\":\"1\"},{\"144\":\"1\"},{\"20\":\"922700000\"},{\"148\":\"125000\"},{\"149\":\"0\"},{\"150\":\"0\"},{\"151\":\"0\"}]}";
        try {

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject;
            JSONObject jsonSelectObject;
            JSONArray jsonArray;
            jsonObject = (JSONObject)jsonParser.parse(pldJson);

            System.out.println("size : " + jsonObject.size());
            System.out.println("1094 : " + jsonObject.get("1094"));
            System.out.println("1094 : " + jsonObject.get("1094").toString());

            jsonArray = (JSONArray)jsonObject.get("1094");

            System.out.println(TLVSIDEnum.ACK_TIMEOUT.name());
            System.out.println(TLVSIDEnum.ACK_TIMEOUT.getValue());


            System.out.println("1 : " + DateUtil.formatDate(new Date(), DATE_TYPE));

            for (int i = 0; i < jsonArray.size(); i++) {
                jsonSelectObject = (JSONObject)jsonArray.get(i);

                Set<String> key = jsonSelectObject.keySet();
                Iterator<String> keys = key.iterator();

                while (keys.hasNext()){
                    String name = keys.next();
                    System.out.println("name : " + name);
                    System.out.println("original name : " + TLVSIDEnum.fromInt(Integer.parseInt(name)));
                    System.out.println("value : " + jsonSelectObject.get(name));
                }

            }

            System.out.println("2 : " + DateUtil.formatDate(new Date(), DATE_TYPE));

            for (int i = 0; i < jsonArray.size(); i++) {

                jsonSelectObject = (JSONObject)jsonArray.get(i);

                Set<String> key = jsonSelectObject.keySet();
                Iterator<String> keys = key.iterator();


                while (keys.hasNext()){
                    String name = keys.next();
                    Integer numName = Integer.parseInt(name);
                    boolean check = true;
                    String originalName = "";

                    if(check && numName > 0  && numName < 100){
                        originalName = TLVSIDEnum100.fromInt(Integer.parseInt(name)).name();
                        check = false;
                    }
                    if(check && numName > 100  && numName < 200){
                        originalName = TLVSIDEnum200.fromInt(Integer.parseInt(name)).name();
                        check = false;
                    }
                    if(check && numName > 200  && numName < 300){
                        originalName = TLVSIDEnum300.fromInt(Integer.parseInt(name)).name();
                        check = false;
                    }
                    if(check && numName > 300  && numName < 400){
                        originalName = TLVSIDEnum400.fromInt(Integer.parseInt(name)).name();
                        check = false;
                    }
                    if(check && numName > 400  && numName < 500){
                        originalName = TLVSIDEnum500.fromInt(Integer.parseInt(name)).name();
                    }
                    System.out.println("name : " + name);
                    System.out.println("original name : " + originalName);
                    System.out.println("value : " + jsonSelectObject.get(name));
                }

            }

            System.out.println("3 : " + DateUtil.formatDate(new Date(), DATE_TYPE));


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
