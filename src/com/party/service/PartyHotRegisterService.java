 /**
 * @author: chenlwh
 * @date: Jul 27, 2016 11:34:08 PM
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

@WebServlet("/register")
public class PartyHotRegisterService extends BasicHttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4692114364987448157L;
	
	private String username;
	private String password;
	
	public PartyDao partyDao;
	
	public PartyHotRegisterService service;

	@Override
	public void init() throws ServletException {
		super.init();
		service = (PartyHotRegisterService) this.getBean("PartyHotRegisterService");
	}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		username = request.getParameter("name");
		password = request.getParameter("pwd");
		
		super.doPost(request, response);		
	}
	

	@Override
	protected String initedJsonString() {
		String message = null;	
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		Map<String,String> map = new HashMap<String,String>();
		map.put("userName", username);
		map.put("password", password);
		
		if(username==null){
			message = "用户名不能为空.";
			resultMap.put("code","03");
			resultMap.put("message", message);
		}else if(password==null){
			message = "密码不能为空。";
			resultMap.put("code","04");
			resultMap.put("message", message);
		}else{
			boolean isSuccess = service.getPartyDao().registerUser(map);
			
			if(!isSuccess){
				message = "用户名已存在！";
				resultMap.put("code","01");
				resultMap.put("message", message);
			}else{
				message = "注册成功！";
				resultMap.put("code","02");
				resultMap.put("message", message);
			}
		}

		
		return JsonUtil.map2Json(resultMap);
	}
	


	public PartyHotRegisterService getService() {
		return service;
	}

	public void setService(PartyHotRegisterService service) {
		this.service = service;
	}


	public PartyDao getPartyDao() {
		return partyDao;
	}

	public void setPartyDao(PartyDao partyDao) {
		this.partyDao = partyDao;
	}


	

}
