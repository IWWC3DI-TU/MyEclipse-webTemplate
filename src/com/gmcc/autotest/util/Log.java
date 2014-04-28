package com.gmcc.autotest.util;

public class Log {
	public static void info(String message){
		Utils.getInstance().Log.info(message);
	}
	public static void err(String message){
		Utils.getInstance().Log.error(message);
	}
}
