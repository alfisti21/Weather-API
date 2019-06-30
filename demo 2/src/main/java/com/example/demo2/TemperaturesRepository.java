package com.example.demo2;

import org.springframework.data.jpa.repository.JpaRepository;

interface TemperaturesRepository extends JpaRepository<Temperatures, Long> {
	
}