package com.jkali.client.entity;

import java.util.ArrayList;
import java.util.List;

public class Filter {
	
	private String groupOp;
	private List<Rule> rules = new ArrayList<>();// 有序的关联对象集合

	public String getGroupOp() {
		return groupOp;
	}

	public void setGroupOp(String groupOp) {
		this.groupOp = groupOp;
	}

	public List<Rule> getRules() {
		return rules;
	}

	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}

}
