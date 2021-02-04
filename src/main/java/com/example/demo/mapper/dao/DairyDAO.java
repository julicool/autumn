package com.example.demo.mapper.dao;

import com.example.demo.mapper.bo.DairyBO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Jagi
 * @Date 2020/9/25
 */

@Mapper
public interface DairyDAO {
    public void insertDairy(DairyBO dairyBO);
    public List<DairyBO> getDairyByDate(String startDate, String endDate, Integer page, Integer pageSize);
    public Long getDairyTotalByDate(String startDate, String endDate);
    public DairyBO getDairyById(Long id);
}
