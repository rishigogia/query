package com.tsubaka.query.service;

import com.tsubaka.query.serviceobject.VmArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

@Service("vmArgsService")
public class VmArgsService {

	private List<VmArgs> vmArgsList;

	@Autowired
	public void setVmArgsList(List<VmArgs> vmArgsList) {
		this.vmArgsList = vmArgsList;
	}

	public boolean validateRequiredArguments() {
		boolean allRequiredArgsPresent = true;

		Properties systemProps = System.getProperties();
		for(VmArgs vmArgs:vmArgsList) {
			if(vmArgs.isRequired() && !systemProps.containsKey(vmArgs.getArgName())) {
				allRequiredArgsPresent = false;
				break;
			}
		}
		return allRequiredArgsPresent;
	}
}
