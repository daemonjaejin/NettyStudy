package study.funzin.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import study.funzin.vo.MyBean;
import study.funzin.vo.MyValue;
import study.funzin.vo.User;
import study.funzin.vo.User2;

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

        MyBean myBean = new MyBean();
        myBean.bar = "bar";
        myBean.foo = "foo";
        myBean.setCode(5);
        myBean.external = "external";

        User user = new User();
        user.a = 34;
        user.u = 1;
        user.e = "test@test.com";

        User2 user2 = new User2();
        user2.age = 34;
        user2.email = "test@test.com";
        user2.u = 2;

        try {

//            mapper.writeValue(new File("F:\\result.json"), myResultObject);
            byte [] jsonBytes = mapper.writeValueAsBytes(myResultObject);
            String jsonString = mapper.writeValueAsString(myResultObject);
            System.out.println("jsonString : " + jsonString);

            String jsonString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(myResultObject);
            System.out.println("jsonString2 : " + jsonString2);

//            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("F:\\\\result.json"), myResultObject);

            String jsonString3 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(myBean);
            System.out.println("jsonString3 : " + jsonString3);

            String jsonString4 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
            System.out.println("jsonString4 : " + jsonString4);

            String jsonString5 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user2);
            System.out.println("jsonString5 : " + jsonString5);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
