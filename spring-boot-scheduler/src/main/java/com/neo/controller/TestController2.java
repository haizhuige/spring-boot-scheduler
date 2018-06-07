package com.neo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neo.RedisUtil;

@Controller
public class TestController2 {
	@Autowired
	RedisUtil  redisUtil;
	@Value("${cron.ex}")
	String cronEx;
	@RequestMapping("/couplet/removeRedi2")
	@ResponseBody
	public String  setRedisMethod(){
		redisUtil.put("a", "b");
        return cronEx;
	}
}
