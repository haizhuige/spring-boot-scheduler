package com.neo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neo.RedisUtil;
import com.neo.bo.SysSchedule;
import com.neo.service.TranssactionSevice;

@Controller
public class TestController {
	@Autowired
	RedisUtil  redisUtil;
	@Autowired
	@Qualifier("TranssactionSeviceImpl")
	TranssactionSevice service;
	@Value("${cron.ex}")
	String cronEx;
	@RequestMapping("/couplet/removeRedi")
	@ResponseBody
	public String  setRedisMethod(){
		redisUtil.put("a", "b");
        return cronEx;
	}
	@RequestMapping("/couplet/getTest")
	@ResponseBody
	public String  setTest(){
        return "1234";
	}
	@RequestMapping("/updateState")
	@ResponseBody
	public String  updateState(){
		SysSchedule schedule=new SysSchedule();
		schedule.setId(1);
		schedule.setFlag("2");
		service.updateScheduleInfo(schedule);
        return "1234";
	}
}
