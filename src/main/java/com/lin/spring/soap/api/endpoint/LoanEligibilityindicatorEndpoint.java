package com.lin.spring.soap.api.endpoint;

import com.lin.spring.soap.api.loaneligibility.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.lin.spring.soap.api.loaneligibility.Acknowledgement;
import com.lin.spring.soap.api.service.LoanEligibilityService;

@Endpoint
public class LoanEligibilityindicatorEndpoint {

	private static final String NAMESPACE = "http://www.lin.com/spring/soap/api/loanEligibility";
	@Autowired
	private LoanEligibilityService service;

	@PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
	@ResponsePayload
	public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
		return service.checkLoanEligibility(request);
	}

}
