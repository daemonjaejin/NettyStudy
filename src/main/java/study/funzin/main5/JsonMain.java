package study.funzin.main5;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

/**
 * Created by jin on 17. 4. 13.
 */
public class JsonMain {

    public static void main(String args[]){

        String word = "{\"1018\":[{\"9\":\"\"},{\"163\":\"60\"},{\"164\":\"600\"},{\"170\":\"5\"},{\"165\":\"100\"},{\"166\":\"0\"}," +
                "{\"167\":\"0\"},{\"168\":\"0\"},{\"1058\":[{\"44\":\"4\"},{\"45\":\"172.28.177.4\"},{\"46\":\"\"},{\"161\":\"1700\"}," +
                "{\"162\":\"1700\"}]},{\"1059\":[{\"44\":\"4\"},{\"45\":\"172.28.19.4\"},{\"46\":\"\"},{\"161\":\"1700\"},{\"162\":\"1700\"}]}]}";

        String result = getJson(word, 1018, 1058);
        System.out.println("result : " + result);

    }

    public static String getJson(String word, Integer pCompoundKey, Integer pKey){

        ObjectMapper objectMapper = new ObjectMapper();
        String value = "";
        Map<Integer,JsonNode> listMap = new HashMap<Integer, JsonNode>();

        try {

            listMap = objectMapper.readValue(word, new TypeReference<Map<Integer,JsonNode>>(){});

            JsonNode jsonNode = listMap.get(pCompoundKey);

            System.out.println("jsonNode : " + jsonNode.toString());
            if(jsonNode!=null &&  jsonNode.isArray()){

//                List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
//                list = objectMapper.readValue(jsonNode.toString(), new TypeReference<List<HashMap<String, String>>>() {});
//                System.out.println(list.toString());

                for(JsonNode node : jsonNode) {
                    System.out.println("node : " + node.toString());
                    System.out.println("node name : " + node.fieldNames());
                    System.out.println("val : " + node.path("1058"));
                    JsonNode node2 = node.path("1058");
                    for (JsonNode nodein : node2){
                        System.out.println("val : " + nodein.path("44"));
                        System.out.println("val2 : " + nodein.path("45"));
                    }

                }

                Iterator<JsonNode> it = jsonNode.path(pKey).iterator();

                while(it.hasNext()){
                    System.out.println(it.next().get(44));
                }

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return value;
    }

}
