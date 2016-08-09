/**
 * @author: chenlwh
 * @date: Jul 27, 2016 4:35:36 PM
 * @description:All Right Reserved for Party Service.
 */
package com.party.dao;

import java.util.List;
import java.util.Map;

/**
 * 
 */
public interface PartyDao{
	
	public List<Object> getPartyUser();
	
	public boolean registerUser(Map<String,String> map);
	public boolean login(Map<String,String> map);

}
