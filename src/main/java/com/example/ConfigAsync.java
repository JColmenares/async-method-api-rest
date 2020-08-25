package com.example;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

import com.example.model.AsyncApiModel;

@Configuration
@EnableAsync
public class ConfigAsync extends WsConfigurerAdapter implements Serializable {
	
	private static final long serialVersionUID = 1955677970876416417L;
	private static Logger log = LoggerFactory.getLogger(AsyncApiModel.class);
	
	public static int numPetitionCount = 0;

	@Bean(name = "asyncExecutor")
	public TaskExecutor asyncExecutor() {
		
		log.info("CARGA DE BEAM DE CONFIGURACIÓN ASINCRONOS");
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(3);
		executor.setMaxPoolSize(3);
		executor.setQueueCapacity(100);
		executor.setThreadNamePrefix("ASYNCHTHREAD-");
		executor.initialize();
		return executor;
	}
	
	//Metodo para imprimer nombre de los metodos a usar
	public static String getNameMethod() {
		return new Exception().getStackTrace()[1].getMethodName();
	}

}
