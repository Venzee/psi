package net.dlhz.core.base.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class SystemInitListener implements ServletContextListener{
	
	private static final Logger LOG = Logger.getLogger(SystemInitListener.class);
	
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		LOG.info("开始启动服务...");
	}

}
