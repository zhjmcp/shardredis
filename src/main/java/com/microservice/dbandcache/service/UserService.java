package com.microservice.dbandcache.service;

import com.alibaba.fastjson.JSON;
import com.microservice.dbandcache.common.DbAndCacheContants;
import com.microservice.dbandcache.dao.UserDao;
import com.microservice.dbandcache.model.User;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.microservice.dbandcache.util.RedisUtil;
@Service
public class UserService {
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private UserDao userDao;
	
	public User getUser(long id){
		String userStr=redisUtil.get(DbAndCacheContants.USER_CACHE_PREFIX+id);
		if(StringUtils.isNotBlank(userStr)){
			return JSON.parseObject(userStr,User.class);
		}
		User user=userDao.selectByPrimaryKey(id);
		if(user!=null){
			redisUtil.set(DbAndCacheContants.USER_CACHE_PREFIX+id, JSON.toJSONString(user));
		}
		return user;
	}
	
}
