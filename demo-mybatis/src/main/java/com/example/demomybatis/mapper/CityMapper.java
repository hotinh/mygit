package com.example.demomybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demomybatis.domain.City;

/**
 * @author Eddú Meléndez
 */
@Mapper
public interface CityMapper {

	@Select("select * from city_demo where state = #{state}")
	City findByState(@Param("state") String state);

}
