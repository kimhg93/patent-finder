package com.finder.patent.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class MainVo {

    private String number;
    private String regDate;
    private String title;
    private String name;
    private String pubNum;
    private String pubDate;
    private String id;
    private int compCode;
    private String ipc;
    private String ipc2;
    private String price;
    private String phone;

}
