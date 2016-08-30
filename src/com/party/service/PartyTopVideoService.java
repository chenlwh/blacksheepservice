 /**
 * @author: chenlwh
 * @date: Jul 27, 2016 11:34:08 PM
 * @description:All Right Reserved for Party Service.
 */
package com.party.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.party.dao.PartyDao;
import com.party.util.JsonUtil;

@WebServlet("/topvideo")
public class PartyTopVideoService extends BasicHttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4692114364987448157L;
	
	public PartyDao partyDao;
	
	public PartyTopVideoService service;

	@Override
	public void init() throws ServletException {
		super.init();
		service = (PartyTopVideoService) this.getBean("PartyTopVideoService");
	}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		super.doPost(request, response);		
	}
	

	@Override
	protected String initedJsonString() {
		List <Object>list = service.getPartyDao().loadTopVideo();
		return JsonUtil.list2Json(list);
	}
	


	public PartyTopVideoService getService() {
		return service;
	}

	public void setService(PartyTopVideoService service) {
		this.service = service;
	}


	public PartyDao getPartyDao() {
		return partyDao;
	}

	public void setPartyDao(PartyDao partyDao) {
		this.partyDao = partyDao;
	}


	

}
