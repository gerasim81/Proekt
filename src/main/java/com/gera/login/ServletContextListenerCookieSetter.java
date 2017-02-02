package com.gera.login;

import javax.servlet.*;


public class ServletContextListenerCookieSetter implements ServletContextListener {

    
    public ServletContextListenerCookieSetter() {
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    }

	
    public void contextInitialized(ServletContextEvent sce)  {
    	ServletContext sc = sce.getServletContext();
    	SessionCookieConfig sessionCookieConfig = sc.getSessionCookieConfig();
//		sessionCookieConfig.setMaxAge(24*60*60);//release
		sessionCookieConfig.setMaxAge(30*60);//release
//		sessionCookieConfig.setMaxAge(30);//debug
    }
	
}
