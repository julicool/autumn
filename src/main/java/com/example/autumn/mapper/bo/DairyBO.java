package com.example.autumn.mapper.bo;

import lombok.Data;

/**
 * @author Jagi
 * @Date 2020/9/25
 */

@Data
public class DairyBO {
    private Long id;
    private String title;
    private String content;
    private String createAt;
    private Integer isShow;
    private String location;
    private String weather;
    private String tag1;
    private String tag2;
    private String tag3;
}
