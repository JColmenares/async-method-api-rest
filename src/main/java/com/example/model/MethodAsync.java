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
	public void processAsync(int numPetitionCount) throws Exception {
		
		log.info("INICIO DEL MODELO ASINCRONO: "+ ConfigAsync.getNameMethod());
		
		try {
			Thread.sleep(5000);
			StringBuilder sms = new StringBuilder();
			sms.append("PETICION ");//
			sms.append(numPetitionCount);
			sms.append("- EJECUTANDOSE");
			int time = 20;
			
			for (int i = 0; i <= time; i++) {
				
				sms.append(".");
				Thread.sleep(1000);
				log.info(sms.toString());
				
			}
			sms.append("PROCESO FINALIZADO"); 
			log.info(sms.toString());
		} catch (Exception e) {
			log.info("EXCEPTION: ERROR EN EL PROCESO ASINCRONO");
		}
		
		log.info("FIN DEL MODELO ASINCRONO: "+ ConfigAsync.getNameMethod());
	}

}
