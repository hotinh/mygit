package com.example.demomybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demomybatis.mapper.CityMapper;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class DemoMybatisApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoMybatisApplication.class, args);
	}
	
	final private CityMapper cityMapper;
	
	public DemoMybatisApplication(CityMapper cityMapper) {
		this.cityMapper = cityMapper;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("11=" + this.cityMapper.findByState("CA"));
	}
}
