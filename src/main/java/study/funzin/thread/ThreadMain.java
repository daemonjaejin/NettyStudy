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
//                Thread.sleep(1000);
//                t1.interrupt();

                Thread t2 = new Thread(b);
                t2.start();
                Thread.sleep(1000);
//                t2.interrupt();

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
//            for (int i = 0; i<10000; i++){
//                System.out.println("A i = " + i);
//            }
            AA aa = new AA();
            Thread t1 = new Thread(aa);
            t1.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

class AA implements Runnable{
    @Override
    public void run(){
        System.out.println("AA");
        for (int i = 0; i<100; i++){
            System.out.println("AA i = " + i);
        }
    }
}

class B implements Runnable{

    @Override
    public void run(){
        try {
            System.out.println("B");
//            for (int i = 0; i<10000; i++){
//                System.out.println("B i = " + i);
//            }
            BB bb = new BB();
            Thread t2 = new Thread(bb);
            t2.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

class BB implements Runnable{
    @Override
    public void run(){
        System.out.println("BB");
        for (int i = 0; i<100; i++){
            System.out.println("BB i = " + i);
        }
    }
}
