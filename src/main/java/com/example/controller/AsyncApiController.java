package com.example.controller;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.AsyncApiModel;

@RestController
@RequestMapping(value="/v1")
public class AsyncApiController implements Serializable{

	private static final long serialVersionUID = -297670238332336927L;
	private static Logger log = LoggerFactory.getLogger(AsyncApiController.class);

	@Autowired
	private AsyncApiModel methods;
	
	@RequestMapping(value="/hello-world-async", method = RequestMethod.GET)
	public String getApiv1(@RequestHeader String nameUser,@RequestHeader boolean isMen) throws Exception {
		
		log.info("Iniciando proceso de api Rest");
		
		return methods.getRestModel(nameUser,isMen);
		
	}
}
