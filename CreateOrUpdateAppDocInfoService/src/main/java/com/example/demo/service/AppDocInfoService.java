package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AppDocInfo;
import com.example.demo.repository.AppDocInfoRepository;

@Service
public class AppDocInfoService {

	@Autowired
	AppDocInfoRepository appDocInfoRepository;

	public List<AppDocInfo> getAppDocInfoList() {
		List<AppDocInfo> list = new ArrayList<>();
		appDocInfoRepository.findAll().forEach(list::add);
		return list;

	}

	public void addAppDocInfo(AppDocInfo appDocInfo) {
		appDocInfoRepository.save(appDocInfo);
	}

	@Modifying
	public void updateAppDocInfo(AppDocInfo appDocInfo) {
		appDocInfoRepository.save(appDocInfo);
	}

}
