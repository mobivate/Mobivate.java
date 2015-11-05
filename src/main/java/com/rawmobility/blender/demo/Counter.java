package com.rawmobility.blender.demo;

import java.util.Timer;
import java.util.TimerTask;

public class Counter {

	final long startTime;
	long allCount = 0;
	long intervalCount = 0;
	Timer timer;

	private static Counter instance = new Counter();

	private Counter() {
		startTime = System.nanoTime();
		timer = new Timer();
		timer.schedule(new CounterTask(), 0, 1 * 1000);
	}
	
	public static void stop() {
		instance.timer.cancel();
	}
	
	public synchronized static void add() {
		instance.allCount++;
		instance.intervalCount++;
	}

	class CounterTask extends TimerTask {
		int numWarningBeeps = 3;

		public void run() {
			long count = intervalCount;
			intervalCount = 0;
			
			String avg = String.format("%.5g", (allCount / (Float.valueOf(System.nanoTime() - startTime) / 1000000000)));
			System.out.println("Sent " + allCount + ", currently running at " + count + "/s, AVG " + avg + "/s");
		}
	}

}
