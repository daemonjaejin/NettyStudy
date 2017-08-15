package study.funzin.protocol;

import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

/**
 * Created by JE on 2017-06-02.
 */
public class CubeURLStreamHandlerFactory implements URLStreamHandlerFactory {

    @Override
    public URLStreamHandler createURLStreamHandler(String protocol){

        try {

            if(protocol.equals("cube") == true){
                //return new CubeURLStreamHandler();
            }

            String className = "sun.net.www.protocol." + protocol + ".Handler";
            Class<?> type = Class.forName(className);
            if(type == null)return null;
            return (URLStreamHandler)type.newInstance();
        }catch (Exception e){
            return null;
        }

    }

}
