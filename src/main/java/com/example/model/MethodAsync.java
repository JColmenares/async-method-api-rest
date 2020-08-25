package com.example.model;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.ConfigAsync;

@Service
public class MethodAsync implements Serializable{

	private static final long serialVersionUID = 1328204895104995971L;
	private static Logger log = LoggerFactory.getLogger(MethodAsync.class);
	
	@Async("asyncExecutor")
	public void processAsync() throws Exception {
		
		log.info("Inicio del Modelo Asincrono: "+ ConfigAsync.getNameMethod());
		
		Thread.sleep(5000);
		StringBuilder sms = new StringBuilder();
		sms.append("Ejecutandose");
		
		int time = 20;
		
		for (int i = 0; i <= time; i++) {
			
			sms.append(".");
			Thread.sleep(1000);
			log.info(sms.toString());
			
		}
		sms.append("PROCESO FINALIZADO"); 
		log.info(sms.toString());
		
		log.info("Fin del Modelo Asincrono: "+ ConfigAsync.getNameMethod());
	}

}
