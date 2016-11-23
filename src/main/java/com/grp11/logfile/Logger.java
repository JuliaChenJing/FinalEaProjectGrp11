package com.grp11.logfile;

import org.springframework.stereotype.Component;

@Component
public class Logger implements ILogger {
	
	public void log(String logstring) {
		System.out.println("================Bean Created================================");
		java.util.logging.Logger log = java.util.logging.Logger.getLogger("Food Delievery System Logger");
		log.info(logstring);
	}

}


