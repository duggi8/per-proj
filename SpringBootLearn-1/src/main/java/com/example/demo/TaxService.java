package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
public class TaxService {

	public String getBracket(int income){
		if(income<1000)
			return "LOW";
		else if(income<5000)
			return "MEDIUM";
		else
			return "HIGH";
	}
	
	public List<String> allBrackets(){
		String[] s = {"LOW","MEDIUM","HIGH"};
		return new ArrayList<String>(Arrays.asList(s));
	}
	
}
