package com.hxs.web.mapper;

import com.hxs.web.entity.Emp;
import com.hxs.web.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface EmpMapper {
    public Emp findUserById(Integer no);
}
