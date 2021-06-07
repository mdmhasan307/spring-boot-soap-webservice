package com.javatechie.spring.soap.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javatechie.spring.soap.api.loaneligibility.Acknowledgement;
import com.javatechie.spring.soap.api.loaneligibility.CustomerRequest;

@Service
public class LoanEligibilityService {

	public Acknowledgement checkLoanEligibility(CustomerRequest request) {
		Acknowledgement response = new Acknowledgement();
		//CompanyResponse response=new CompanyResponse();
		List<String> mismatchCriteriaList= response.getCriteriaMismatch();
		if(!(request.getAge()>30&&request.getAge()<=60)){
			mismatchCriteriaList.add("Person age should be in between 30 to 60");
		}

		if(!(request.getYearlyIncome()>=200000)){
			mismatchCriteriaList.add("Minimum yearly income should be at least 200000");
		}

		if(!(request.getCibilScore()>=500)){
			mismatchCriteriaList.add("Low credit score please try after 6 months");
		}

		if(mismatchCriteriaList.size()>0){
			response.setIsEligible(false);
			response.setApprovedAmount(0);
		}
		else {
			response.setIsEligible(true);
			response.setApprovedAmount((long) ( request.getYearlyIncome()*(0.80)));
			mismatchCriteriaList.clear();
		}


		return response;

		//return acknowledgement;

	}

}
