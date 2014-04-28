package com.gmcc.autotest.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmcc.autotest.util.Log;
import com.gmcc.autotest.util.Utils;

public class Controller extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	HashMap<String,Object> hashmap=null;

//	private ServletConfig config=null;

	public void init(ServletConfig config) {
		hashmap = new HashMap<String,Object>();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextBo = request.getParameter("nextBo");
		Log.info("nextBo=====>"+nextBo);
		if (nextBo == null || nextBo.equals("")) {
			try {
				response.sendRedirect("../index/noperson.jsp");
			} catch (Exception e) {
			}
		}			
		try {
			if (hashmap.get(nextBo) == null)
				hashmap.put(nextBo, Class.forName(nextBo).newInstance());
		} catch (Exception e) {
			Log.err(e.getMessage());
		}
		try {
		    
		    
			Command cmd = (Command) hashmap.get(nextBo);
			String nextPage = cmd.Execute(request, response);
			if(nextPage==null||nextPage.equalsIgnoreCase("null")){
			    if (nextPage==null)   
			    	Log.info(" nextpage is null" );
			    else if (nextPage.equalsIgnoreCase("null")) 
			    	Utils.getInstance().Log.info(" nextpage is string 'null'" );			   
				try {
					request.setAttribute("msg", "服务错误");
					request.getRequestDispatcher("../index/error.jsp").forward(request, response);
					return ;
				} catch (Exception ex) {
				    Log.err(ex.getMessage());
				}
			}
			Log.info("next Page====>"+nextPage);
			request.getRequestDispatcher(nextPage).forward(request, response);
		} catch (Exception se) {
			Log.err(se.getMessage());
			try {
				request.setAttribute("msg", "错误");
				request.getRequestDispatcher("../index/error.jsp").forward(request, response);
			} catch (Exception ex) {
			}
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doPost(request,response);
	}
}
