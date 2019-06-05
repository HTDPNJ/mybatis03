package com.hfut.mapper;

import com.hfut.pojo.Log;

import java.util.List;

public interface LogMapper {
    List<Log> selAll();

    List<Log> selByAccInAccout(String accin,String accout);
}
