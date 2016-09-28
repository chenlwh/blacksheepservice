/**
 * @author: chenlwh
 * @date: Sep 21, 2016 4:26:39 PM
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
@WebServlet("/goodsvideo")
public class PartyGoodsVideoService extends BasicHttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PartyDao partyDao;

	public PartyGoodsVideoService service;
	
	private String videoID;

	@Override
	public void init() throws ServletException {
		super.init();
		service = (PartyGoodsVideoService) this.getBean("PartyGoodsVideoService");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		videoID = request.getParameter("param");
		super.doPost(request, response);
	}

	@Override
	protected String initedJsonString() {
		List<Object> list = service.getPartyDao().openGoodsVideo(videoID);
		return JsonUtil.list2Json(list);
	}

	public PartyGoodsVideoService getService() {
		return service;
	}

	public void setService(PartyGoodsVideoService service) {
		this.service = service;
	}

	public PartyDao getPartyDao() {
		return partyDao;
	}

	public void setPartyDao(PartyDao partyDao) {
		this.partyDao = partyDao;
	}

}
