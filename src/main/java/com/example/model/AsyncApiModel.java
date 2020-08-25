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
	
	public StringBuilder getRestModel(String nameUser, boolean isMen) throws Exception {
		
		log.info("INICIO DEL MODELO: "+ ConfigAsync.getNameMethod());
		
		StringBuilder response = new StringBuilder();
		
		try {
			
			if (isMen) {
				response.append("BIENVENIDO SEÑOR ");
			} else {
				response.append("BIENVENIDO SEÑORA ");
			}
			response.append(nameUser);
			response.append(", A LA PRUEBA DE API REST CON METODOS ASINCRONOS.");
			log.info(response.toString());
			log.info("PREPARECE PARA LA EXPERIENCIA QUE COMIENZA AHORA...");
			
			methodAsync.processAsync(ConfigAsync.numPetitionCount);
			
			response.append("\nPETICIÓN EXITOSA - FUE ACTIVADO EL PROCESO ASINCRONO, VISUALICE LOS LOGS Y ESPERE CON CALMA A QUE FINALICE.");
			
		} catch (Exception e) {
			log.info("EXCEPTION: ERROR EN EL PROCESO.");
			response.append("\\nERROR AL EJECUTAR LOS PROCESOS. EXCEPTION GENERADA: ");
			response.append(e.getMessage());
		
		}
		
		return response;
	}

}
