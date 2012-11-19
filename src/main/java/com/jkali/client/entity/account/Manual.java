package com.jkali.client.entity.account;

import com.jkali.client.entity.AuditableEntity;



/**
 * 手动执行命令.
 * 
 * @author paul
 */

public class Manual extends AuditableEntity {
	private String code;
	private String name;
	private String path;
	private String lastuser;
	private String lasttime;
	private String remark;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getLastuser() {
		return lastuser;
	}

	public void setLastuser(String lastuser) {
		this.lastuser = lastuser;
	}

	public String getLasttime() {
		return lasttime;
	}

	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
