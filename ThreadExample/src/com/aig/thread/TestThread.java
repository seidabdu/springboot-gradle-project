package com.aig.thread;

public class TestThread {

	public static void main(String[] args) {

		SeidThread  st=new SeidThread();
		st.start();	
		
		Thread testSeidThread=new Thread() {
			public void run() {
				System.out.println("hey this is ananymose thread");
			}
		};		

		testSeidThread.start();
		
		//==============================================
		
		SeidRunnableInterface  seidRunnable =new SeidRunnableInterface();
		
		seidRunnable.run();		
		
		//=======================
		Runnable runnable = () -> { System.out.println("Lambda Runnable running"); };
		runnable.run();
		

		 Thread  t=new Thread(runnable);
		  t.start();

		  
		  System.out.println("Thread Name,  " + Thread.currentThread().getName());
		  
		  System.out.println(Thread.currentThread().getName());
		    for(int i=0; i<10; i++){
		      new Thread("" + i){
		        public void run(){
		          System.out.println("Thread: " + getName() + " running");
		        }
		      }.start();
		    }
	}

}
