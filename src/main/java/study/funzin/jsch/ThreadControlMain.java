package study.funzin.jsch;

/**
 * Created by JE on 2017-02-15.
 */
public class ThreadControlMain {

    public static void main(String [] args){

        MultiThreadMain.check = false;

        if(1==1){
            return;
        }

        String path = "/home/tango/lee/test2";
        ThreadControlMain control = new ThreadControlMain();

        try {
            control.pathChange(path);
//        control.ipChange();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void pathChange(String path) throws Exception{
        System.out.println("count1 : " + Thread.activeCount());
        MultiThreadMain.check = false;
//        JschHandler.jschDisConnect();
//        Thread.sleep(10000);
//        JschHandler.path = path;
//        JschHandler.jschConnect();
//        JschHandler.selectConnect(1);
//        JschHandler.selectConnect(2);
//        JschHandler.selectConnect(3);
//        MultiThreadMain.check = true;
        System.out.println("count2 : " + Thread.activeCount());
//        String [] arr = {};
//        MultiThreadMain.main(arr);
    }

    public void ipChange(){

    }

}

