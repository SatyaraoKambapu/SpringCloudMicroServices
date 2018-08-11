package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AppDocInfo;
import com.example.demo.repository.GetAppDocInfoRepository;

@Service
public class GetAppDocInfoService {

	@Autowired
	GetAppDocInfoRepository appDocInfoRepository;

	public List<AppDocInfo> getAppDocInfoList() {
		List<AppDocInfo> list = new ArrayList<>();
		appDocInfoRepository.findAll().forEach(list::add);
		return list;
	}

	public AppDocInfo findByApplication_Id(AppDocInfo appDocInfo) {
		return appDocInfoRepository.findByApplication_Id(appDocInfo);
	}
}
