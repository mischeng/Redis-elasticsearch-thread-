package com.example.test.thread;
public class ThreadTest1{
    private int j;
    public static void main(String args[]){
        ThreadTest1 tt=new ThreadTest1();
        Inc inc=tt.new Inc();
        Dec dec=tt.new Dec();

            Thread t=new Thread(inc);
            t.start();
            t=new Thread(dec);
            t.start();

    }
    private synchronized void inc(){
        for(int j=0;j<100;j++){
        j++;
        System.out.println(Thread.currentThread().getName()+"-inc:"+j);}
    }
    private synchronized void dec(){
        for(int i=0;i<100;i++){

        i++;
        System.out.println(Thread.currentThread().getName()+"-dec:"+i);}
    }
    class Inc implements Runnable{
        public void run(){

                inc();

        }
    }
    class Dec implements Runnable{
        public void run(){

                dec();

        }
    }
}