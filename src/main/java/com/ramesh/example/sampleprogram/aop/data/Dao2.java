package com.ramesh.example.sampleprogram.aop.data;

import org.springframework.stereotype.Repository;

@Repository
public class Dao2 {

	public String retrieveSomething(){
		return "Dao2";
	}

}