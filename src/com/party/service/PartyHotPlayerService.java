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

@WebServlet("/PartyHotPlayerService")
public class PartyHotPlayerService extends BasicHttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4692114364987448157L;
	
	public PartyDao partyDao;
	
	public PartyHotPlayerService service;

	@Override
	public void init() throws ServletException {
		super.init();
		service = (PartyHotPlayerService) this.getBean("partyHotPlayerService");
	}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
		
		String name = request.getParameter("name");
		System.out.println(name);
	}

	@Override
	protected String initedJsonString() {

		List<Object> list = service.partyDao.getPartyUser();
		
		return JsonUtil.list2Json(list);
	}


	public PartyHotPlayerService getService() {
		return service;
	}

	public void setService(PartyHotPlayerService service) {
		this.service = service;
	}


	public PartyDao getPartyDao() {
		return partyDao;
	}

	public void setPartyDao(PartyDao partyDao) {
		this.partyDao = partyDao;
	}


//	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");		
//		PartyHotPlayerService service = (PartyHotPlayerService) context.getBean("partyHotPlayerService");
//		System.out.println(JsonUtil.list2Json(service.partyDao.getPartyUser()));
//				
//	}
	
	

}
