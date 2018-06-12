package com.neo.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
   public static void main(String[] args) {
	CyclicBarrier  cyclicBarrier=new CyclicBarrier(4);
	for(int i=0;i<4;i++){
	  new Thread(	new Write(cyclicBarrier)).start();
	}
	 try {
         Thread.sleep(25000);
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
     
     System.out.println("CyclicBarrier重用");

     for(int i=0;i<4;i++) {
    	 new Thread(	new Write(cyclicBarrier)).start();
     }
  }
   static class  Write implements Runnable{
     private CyclicBarrier barrier;
	   
	public Write(CyclicBarrier barrier) {
		super();
		this.barrier = barrier;
	}

	@Override
	public void run() {
		System.out.println("thread"+Thread.currentThread().getName()+"准备执行任务");
		try {
			Thread.sleep(5000);
			System.out.println("thread"+Thread.currentThread().getName()+"执行任务完毕");
			barrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("thread"+Thread.currentThread().getName()+"执行其他任务");
	}
	   
   }
}
