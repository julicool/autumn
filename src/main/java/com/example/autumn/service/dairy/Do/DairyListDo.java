package com.example.autumn.service.dairy.Do;

import lombok.Data;

import java.util.List;

/**
 * @author Jagi
 * @Date 2020/9/28
 */
@Data
public class DairyListDo {
    List<DairyResultDo> list;
    Long total;
}
