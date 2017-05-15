/**
 * @author Gopikrishna Putti - May 4, 2017
 * Developed by Gopi for personal use.
 *
 */
package com.yaams.dataobj;

import java.util.Random;

public class Test {


	
	Object factory = null; 
	Object xyz = new Object(); 
	Random random = new Random();
	
	public void init( ) {
		
		synchronized(Test.class) {
			if( factory == null) {
				System.out.println("creaaating factory:  " + Thread.currentThread().getName());
				factory = new Object();
			} else {
				System.out.println("seeems factory created:  " + Thread.currentThread().getName());
			}
		}
	}
	
	public void generateRandom() {
		
		synchronized(this) {
			while (true) {
				System.out.println("> " + random.nextInt(1000) + " " +   Thread.currentThread().getName());
				
			}
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {

		Test t1 = new Test();		
		
		Thread thread1 = new Thread(new Task(t1));
		Thread thread2 = new Thread(new Task(t1));
		
		thread1.setPriority(10);
		
		thread1.start();
		thread2.start();
		
		
		{
			
			
		}

		{
			thread1.notifyAll();
		}
	}
	
	static class Task  implements Runnable {

		Test t = null; 		
		Task(Test tt) {
			t = tt;
		}
				
		public void run() {
			t.generateRandom();
		}
		
		
	}

}
