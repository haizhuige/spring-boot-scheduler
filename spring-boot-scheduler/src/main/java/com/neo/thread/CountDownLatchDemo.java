package com.neo.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		  CountDownLatch countDownLatch = new CountDownLatch(3);
	          
	        Thread thread1 = new Thread(new Runnable() {  
	            @Override  
	            public void run() {  
	                //do something  
	                try {  
	                    Thread.sleep(1000);  
	                } catch (InterruptedException e) {  
	                    e.printStackTrace();  
	                }  
	                System.out.println(Thread.currentThread().getName() + " is done");  
	                countDownLatch.countDown();  
	            }  
	        }, "thread1");  
	          
	        Thread thread2 = new Thread(new Runnable() {  
	            @Override  
	            public void run() {  
	                //do something  
	                try {  
	                    Thread.sleep(2000);  
	                } catch (InterruptedException e) {  
	                    e.printStackTrace();  
	                }  
	                System.out.println(Thread.currentThread().getName() + " is done");  
	                countDownLatch.countDown();  
	            }  
	        }, "thread2");  
	          
	          
	        thread1.start();  
	        thread2.start();  
	        countDownLatch.await(10,TimeUnit.SECONDS);  
	        System.out.println(Thread.currentThread().getName() + " count down is ok");   
	}

}
