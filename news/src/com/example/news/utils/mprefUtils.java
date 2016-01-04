package com.example.news.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class mprefUtils {

	final static String SPACENAMA = "config";

	public static void putboolean(Context context, String key, boolean vauels) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(
				SPACENAMA, context.MODE_PRIVATE);
		sharedPreferences.edit().putBoolean(key, vauels).commit();
	}

	public static boolean getboolean(Context context, String key,
			boolean defualt) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(
				SPACENAMA, context.MODE_PRIVATE);
		return sharedPreferences.getBoolean(key, defualt);
	}

}
