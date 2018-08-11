package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.AppDocInfo;
import com.example.demo.service.GetAppDocInfoService;

public class GetAppDocInfoRepositoryCustomImpl implements GetAppDocInfoRepositoryCustom {

	@Autowired
	GetAppDocInfoService appDocInfoService;

	@Override
	public AppDocInfo findByApplication_Id(AppDocInfo appDocInfoToUpdate) {
		List<AppDocInfo> appDocInfoList = appDocInfoService.getAppDocInfoList();
		for (AppDocInfo appDocInfo : appDocInfoList) {
			if (appDocInfo.getApplication_id() == appDocInfoToUpdate.getApplication_id()
					&& appDocInfo.getDocument_id() == appDocInfoToUpdate.getDocument_id()) {
				return appDocInfo;
			}else if(appDocInfo.getApplication_id() == appDocInfoToUpdate.getApplication_id()) {
				return appDocInfo;
			}else if(appDocInfo.getDocument_id() == appDocInfoToUpdate.getDocument_id()) {
				return appDocInfo;
			}
		}
		return null;
	}

}
