package com.igeek.utils;

import java.util.UUID;

public class StringUtils {
	//返回一个UUID  32位不重复的数
	public static String getUUID(){
		String uuid = UUID.randomUUID().toString().replace("-","");
		return uuid;
	}

}
