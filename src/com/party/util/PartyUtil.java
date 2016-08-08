/**
 * @author: chenlwh
 * @date: Aug 8, 2016 3:54:24 PM
 * @description:All Right Reserved for Party Service.
 */
package com.party.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 
 */
public class PartyUtil {
	public final static String NORMAL = "1";
	public final static String MANGER = "0";
	public final static String PLAYER = "1";
	public final static String USER = "2";
	
	
	public static final String getKeyID() {
		String uuid = UUID.randomUUID().toString().toUpperCase().trim();
		uuid = uuid.replaceAll("-", "");
		return uuid;
	}
	
	public static final String getCurrentDateString(){
		Date date=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
		return df.format(date);
	}
	
public static void main(String[] args) {
//	Calendar calendar = Calendar.getInstance();
	Date date=new Date();
	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
	System.out.println(df.format(date)); 
}

}
