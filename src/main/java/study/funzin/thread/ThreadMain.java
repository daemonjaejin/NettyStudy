package study.funzin.thread;

/**
 * Created by jin on 17. 1. 24.
 */
public class ThreadMain {

    public static void main(String [] args){


        A a = new A();
        B b = new B();

//        Thread t1 = new Thread(a);
//
//        Thread t2 = new Thread(b);

        boolean check = true;

        while (true){
            try {
                Thread t1 = new Thread(a);
                t1.start();
                Thread.sleep(1000);
                t1.interrupt();

                Thread t2 = new Thread(b);
                t2.start();
                Thread.sleep(1000);
                t2.interrupt();

                System.out.println("cnt : " + Thread.activeCount());
            }catch (Exception e){
                e.printStackTrace();
            }
        }



    }

}

class A implements Runnable{

    @Override
    public void run(){
        try {
            System.out.println("A");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

class B implements Runnable{

    @Override
    public void run(){
        try {
            System.out.println("B");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
