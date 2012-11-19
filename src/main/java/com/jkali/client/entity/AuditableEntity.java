package com.jkali.client.entity;

import java.util.Date;

/**
 * 含审计信息的Entity基类.
 * 
 * @author paul
 */

public abstract class AuditableEntity extends IdEntity {

	protected Date recAddTime;
	protected String recLoginUser;
	protected Date recUpdateTime;
	protected String recModifyUser;
	
	protected int companyId = -1;
	protected int systemId = -1;

	
	public Date getRecAddTime() {
		return recAddTime;
	}

	public void setRecAddTime(Date recAddTime) {
		this.recAddTime = recAddTime;
	}

	public String getRecLoginUser() {
		return recLoginUser;
	}

	public void setRecLoginUser(String recLoginUser) {
		this.recLoginUser = recLoginUser;
	}

	/**
	 * 最后修改时间.
	 */
	// 本属性只在update时有效,save时无效.
	public Date getRecUpdateTime() {
		return recUpdateTime;
	}

	public void setRecUpdateTime(Date recUpdateTime) {
		this.recUpdateTime = recUpdateTime;
	}

	/**
	 * 最后修改的操作员的登录名.
	 */
	public String getRecModifyUser() {
		return recModifyUser;
	}

	public void setRecModifyUser(String recModifyUser) {
		this.recModifyUser = recModifyUser;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getSystemId() {
		return systemId;
	}

	public void setSystemId(int systemId) {
		this.systemId = systemId;
	}
}
