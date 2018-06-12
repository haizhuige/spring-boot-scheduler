package com.neo.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo2 {
   public static void main(String[] args) {
	  Semaphore semaphore=new Semaphore(5);
	
	  for(int i=0;i<8;i++){
		  new Worker(i, semaphore).start();
	  }
  }
   static class Worker extends Thread{
       private int num;
       private Semaphore semaphore;
       public Worker(int num,Semaphore semaphore){
           this.num = num;
           this.semaphore = semaphore;
       }

       @Override
       public void run() {
           try {
             boolean flag= semaphore.tryAcquire();
             if(flag){
            	 System.out.println("工人"+this.num+"占用一个机器在生产...");
                 Thread.sleep(2000);
                 System.out.println("工人"+this.num+"释放出机器");
                 semaphore.release();           
             } 
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
   }
}
