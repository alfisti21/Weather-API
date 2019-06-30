package com.example.demo2;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
@Data
@Entity
class Temperatures {

	private @Id @GeneratedValue Long id;
	private int minTemp;
	private int maxTemp;
	private String advice;
	
	public Temperatures() {}

  Temperatures(int minTemp, int maxTemp, String advice) {
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
		this.advice = advice;
	}
}