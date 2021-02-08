package com.example.autumn.service.dairy.Do;

import lombok.Data;

/**
 * @author Jagi
 * @Date 2020/9/28
 */
@Data
public class AddDairyDo {

    // 文章标题
    private String title;

    // 文章内容
    private String content;

    // 文章是否显示
    private Integer isShow;

    // 写作地点
    private String location;

    // 当时天气
    private String weather;

    // 标签
    private String tag1;
    private String tag2;
    private String tag3;
}
