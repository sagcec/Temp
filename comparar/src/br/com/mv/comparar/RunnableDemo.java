package br.com.mv.comparar;

public class RunnableDemo {

	public static void main(String args[]) {
		System.out.println("Main thread starting.");
		MyThread mt = new MyThread();
		Thread newThrd = new Thread(mt);
		newThrd.start();

		do {
			System.out.println("In main thread.");

			try {
				Thread.sleep(2500);
			} catch (InterruptedException exc) {
				System.out.println("Main thread interrupted.");
			}
		} while (mt.count != 5);

		System.out.println("Main thread ending.");
	}

}