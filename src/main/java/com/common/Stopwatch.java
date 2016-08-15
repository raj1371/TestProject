package com.common;

import java.time.Duration;

public class Stopwatch {
	private long start;
	private long stop;

	public void start() {
		start = System.currentTimeMillis();
		stop = 0;
	}

	public void stop() {
		stop = System.currentTimeMillis();
	}

	public Duration getDuration() {
		return Duration.ofMillis(start
				- (stop > 0 ? stop : System.currentTimeMillis()));
	}

}
