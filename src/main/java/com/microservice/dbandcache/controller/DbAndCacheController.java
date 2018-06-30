package com.microservice.dbandcache.controller;

import com.microservice.dbandcache.model.User;
import com.microservice.dbandcache.service.UserService;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import org.springframework.http.converter.StringHttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
@Api("user相关api")
@RestController
@RequestMapping("/user")
public class DbAndCacheController {
	@Autowired
	private UserService userService;
	
	@ApiOperation("根据ID获取用户信息")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType="query",name="id",dataType="long",required=true,value="用户的id",defaultValue="1")
	})
	@ApiResponses({
		@ApiResponse(code=401,message="权限校验不通过")
	})
	@RequestMapping(value="/getUserInfo",method=RequestMethod.GET)
	public User getUserInfo(@RequestParam("id") long id){
		return userService.getUser(id);
	}
}
