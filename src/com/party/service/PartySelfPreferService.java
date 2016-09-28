/**
 * @author: chenlwh
 * @date: Sep 12, 2016 3:26:39 PM
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

/**
 * 
 */
@WebServlet("/selfprefer")
public class PartySelfPreferService extends BasicHttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PartyDao partyDao;

	public PartySelfPreferService service;
	
	private String username;

	@Override
	public void init() throws ServletException {
		super.init();
		service = (PartySelfPreferService) this.getBean("PartySelfPreferService");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		username = request.getParameter("name");
		super.doPost(request, response);
	}

	@Override
	protected String initedJsonString() {
		List<Object> list = service.getPartyDao().loadSelfPrefer(username);
		return JsonUtil.list2Json(list);
	}

	public PartySelfPreferService getService() {
		return service;
	}

	public void setService(PartySelfPreferService service) {
		this.service = service;
	}

	public PartyDao getPartyDao() {
		return partyDao;
	}

	public void setPartyDao(PartyDao partyDao) {
		this.partyDao = partyDao;
	}

}
