 /**
 * @author: chenlwh
 * @date: Jul 27, 2016 11:34:08 PM
 * @description:All Right Reserved for Party Service.
 */
package com.party.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.party.dao.PartyDao;
import com.party.util.JsonUtil;

@WebServlet("/searchvideo")
public class PartySearchVideoService extends BasicHttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4692114364987448157L;
	public String query;
	
	public PartyDao partyDao;
	
	public PartySearchVideoService service;

	@Override
	public void init() throws ServletException {
		super.init();
		service = (PartySearchVideoService) this.getBean("PartySearchVideoService");
	}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		query = request.getParameter("query");
		super.doPost(request, response);
	}

	@Override
	protected String initedJsonString() {
		List<Object> list = new ArrayList<Object>();
		if (query != null&&query.trim().length() > 0)
			list = service.getPartyDao().searchVideo(query);
		return JsonUtil.list2Json(list);
	}
	


	public PartySearchVideoService getService() {
		return service;
	}

	public void setService(PartySearchVideoService service) {
		this.service = service;
	}


	public PartyDao getPartyDao() {
		return partyDao;
	}

	public void setPartyDao(PartyDao partyDao) {
		this.partyDao = partyDao;
	}


	

}
