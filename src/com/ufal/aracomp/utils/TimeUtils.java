package com.ufal.aracomp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TimeUtils {

	public static long getCurrentSimulatedTimeWithOffset() {
		int offset = new Random().nextInt(21) - 10; 
		return System.currentTimeMillis() / 1000 + offset;
	}
	
	public static String formatTimestamp(long timestamp) {
		Date date = new Date(timestamp * 1000);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(date);
	}
	
}
