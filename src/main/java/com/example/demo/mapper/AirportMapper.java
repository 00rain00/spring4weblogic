package com.example.demo.mapper;

import com.example.demo.entity.Airport;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface AirportMapper {
@Select("SELECT * FROM Airport WHERE idAirport = #{id}")
  Airport findById(@Param("id") Integer id);

  @Select("SELECT * FROM Airport WHERE AirportName = #{name}")
  Airport findByName(@Param("name") String name);

  @Select("SELECT * FROM Airport WHERE AirportCity = #{city}")
  Airport findByCity(@Param("city") String city);

  @Insert("INSERT INTO Airport (AirportName, AirportCity) values (#{name}, #{city})")
  @Options(useGeneratedKeys = true)
  Integer insertAirport(@Param("name") String name, @Param("city") String city);
}