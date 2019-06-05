package com.hfut.test;

import com.hfut.mapper.LogMapper;
import com.hfut.pojo.Log;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        InputStream is= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        SqlSession session=factory.openSession();
        LogMapper logMapper=session.getMapper(LogMapper.class);
        List<Log> list=logMapper.selAll();
        for(Log log:list){
            System.out.println(log);
        }

        System.out.println("根据转入转出账户查询");
        list=logMapper.selByAccInAccout(3+"",1+"");
        for(Log log:list){
            System.out.println(log);
        }
        session.close();
        System.out.println("程序执行结束");
    }
}
