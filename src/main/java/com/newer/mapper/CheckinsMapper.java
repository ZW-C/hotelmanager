package com.newer.mapper;

import com.newer.domain.Checkins;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import java.util.List;

public interface CheckinsMapper {

    @Insert("insert into checkins values(null,#{name},#{gender},#{cardtype},#{cardno},#{roomid},#{num},null,1,now(),null)")
    int addCheckins (Checkins checkins);

    @Results(value = {@Result(property = "cid",column = "cid",id = true),
            @Result(property = "name",column = "name"),
            @Result(property = "gender",column = "gender"),
            @Result(property = "cardtype",column = "cardtype"),
            @Result(property = "cardno",column = "cardno"),
            @Result(property = "roomid",column = "roomid"),
            @Result(property = "num",column = "num"),
            @Result(property = "totalprice",column = "totalprice"),
            @Result(property = "cstate",column = "cstate"),
            @Result(property = "checkinTime",column = "checkinTime"),
            @Result(property = "leaveTime",column = "leaveTime"),

            @Result(property = "rooms",column = "roomid",javaType = com.newer.domain.Rooms.class,
                    one =@One(select = "com.newer.mapper.RoomsMapper.findByNo")
            )


    } )

    List<Checkins> findBycstate();


}
