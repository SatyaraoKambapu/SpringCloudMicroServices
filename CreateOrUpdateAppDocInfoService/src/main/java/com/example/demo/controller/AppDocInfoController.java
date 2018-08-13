package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.AppDocInfo;
import com.example.demo.service.AppDocInfoService;

@Component
@RestController
public class AppDocInfoController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	String service_url = "http://localhost:8088";

	@Autowired
	private AppDocInfoService appDocInfoService;

	@PostMapping(value = "/addAppDocInfo")
	public String addAppDocInfo(@RequestBody AppDocInfo appDocInfo) {
		logger.info(appDocInfo.toString());
		appDocInfoService.addAppDocInfo(appDocInfo);
		return "Created new row successfully.";
	}

	@PutMapping(value = "/update")
	public String updateAppDocInfo(@RequestHeader HttpHeaders headers, @RequestBody AppDocInfo appDocInfo) {
		logger.info("<Application-id>" + headers.get("application-id"));
		headers.set("application-id", String.valueOf(appDocInfo.getApplication_id()));
		headers.set("document-id", String.valueOf(appDocInfo.getDocument_id()));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		String URL = service_url + "/get";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> result = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
		logger.info("<Result from GetAppDocService>" + result.getBody());
		String resultFromService2 = result.getBody();
		appDocInfoService.updateAppDocInfo(appDocInfo);
		return resultFromService2;
	}

	@GetMapping(value = "/getAppDocInfoList")
	public List<AppDocInfo> getAppDocInfoList() {
		return appDocInfoService.getAppDocInfoList();
	}
}
