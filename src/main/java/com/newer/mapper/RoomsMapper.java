package com.newer.mapper;

import com.newer.domain.Rooms;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoomsMapper {

    @Select("select distinct roomtype from rooms")
    List<String> findTypes();
    @Select("select roomid from rooms where roomtype=#{roomtype} and state=1")
    List<Integer> findRoomIds (@Param("roomtype") String roomtype);


    @Select("select * from Checkins where roomid=#{roomid}")
    Rooms findByNo(@Param("roomid") int roomid);



}
