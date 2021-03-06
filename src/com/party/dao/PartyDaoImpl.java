/**
 * @author: chenlwh
 * @date: Jul 28, 2016 4:55:01 PM
 * @description:All Right Reserved for Party Service.
 */
package com.party.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.party.util.PartyUtil;

/**
 * 
 */
public class PartyDaoImpl extends SqlMapClientDaoSupport implements PartyDao{
	
	public static final Logger log = Logger.getLogger(PartyDaoImpl.class);

	@SuppressWarnings("unchecked")
	public List<Object> getPartyUser(){
		return 	getSqlMapClientTemplate().queryForList("mainTableService.getTableCodeList");
	}
	
	@SuppressWarnings("rawtypes")
	public boolean registerUser(Map<String, String> map) {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		String userName = map.get("userName");
		List list = getSqlMapClientTemplate().queryForList("mainTableService.validUser", userName);
		if(list==null || list.size()==0){
			String id = PartyUtil.getKeyID();
			String md5code = PartyUtil.getKeyID();
			String status = PartyUtil.NORMAL;
			String registerDate = PartyUtil.getCurrentDateString();
			String isRemember = "1";
			String type = PartyUtil.USER;
			
			map.put("id", id);
			map.put("md5code", md5code);
			map.put("status", status);
			map.put("registerDate", registerDate);
			map.put("isRemember", isRemember);
			map.put("type", type);
			
			getSqlMapClientTemplate().insert("mainTableService.registerUser", map);
			
			isSuccess = true;
		}
		
		return isSuccess;
	}

	/* (non-Javadoc)
	 * @see com.party.dao.PartyDao#login(java.util.Map)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean login(Map<String, String> map) {
		boolean isSuccess = false;
		List list = getSqlMapClientTemplate().queryForList("mainTableService.login", map);
		if(list!=null && list.size()==1){			
			isSuccess = true;
		}
		
		return isSuccess;
	}

	/* (non-Javadoc)
	 * @see com.party.dao.PartyDao#loadPreferVideo()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> loadPreferVideo() {
		// TODO Auto-generated method stub
		return 	getSqlMapClientTemplate().queryForList("mainTableService.loadPreferVideo");
	}

	/* (non-Javadoc)
	 * @see com.party.dao.PartyDao#loadPreferPlayer()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> loadPreferPlayer() {
		// TODO Auto-generated method stub
		return 	getSqlMapClientTemplate().queryForList("mainTableService.loadPreferPlayer");
	}

	/* (non-Javadoc)
	 * @see com.party.dao.PartyDao#loadTopVideo()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> loadTopVideo() {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("mainTableService.loadTopVideo");
	}

	/* (non-Javadoc)
	 * @see com.party.dao.PartyDao#loadHotPlayerVideo()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> loadHotPlayerVideo() {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("mainTableService.loadHotPlayerVideo");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> loadNewPlayerVideo() {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("mainTableService.loadNewPlayerVideo");
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Object> searchPlayer(String queryText) {
		if(queryText.toUpperCase().indexOf("OR")>-1){
			List list = new ArrayList();
			list.add("Bad query!");
			return list;
		}else{
			return getSqlMapClientTemplate().queryForList("mainTableService.searchPlayerList",queryText);
		}
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Object> searchPlayerDetails(String queryText) {
		if(queryText.toUpperCase().indexOf("OR")>-1){
			List list = new ArrayList();
			list.add("Bad query!");
			return list;
		}else{
			return getSqlMapClientTemplate().queryForList("mainTableService.searchPlayerResult",queryText);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Object> searchVideo(String queryText) {
		if(queryText.toUpperCase().indexOf("OR")>-1){
			List list = new ArrayList();
			list.add("Bad query!");
			return list;
		}else{
			return getSqlMapClientTemplate().queryForList("mainTableService.searchVideoList",queryText);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Object> searchVideoDetails(String queryText) {
		if(queryText.toUpperCase().indexOf("OR")>-1){
			List list = new ArrayList();
			list.add("Bad query!");
			return list;
		}else{
			return getSqlMapClientTemplate().queryForList("mainTableService.searchVideoResult",queryText);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Object> search(String queryText) {
		if(queryText.toUpperCase().indexOf("OR")>-1){
			Map playMap = new HashMap();
			playMap.put("tag", "player");
			playMap.put("data", "Bad query!");
			Map videoMap = new HashMap();
			videoMap.put("tag", "video");
			videoMap.put("data", "Bad query!");
			
			List<Object> list = new ArrayList<Object>();
			list.add(playMap);
			list.add(videoMap);

			return list;
		}else{
			List playerList = getSqlMapClientTemplate().queryForList("mainTableService.searchPlayerList",queryText);
			List videoList = getSqlMapClientTemplate().queryForList("mainTableService.searchVideoList",queryText);
			Map playMap = new HashMap();
			playMap.put("tag", "player");
			playMap.put("data", playerList);
			Map videoMap = new HashMap();
			videoMap.put("tag", "video");
			videoMap.put("data", videoList);
			
			List<Object> list = new ArrayList<Object>();
			list.add(playMap);
			list.add(videoMap);
			return list;
		}
		
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Object> loadSelfPage(String username) {
		return getSqlMapClientTemplate().queryForList("mainTableService.loadSelfPage", username);
	}

	@SuppressWarnings("unchecked")
	public List<Object> loadSelfPrefer(String username) {
		// TODO Auto-generated method stub
		return 	getSqlMapClientTemplate().queryForList("mainTableService.loadSelfPrefer",username);
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> loadSelfVideo(String username) {
		// TODO Auto-generated method stub
		return 	getSqlMapClientTemplate().queryForList("mainTableService.loadSelfVideo",username);
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> openGoodsVideo(String videoID) {
		// TODO Auto-generated method stub
		return 	getSqlMapClientTemplate().queryForList("mainTableService.openGoodsVideo",videoID);
	}
	
	@SuppressWarnings("rawtypes")
	public boolean favorite(Map<String, String> map) {
		// TODO Auto-generated method stub
		List list = getSqlMapClientTemplate().queryForList("mainTableService.favorite", map);
		if(list==null || list.size()==0){
			String date = PartyUtil.getCurrentDateString();
			map.put("date", date);			
			getSqlMapClientTemplate().insert("mainTableService.addFavorite", map);			
			return true;
		}else{
			getSqlMapClientTemplate().delete("mainTableService.deleteFavorite", map);	
			return false;
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	public boolean isFavorite(Map<String, String> map) {
		// TODO Auto-generated method stub
		List list = getSqlMapClientTemplate().queryForList("mainTableService.favorite", map);
		if(list==null || list.size()==0){		
			return false;
		}else{
			return true;
		}
		
	}
	
	
}
