package com.example.demo.service.dairy.Impl;

import com.example.demo.mapper.bo.DairyBO;
import com.example.demo.mapper.dao.DairyDAO;
import com.example.demo.service.dairy.DairyService;
import com.example.demo.service.dairy.Do.AddDairyDo;
import com.example.demo.service.dairy.Do.DairyListDo;
import com.example.demo.service.dairy.Do.DairyResultDo;
import com.example.demo.service.dairy.Do.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jagi
 * @Date 2020/9/28
 */

@Service
public class DairyServiceImpl implements DairyService {
    @Resource
    DairyDAO dairyDAO;

    @Override
    public Result addDairy(AddDairyDo addDairyDo) {
        DairyBO dairyBO = new DairyBO();
        Result<String> resultDo = new Result<>();
        dairyBO.setTitle(addDairyDo.getTitle());
        dairyBO.setContent(addDairyDo.getContent());
        dairyBO.setLocation(addDairyDo.getLocation());
        dairyBO.setWeather(addDairyDo.getWeather());
        try{
            dairyDAO.insertDairy(dairyBO);
        } catch (Exception e){
            resultDo.setSuccess(false);
            resultDo.setData(e.toString());
            return resultDo;
        }
        resultDo.setSuccess(true);
        resultDo.setData("添加成功");
        return resultDo;
    }

    @Override
    public Result getDairy(String startDate, String endDate, Integer page, Integer pageSize) {
        List<DairyBO> dairyBOs = dairyDAO.getDairyByDate(startDate,endDate,page,pageSize);
        List<DairyResultDo> list = dairyBOs.stream()
                .map(this::Bo2Do).collect(Collectors.toList());
        DairyListDo dairyListDo = new DairyListDo();
        dairyListDo.setList(list);

        Long total = dairyDAO.getDairyTotalByDate(startDate,endDate);
        dairyListDo.setTotal(total);

        Result result = new Result();
        result.setSuccess(true);
        result.setData(dairyListDo);

        return result;

    }

    @Override
    public Result getDairyById(Long id) {
        DairyBO dairyBO = dairyDAO.getDairyById(id);
        Result result = new Result();
        if(dairyBO != null){
            DairyResultDo dairyResultDo = Bo2Do(dairyBO);
            result.setSuccess(true);
            result.setData(dairyResultDo);
        } else {
            result.setSuccess(false);
        }
        return result;
    }

    private DairyResultDo Bo2Do(DairyBO dairyBO){
        DairyResultDo dairyResultDo = new DairyResultDo();
        dairyResultDo.setId(dairyBO.getId());
        dairyResultDo.setTitle(dairyBO.getTitle());
        dairyResultDo.setContent(dairyBO.getContent());
        dairyResultDo.setCreateAt(dairyBO.getCreateAt());
        dairyResultDo.setLocation(dairyBO.getLocation());
        dairyResultDo.setIsShow(dairyBO.getIsShow());
        dairyResultDo.setWeather(dairyBO.getWeather());
        dairyResultDo.setTag1(dairyBO.getTag1());
        dairyResultDo.setTag2(dairyBO.getTag2());
        dairyResultDo.setTag3(dairyBO.getTag3());
        return dairyResultDo;
    }


}
