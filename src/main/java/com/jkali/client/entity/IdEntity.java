package com.jkali.client.entity;

/**
 * 统一定义id的entity基类.
 * 
 * 
 * @author paul
 */
public abstract class IdEntity {

	protected Long mainid;

	

	public Long getMainid() {
		return mainid;
	}

	public void setMainid(Long mainid) {
		this.mainid = mainid;
	}
}