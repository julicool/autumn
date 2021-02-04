package com.example.demo.service.dairy.Do;

import lombok.Data;

/**
 * @author Jagi
 * @Date 2020/9/28
 */
@Data
public class AddDairyDo {
    private String title;
    private String content;
    private Integer isShow;
    private String location;
    private String weather;
    private String tag1;
    private String tag2;
    private String tag3;
}
