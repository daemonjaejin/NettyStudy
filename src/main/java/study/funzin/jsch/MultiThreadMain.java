package study.funzin.jsch;

/**
 * Created by JE on 2017-02-14.
 */
public class MultiThreadMain extends Thread{

    public static Integer number = 10;
    public static Integer number2 = 1;
    public static boolean check = true;

    public static void main(String [] args){

        for (int i = 0; i < 10; i++) {

            System.out.println("cnt1 : " + Thread.activeCount());

            MultiThreadMain multiThreadMain = new MultiThreadMain();
            multiThreadMain.start();

            Thread1 thread1 = new Thread1();
            thread1.start();

            Thread2 thread2 = new Thread2();
            thread2.start();

            try {

                System.out.println("cnt2 : " + Thread.activeCount());

                Thread.sleep(10000);

                System.out.println("cnt3 : " + Thread.activeCount());

                MultiThreadMain.check = false;
                Thread1.check = false;
                Thread2.check = false;

//                jschMain.interrupt();
//                thread1.interrupt();
//                thread2.interrupt();

                System.out.println("cnt4 : " + Thread.activeCount());

                Thread.sleep(number * 1000);

                System.out.println("cnt5 : " + Thread.activeCount());

                MultiThreadMain.check = true;
                Thread1.check = true;
                Thread2.check = true;

            }catch (Exception e){
                e.printStackTrace();
            }
        }



    }

    @Override
    public void run(){
        JschHandler handler = new JschHandler();
        handler.jschConnect();
        handler.selectConnect(1);
        while (check){
            try {
                handler.behavior(1);
                System.out.println("jschMain run!!!");
                Thread.sleep(number2 * 1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}


class Thread1 extends Thread{

    public static boolean check = true;

    @Override
    public void run(){
        while (check){
            try {
                System.out.println("Thread1 run!!!");
                Thread.sleep(MultiThreadMain.number2 * 1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}

class Thread2 extends Thread{

    public static boolean check = true;

    @Override
    public void run(){
        while (check){
            try {
                System.out.println("Thread2 run!!!");
                Thread.sleep(MultiThreadMain.number2 * 1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
