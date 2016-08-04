 /**
 * @author: chenlwh
 * @date: Jul 27, 2016 10:34:08 PM
 * @description:All Right Reserved for Party Service.
 */
package com.party.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 
 * Servlet implementation class BasicHttpServlet
 */
@WebServlet("/BasicHttpServlet")
public abstract class BasicHttpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public WebApplicationContext context;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasicHttpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
		context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());  		
//		context.getAutowireCapableBeanFactory().autowireBean(this);

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		output(initedJsonString(),response);
	}
	
	protected abstract String initedJsonString();
	
	protected void output(String jsonString, HttpServletResponse response){
		try {
		    response.setCharacterEncoding("UTF-8");  
		    response.setContentType("application/json; charset=utf-8");  
			PrintWriter writer = response.getWriter();
			writer.write(jsonString);
			writer.flush();
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Object getBean(String beanName){
		
		return context.getBean(beanName);
	}

}
