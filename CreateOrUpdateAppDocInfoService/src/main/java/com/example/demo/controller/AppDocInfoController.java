package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
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
		ResponseEntity<AppDocInfo> result = restTemplate.exchange(URL, HttpMethod.GET, entity, AppDocInfo.class);
		logger.info("<Result from GetAppDocService>" + result.getBody());
		AppDocInfo docInfoExisted = result.getBody();
		String res = null;
		if (docInfoExisted != null) {
			res = "Updated the existing row successfully." + "\n" + "This is the Application info "
					+ appDocInfo.getApplication_name() + " - " + appDocInfo.getApplication_id() + " And"
					+ " This is the Document info " + appDocInfo.getDocument_name() + " - "
					+ appDocInfo.getDocument_id();
			appDocInfo.setId(docInfoExisted.getId());
		} else {
			res = "This is The New Application Document Info, There are no existed rows on the input, so Created new row successfully.";
		}
		appDocInfoService.updateAppDocInfo(appDocInfo);
		return res;
	}
}
