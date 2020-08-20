package com.example.demo.mapper;

import java.util.List;

import com.example.demo.entity.Flight;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;
//AND DepartureTime= (CASE WHEN ${departuretime} IS NOT NULL THEN ${departuretime} ELSE DepartureTime END) AND ArriveTime= (CASE WHEN ${arrivetime} IS NOT NULL THEN ${arrivetime} ELSE ArriveTime END) 
//AND DepartAirportID= (CASE WHEN #{departid} IS NOT NULL THEN #{departid} ELSE AIRLINEID END) AND ArriveAirportID= (CASE WHEN #{arriveAirportid} IS NOT NULL THEN #{arriveAirportid} ELSE AIRLINEID END) 
@Mapper
public interface FlightMapper {
    final String search = "SELECT * FROM Flight WHERE AirlineID = (CASE WHEN #{airlineid} IS NOT NULL THEN #{airlineid} ELSE AIRLINEID END) AND DepartAirportID= (CASE WHEN #{departid} IS NOT NULL THEN #{departid} ELSE DepartAirportID END) AND ArriveAirportID= (CASE WHEN #{arriveAirportid} IS NOT NULL THEN #{arriveAirportid} ELSE ArriveAirportID END) AND DepartureTime= (CASE WHEN #{departuretime} IS NOT NULL THEN '${departuretime}' ELSE DepartureTime END)AND ArriveTime= (CASE WHEN #{arrivetime} IS NOT NULL THEN #{arrivetime} ELSE ArriveTime END) ";
  final String update = "UPDATE Flight SET AirlineID = #{airlineid}, DepartAirportID =#{departAirportid},ArriveAirportID = #{arriveAirportid}, DepartureTime = #{departuretime}, arrivetime=#{arrivetime} WHERE idflight = #{idFlight}";
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

@Delete("DELETE FROM Flight WHERE idFlight = #{id}")
boolean deleteFlightbyid(@Param("id") Integer id);

@Select(search)
List<Flight>searchFlight(@Param("airlineid" )Integer id,@Param("departid" )Integer departAirportid,@Param("arriveAirportid" )Integer arriveAirportid,
@Param("departuretime" )String departureTime,@Param("arrivetime" )String arriveTime);
}