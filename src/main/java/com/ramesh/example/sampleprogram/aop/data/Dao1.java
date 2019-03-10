package com.ramesh.example.sampleprogram.aop.data;
import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {
	
	public String retrieveSomething(){
		return "Dao1";
	}

}