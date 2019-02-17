package be.bhasher.spider.utils;

import java.util.Date;

public class Time {

	/**
	 * @return the current timestamp.
	 */
	public static long getTimestamp(){
		return new Date().getTime();
	}

}
