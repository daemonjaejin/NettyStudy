package study.funzin.main4;

/**
 * Created by JE on 2017-01-16.
 */
public class ThreadSyncMain {

    public static void main(String [] args){
        Runnable r = new TakeOut();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
    }

}

class  Account{

    int balance = 1000;

    public /*synchronized*/ void withDraw(int money){
        synchronized (this){
            if(balance >= money){
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                balance -= money;
            }
        }
    }

}

class TakeOut implements Runnable{

    Account acc = new Account();

    @Override
    public void run(){
        while (acc.balance > 0){
            int money = (int)(Math.random()*3 + 1) * 100;
            acc.withDraw(money);
            System.out.println("balance : " + acc.balance);
        }
    }

}