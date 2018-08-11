package com.example.demo.repository;

import com.example.demo.entity.AppDocInfo;

public interface GetAppDocInfoRepositoryCustom {

	AppDocInfo findByApplication_Id(AppDocInfo appDocInfo);
}
