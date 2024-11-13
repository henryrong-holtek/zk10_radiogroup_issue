package com.test;


import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

public class RadioTestVM {
	private String workOnType;
	private String workOffType;
	
	private String source;
	private String queryType;
	
	@Init
	public void init() {
		this.setWorkOnType("2");
		
		this.setWorkOffType("1");
	}
	
	@Command
	@NotifyChange("*")
	public void onChangeOnGrp() {
	}
	
	@Command
	@NotifyChange("*")
	public void onChangeOffGrp() {
	}

	public String getWorkOnType() {
		return workOnType;
	}
	public void setWorkOnType(String workOnType) {
		this.workOnType = workOnType;
	}
	public String getWorkOffType() {
		return workOffType;
	}
	public void setWorkOffType(String workOffType) {
		this.workOffType = workOffType;
	}

	// 是否需要簽到
	public boolean isNeedRegWorkOn() {
		return false;
	}

	// 是否需要簽退
	public boolean isNeedRegWorkOff() {
		return false;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
}
