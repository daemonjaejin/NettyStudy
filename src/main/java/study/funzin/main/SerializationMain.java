package study.funzin.main;

import java.io.*;

/**
 * Created by JE on 2016-12-09.
 */
public class SerializationMain {

    public static void main(String [] args) throws IOException{
        VO vo = new VO();
        vo.setName("호옹이");
        vo.setAge(11);
        vo.setEmail("a@a.com");

        FileOutputStream fos = new FileOutputStream("D:\\text.txt", false);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream out = new ObjectOutputStream(bos);

        out.writeObject(vo);
        out.close();

    }

}

class VO implements Serializable{

    private static final long serialVersionUID = -395246598280246464L;

    private String name;
    private int age;
    private String email;

    transient String test;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
