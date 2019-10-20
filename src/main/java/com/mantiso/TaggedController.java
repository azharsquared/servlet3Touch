package com.mantiso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mantiso.dto.ApplicationSettings;
import com.mantiso.dto.CssClass;
import com.mantiso.dto.Tab;
@WebServlet(urlPatterns = {"/tag"},name = "TaggedController")
public class TaggedController extends HttpServlet{
	@Override
	public void init() throws ServletException {
		 ApplicationSettings applicationSettings = new ApplicationSettings();
	        CssClass cssClass = new CssClass();
	        cssClass.setName("redUser");
	        List<Tab> tabs = new ArrayList<>();
	        tabs.add(new Tab("SignIn", "#signin"));
	        tabs.add(new Tab("Home", "#home"));
	        tabs.add(new Tab("Profile", "#profile"));
	        tabs.add(new Tab("Messages", "#messages"));
	        tabs.add(new Tab("Settings", "#settings"));
	        applicationSettings.setTabs(tabs);
	        String[] tabNames = {"SignIn", "Home", "Profile", "Settings"};
	        applicationSettings.setTabNames(tabNames);
	        applicationSettings.setFormCssClass(cssClass);
	        getServletContext().setAttribute("app", applicationSettings);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		user.setName("duck");
		user.setEmail("duck@ducckers.ccocm");
		RequestDispatcher reqDis = getServletContext().getRequestDispatcher("/WEB-INF/tagged_index.jsp");
		req.setAttribute("user", user);
		reqDis.forward(req, resp);
	}

}
