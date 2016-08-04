/**
 * @author: chenlwh
 * @date: Jul 27, 2016 3:35:50 PM
 * @description:All Right Reserved for Party Service.
 */
package com.party.util;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 */
public class JsonUtil {
	
	public static String object2Json(Object obj){
		JSONObject json = JSONObject.fromObject(obj);	
		
		return json.toString();
	}
	
	public static String list2Json(List<Object> list){
		JSONArray array = JSONArray.fromObject(list);
		
		return array.toString();
	}
	
	public static String map2Json(Map<String,Object> map){
		JSONObject json = JSONObject.fromObject(map);
		return json.toString();
	}

}
