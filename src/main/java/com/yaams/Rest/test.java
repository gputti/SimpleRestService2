/**
 * @author Gopikrishna Putti - May 11, 2017
 * Developed by Gopi for personal use.
 *
 */
package com.yaams.Rest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class test {


	public static void main(String[] args) {

		int capacity = 10;

		final BlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(capacity);

		final Thread producer = new Thread(new Runnable() {
			
			public void run() {
				for (int i = 0; i < 300; i++) {
					try {
						arrayBlockingQueue.put(Integer.valueOf(i));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(">>>> " + e.getClass().getName());
						e.printStackTrace();
						
					} finally {
						System.out.println("Vdenemma finally");
					}
					System.out.println("Value added -->" + i);
					/*
					 * Thread.sleep(1000); } catch (InterruptedException e) {
					 * e.printStackTrace(); }
					 */
					System.out.println("Producer -- > After offering integer " + i + " with boolean value "
							+ ", Array BlockingQueue remaining capacity: " + arrayBlockingQueue.remainingCapacity()
							+ " and Array BlockingQueue size is : " + arrayBlockingQueue.size());
				}

			}

		});

		Thread consumer = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 200; i++) {

					try {
						System.out.println("Value taken ->" + arrayBlockingQueue.take());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					/*
					 * Thread.sleep(10); } catch (InterruptedException e) {
					 * e.printStackTrace(); }
					 */
				}
			}

		});

		producer.start();
		consumer.start();
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
		      public void run() {
		        System.out.println("Running Shutdown Hook");
		        try {
					producer.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      }
		    });
		
	}


}
