package study.funzin.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import study.funzin.vo.MyValue;

import java.io.File;

/**
 * Created by JE on 2016-11-08.
 */
public class JacksonMain {

    public static void main(String [] args){

        ObjectMapper mapper = new ObjectMapper();

        MyValue myResultObject = new MyValue();
        myResultObject.setName("MyName");
        myResultObject.setAge(11);

        try {

//            mapper.writeValue(new File("F:\\result.json"), myResultObject);
            byte [] jsonBytes = mapper.writeValueAsBytes(myResultObject);
            String jsonString = mapper.writeValueAsString(myResultObject);
            System.out.println("jsonString : " + jsonString);

            String jsonString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(myResultObject);
            System.out.println("jsonString2 : " + jsonString2);

//            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("F:\\\\result.json"), myResultObject);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
