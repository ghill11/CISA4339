package day18;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Driver {

	public static void main(String[] args) {
		try {
//			System.out.println("******** THREADED AND SYNCHRONIZED ******** (won't double up, but will sometimes be backwards)");
//			Ball ball = new Ball();
//			Thread ping = new Thread(new SynchronizedSpeedGame("ping", ball));
//			Thread pong = new Thread(new SynchronizedSpeedGame("pong", ball));
//			ping.start();
//			pong.start();
//			ping.join();
//			pong.join();
//			System.out.println();
//
//			System.out.println("******** COORDINATED, THREADED, AND SYNCHRONIZED ******** (will always work as intended)");
//			Ball ball2 = new Ball(1);
//			ping = new Thread(new CoordinatedSynchronizedSpeedGame("ping", 1, ball2));
//			pong = new Thread(new CoordinatedSynchronizedSpeedGame("pong", 2, ball2));
//			ping.start();
//			pong.start();
//			ping.join();
//			pong.join();
//			System.out.println();
			
			ThreadPoolExecutor tp = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(5));
			tp.allowCoreThreadTimeOut(true);
			for (char i='A';i<='Z';i++) {
				while (true) {
					try {
						// if the queue is full, it will throw a RejectedExecutionException
						tp.execute(new Work(i));
						break;
					} catch (Exception e) {
						// do nothing, just try again
					} // end catch
				} // end while
			} // end for
			while (!(tp.getActiveCount() == 0)) {
				// loop "main" thread endlessly until the work is done, then we can perform cleanup tasks
				// this may not be necessary, just depends on the logic of the application and what needs to happen and when
			} // end while
			tp.shutdown(); // this will not execute until all threads in the queue have completed processing
		} catch (Exception e) {
			e.printStackTrace();
		} // end catch
	} // end main
} // end Driver