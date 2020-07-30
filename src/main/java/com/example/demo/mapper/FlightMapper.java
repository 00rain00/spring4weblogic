package com.example.demo.mapper;

import java.util.List;

import com.example.demo.entity.Flight;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;
@Mapper
public interface FlightMapper {
    final String update = "update Flight set AirlineID = #{airlineid}, DepartAirportID =#{departAirportid},ArriveAirportID = #{arriveAirportid}, DepartureTime = #{departuretime}, arrivetime=#{arrivetime} WHERE idflight = #{idFlight}";
@Select("SELECT * FROM Flight WHERE idFlight = #{id}")
  Flight findById(@Param("id") Integer id);

@Select("SELECT * FROM Flight")
  List<Flight> findAll();

@Insert("insert into Flight (AirlineID, DepartAirportID, ArriveAirportID, DepartureTime, ArriveTime) values (#{airlineid},#{departid},#{arriveid},#{departtime},#{arrivetime})")
@Options(useGeneratedKeys = true)
Integer insertFlight(@Param("airlineid" )Integer id,@Param("departid" )Integer departAirportid,@Param("arriveid" )Integer arriveAirportid,
	@Param("departtime" )String departureTime,@Param("arrivetime" )String arriveTime);


@Update(update)
Integer updateFlight(Flight flight);
}