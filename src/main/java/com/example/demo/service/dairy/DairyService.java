package com.example.demo.service.dairy;

import com.example.demo.service.dairy.Do.AddDairyDo;
import com.example.demo.service.dairy.Do.Result;

/**
 * @author Jagi
 * @Date 2020/9/28
 */

public interface DairyService {
    public Result addDairy(AddDairyDo addDairyDo);
    public Result getDairy(String startDate, String endDate, Integer page, Integer pageSize);
    public Result getDairyById(Long id);
}
