package com.hxs.web.mapper;

import com.hxs.web.entity.Dept;
import com.hxs.web.entity.Emp;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptMapper {

    public Dept findDeptById(Integer dno);
}
