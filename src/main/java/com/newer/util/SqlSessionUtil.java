package com.newer.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class SqlSessionUtil {

    //用于生成数据库连接会话对象的工厂对象
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //读取主配置文件
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            //初始化连接工厂对象
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    //获取数据库连接会话对象
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

    /**
     * 释放内存，关闭资源
     * @param sqlSession
     */
    public static void close(SqlSession sqlSession){
        if(sqlSession!=null){
            sqlSession.close();
        }
    }

}
