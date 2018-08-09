package com.basic.http.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/ouminasoft")
public class BasicHttpWebServerController {
	@RequestMapping(value="/basic/server", method=RequestMethod.GET)
	public @ResponseBody String isServerStart(){
		return "server start up ok ";
	}

}



