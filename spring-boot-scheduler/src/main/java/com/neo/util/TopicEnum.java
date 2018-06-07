package com.neo.util;

public enum TopicEnum {
    UPDATE_SCHEDULE_FLAG_TOPIC("topic1","修改定时任务标识符主题");
	private String state;
	private String value;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	private TopicEnum(String state, String value) {
		this.state = state;
		this.value = value;
	}
	
}
