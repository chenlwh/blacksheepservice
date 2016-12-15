 /**
 * @author: chenlwh
 * @date: Sep 27, 2016 11:34:08 PM
 * @description:All Right Reserved for Party Service.
 */
package com.party.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.party.dao.PartyDao;
import com.party.util.JsonUtil;

@WebServlet("/favorite")
public class PartyFavoriteService extends BasicHttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4692114364987448157L;
	
	private String username;
	private String favoriteID;
	
	public PartyDao partyDao;
	
	public PartyFavoriteService service;

	@Override
	public void init() throws ServletException {
		super.init();
		service = (PartyFavoriteService) this.getBean("PartyFavoriteService");
	}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		username = request.getParameter("name");
		favoriteID = request.getParameter("id");
		
		super.doPost(request, response);		
	}
	

	@Override
	protected String initedJsonString() {
		String message = null;	
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		Map<String,String> map = new HashMap<String,String>();
		map.put("userName", username);
		map.put("favoriteID", favoriteID);
		
		if(username==null||favoriteID==null){
			message = "参数不合法。";
			resultMap.put("code","03");
			resultMap.put("message", message);
		}else{
			boolean isSuccess = service.getPartyDao().favorite(map);
			
			if(isSuccess){
				message = "收藏成功。";
				resultMap.put("code","01");
				resultMap.put("message", message);
			}else{
				message = "取消收藏。";
				resultMap.put("code","02");
				resultMap.put("message", message);
			}
		}

		
		return JsonUtil.map2Json(resultMap);
	}
	


	public PartyFavoriteService getService() {
		return service;
	}

	public void setService(PartyFavoriteService service) {
		this.service = service;
	}


	public PartyDao getPartyDao() {
		return partyDao;
	}

	public void setPartyDao(PartyDao partyDao) {
		this.partyDao = partyDao;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getFavoriteID() {
		return favoriteID;
	}


	public void setFavoriteID(String favoriteID) {
		this.favoriteID = favoriteID;
	}


	

}
