package com.cybage;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

import java.util.Date;

public class StartEventHandler  implements ApplicationListener<ContextStartedEvent>{

	public void onApplicationEvent(ContextStartedEvent event) {
		System.out.println("application context started at: "+ new Date());
		
	}

}
