package com.newer.test;

import com.newer.mapper.RoomsMapper;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class HotelTest {

    @Test
    public void testFind(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        RoomsMapper roomMapper =sqlSession.getMapper(RoomsMapper.class);
        roomMapper.findTypes().forEach(roomstype-> System.out.println(roomstype));
    }

    @Test
    public void testfindRoomIds(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        RoomsMapper roomMapper =sqlSession.getMapper(RoomsMapper.class);
        roomMapper.findRoomIds("双人间").forEach(roomstype-> System.out.println(roomstype));
    }

    @Test
    public void test1(){
        System.out.println("我在测试。。。");
    }

}
