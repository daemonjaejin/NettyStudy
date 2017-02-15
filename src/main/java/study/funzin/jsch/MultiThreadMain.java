package study.funzin.jsch;

/**
 * Created by JE on 2017-02-14.
 */
public class MultiThreadMain extends Thread{

    public static Integer number = 10;
    public static Integer number2 = 3;
    public static boolean check;

    public static void main(String [] args){

        JschHandler handler = new JschHandler();
        handler.jschConnect();

//        for (int i = 0; i < 10; i++) {

            System.out.println("cnt1 : " + Thread.activeCount());

            JschHandler.path = "/home/tango/lee/test";

            MultiThreadMain multiThreadMain = new MultiThreadMain();
            multiThreadMain.start();



            Runnable r1 = new Thread1();
            Thread thread1 = new Thread(r1);
//            thread1.start();

            Runnable r2 = new Thread2();
            Thread thread2 = new Thread(r2);
//            thread2.start();


            Runnable r3 = new Thread3();
            Thread thread3 = new Thread(r3);
            thread3.start();

            try {

                System.out.println("cnt2 : " + Thread.activeCount());

//                Thread.sleep(10000);

                System.out.println("cnt3 : " + Thread.activeCount());

//                MultiThreadMain.check = false;
//                Thread1.check = false;
//                Thread2.check = false;

//                jschMain.interrupt();
//                thread1.interrupt();
//                thread2.interrupt();

                System.out.println("cnt4 : " + Thread.activeCount());

//                Thread.sleep(number * 1000);

                System.out.println("cnt5 : " + Thread.activeCount());

//                MultiThreadMain.check = true;
//                Thread1.check = true;
//                Thread2.check = true;

            }catch (Exception e){
                e.printStackTrace();
            }
//        }



    }

    @Override
    public void run(){
        JschHandler.selectConnect(1);
        check = true;
        while (check){
            System.out.println("check : " + check);
            try {
                JschHandler.behavior(1);
                System.out.println("Thread1 run!!!");
                Thread.sleep(number2 * 1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}


class Thread1 implements Runnable{

    @Override
    public void run(){
        JschHandler.selectConnect(2);
        while (MultiThreadMain.check){
            try {
                JschHandler.behavior(2);
                System.out.println("Thread2 run!!!");
                Thread.sleep(MultiThreadMain.number2 * 1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}

class Thread2 implements Runnable{

    @Override
    public void run(){
        JschHandler.selectConnect(3);
        while (MultiThreadMain.check){
            try {
                JschHandler.behavior(3);
                System.out.println("Thread3 run!!!");
                Thread.sleep(MultiThreadMain.number2 * 1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}


class Thread3 implements Runnable{

    String path = "/home/tango/lee/test2";

    @Override
    public void run(){
        try {
            Thread.sleep(10000);
            MultiThreadMain.check = false;
            System.out.println("Stop Thread");
            JschHandler.jschDisConnect();
            JschHandler.path = path;
            JschHandler.jschConnect();
            JschHandler.selectConnect(1);
            MultiThreadMain.check = true;
            System.out.println("Start Thread");
            MultiThreadMain multiThreadMain = new MultiThreadMain();
            multiThreadMain.start();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}