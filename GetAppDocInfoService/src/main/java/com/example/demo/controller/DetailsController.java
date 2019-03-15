package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AppDocInfo;

@Component
@RestController
public class DetailsController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping(value = "/get")
	public String getAppDocInfo(@RequestHeader HttpHeaders headers) {
		return "Hi I am from getService/get, Happy to Help you.";
	}

}
