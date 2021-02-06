package com.example.autumn.controller;

import com.example.autumn.service.dairy.DairyService;
import com.example.autumn.service.dairy.Do.AddDairyDo;
import com.example.autumn.service.dairy.Do.Result;
import com.example.autumn.utils.FileUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author Jagi
 * @Date 2020/10/2
 */
@Slf4j
@RestController
public class DairtController
{
    @Resource
    DairyService dairyService;

    @Value("${web.upload-path}")
    private String path;

    @Value("${web.image-path}")
    private String imagePath;

    @ApiOperation("添加日记")
    @RequestMapping(value = "/addDairy", method = RequestMethod.POST)
    public Result addDairy(@RequestBody AddDairyDo addDairyDo){
        log.info("addDairy入参是：{}",addDairyDo);
        return dairyService.addDairy(addDairyDo);
    }

    @ApiOperation("获取日记列表")
    @RequestMapping(value = "/getDairy", method = RequestMethod.GET)
    public Result getDairies(@RequestParam(value = "startDate",required = false) String startDate, @RequestParam(value = "endDate") String endDate, @RequestParam(value = "page") Integer page, @RequestParam(value = "pageSize") Integer pageSize){
        log.info("getDairies入参是{},{},{},{}",startDate,endDate,page,pageSize);
        return dairyService.getDairy(startDate,endDate,page,pageSize);
    }

    @RequestMapping(value = "/getDairyById", method = RequestMethod.GET)
    public Result getDairyById(@RequestParam(value = "id") Long id){
        log.info("getDairyById入参是：{}",id);
        return dairyService.getDairyById(id);
    }

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public String uploadImage(@RequestParam(value = "file") MultipartFile file){
        if (file != null){
            return imagePath + FileUtil.upload(file,path,file.getOriginalFilename());
        }
        else {
            return null;
        }
    }


}
