package com.test;


import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;

import jakarta.servlet.http.HttpServletRequest;

public class RadioTestVM {
	private String workOnType;
	private String workOffType;
	
	private String source;
	private String queryType;
	
	@Init
	public void init() {
		this.setWorkOnType("2");
		
		this.setWorkOffType("1");
		
		HttpServletRequest request = (HttpServletRequest) Executions.getCurrent().getNativeRequest();
		source = request.getParameter("source");
		queryType = request.getParameter("queryType");
		System.out.println(request.getRequestURI());
		System.out.println(request.getQueryString());
		
		Map<String, String> paramMap = genParameterMapByQueryString(request.getQueryString());
		if(paramMap != null) {
			for (Map.Entry<String, String> entry : paramMap.entrySet()) {
				System.out.println("key:"+entry.getKey()+", value:"+entry.getValue());
			}
		}
		
		source = paramMap.get("source");
		queryType = paramMap.get("queryType");
	}
	
	private Map<String, String> genParameterMapByQueryString(String queryString) {
		Map<String, String> result = new HashMap<String, String>();
		if(StringUtils.isNotEmpty(queryString)) {
			queryString = StringUtils.replace(queryString, "&amp;", "&");
			String[] tokens = queryString.split("&");
			if(tokens != null && tokens.length > 0) {
				String[] tempKeyValueTokens;
				for(String token : tokens) {
					tempKeyValueTokens = token.split("=");
					if(tempKeyValueTokens != null && tempKeyValueTokens.length > 1 && result.get(tempKeyValueTokens[0]) == null) {
						result.put(tempKeyValueTokens[0], tempKeyValueTokens[1]);
					}
				}
			}
		}
		return result;
	}
	
	@Command
	public void onClickBtn() {
		String url = "index.zul?queryType=ACTIVE&source=ZK";
		
		Executions.getCurrent().sendRedirect(url);
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
