package com.example.model;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.ConfigAsync;

@Service
public class AsyncApiModel implements Serializable{

	private static final long serialVersionUID = 9081609661679598014L;
	private static Logger log = LoggerFactory.getLogger(AsyncApiModel.class);
	
	@Autowired
	private MethodAsync methodAsync;
	
	public String getRestModel(String nameUser, boolean isMen) throws Exception {
		
		log.info("Inicio del Modelo: "+ ConfigAsync.getNameMethod());
		
		StringBuilder sms = new StringBuilder();
		
		if (isMen) {
			sms.append("Bienvenido Señor ");
		} else {
			sms.append("Bienvenido Señora ");
		}
		sms.append(nameUser);
		sms.append(" a la prueba de API Rest con metodos Asincronos.");
		log.info(sms.toString());
		log.info("Preparece para la experiencia que comienza ahora...");
		
		methodAsync.processAsync();
		
		String response = "PETICIÓN EXITOSA - FUE ACTIVADO EL PROCESO ASINCRONO, VISUALICE LOS LOGS Y ESPERE CON CALMA A QUE FINALICE.";
		
		return response;
	}

}
