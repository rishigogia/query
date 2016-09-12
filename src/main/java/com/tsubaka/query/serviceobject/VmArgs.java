package com.tsubaka.query.serviceobject;

import org.springframework.beans.factory.annotation.Autowired;

public class VmArgs {
	private String argName;
	private boolean required;

	@Autowired
	public void setArgName(String argName) {
		this.argName = argName;
	}

	@Autowired
	public void setRequired(boolean required) {
		this.required = required;
	}

	public String getArgName() {
		return argName;
	}

	public boolean isRequired() {
		return required;
	}
}
