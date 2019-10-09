package com.mantiso;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: kevinj
 * Date: 22/11/13
 * Time: 10:36
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(urlPatterns = {"/home"},name = "BlogController",initParams = {@WebInitParam(name ="productName", value = "Welcome annotation initialization")})//urlPatterns = {"/home","/*.do"})
public class BlogController extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String appName = "My Application";
	
	 @Override
	    public void init() throws ServletException {
	        appName = getServletContext().getInitParameter("ProductName");
	    }


	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String name = req.getParameter("name");
        if(name != null) {
            resp.setContentType("text/xml");
            resp.getWriter().printf("<application>" +
                    "<name>Hello %s</name>" +
                    "<product>%s</product>" +
                    "</application>", name, appName);
        } else {
            resp.getWriter().write("Please enter a name");
        }
    }
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String name = req.getParameter("name");
	        if(name != null && name != ""){
	            resp.getWriter().printf("Hello %s", name);
	        } else {
	            resp.sendRedirect("/WEB-INF/index.jsp");
	        }
    }
}
