package br.com.mv.comparar;

public class MyThread implements Runnable {

	int count;

	public MyThread() {
		count = 0;
	}

	public void run() {
		System.out.println("MyThread starting.");

		try {
			do {
				Thread.sleep(5000);
				System.out.println("In MyThread, count is " + count);
				count++;
			} while (count < 5);

		} catch (InterruptedException exc) {
			System.out.println("MyThread interrupted.");
		}

		System.out.println("MyThread terminating.");
	}

}