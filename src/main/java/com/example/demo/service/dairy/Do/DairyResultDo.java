package com.example.demo.service.dairy.Do;

import lombok.Data;

/**
 * @author Jagi
 * @Date 2020/10/13
 */

@Data
public class DairyResultDo {
    private Long id;
    private String title;
    private String content;
    private Integer isShow;
    private String createAt;
    private String location;
    private String weather;
    private String tag1;
    private String tag2;
    private String tag3;
}
