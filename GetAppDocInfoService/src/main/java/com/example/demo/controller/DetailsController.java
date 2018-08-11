package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AppDocInfo;
import com.example.demo.service.GetAppDocInfoService;

@Component
@RestController
public class DetailsController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private GetAppDocInfoService appDocInfoService;

	@GetMapping(value = "/getAppDocInfoList")
	public List<AppDocInfo> getAppDocInfoList() {
		return appDocInfoService.getAppDocInfoList();
	}

	@GetMapping(value = "/get")
	public AppDocInfo getAppDocInfo(@RequestHeader HttpHeaders headers) {
		logger.info("Calling get service to fetch the App id and Doc Id");
		List<String> app_idList = headers.get("application-id");
		List<String> doc_idList = headers.get("document-id");
		AppDocInfo docInfo = new AppDocInfo();
		docInfo.setApplication_id(Long.valueOf(app_idList.get(0)));
		docInfo.setDocument_id(Long.valueOf(doc_idList.get(0)));
		AppDocInfo docInfoExisted = appDocInfoService.findByApplication_Id(docInfo);
		return docInfoExisted;
	}

}
