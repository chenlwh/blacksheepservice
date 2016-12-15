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
	
	public List<Object> loadPreferVideo();
	public List<Object> loadPreferPlayer();
	public List<Object> loadTopVideo();
	public List<Object> loadHotPlayerVideo();
	public List<Object> loadNewPlayerVideo();
	
	public List<Object> search(String queryText);
	public List<Object> searchPlayer(String queryText);
	public List<Object> searchPlayerDetails(String queryText);
	public List<Object> searchVideo(String queryText);
	public List<Object> searchVideoDetails(String queryText);
	
	public List<Object> loadSelfPage(String username);
	public List<Object> loadSelfPrefer(String username);
	public List<Object> loadSelfVideo(String username);
	
	public List<Object> openGoodsVideo(String videoID);
	
	public boolean favorite(Map<String,String> map);
	public boolean isFavorite(Map<String,String> map);
	
	

}
