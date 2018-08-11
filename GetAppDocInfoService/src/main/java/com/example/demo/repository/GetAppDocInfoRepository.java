package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.AppDocInfo;

public interface GetAppDocInfoRepository extends CrudRepository<AppDocInfo, Integer>, GetAppDocInfoRepositoryCustom {

}
