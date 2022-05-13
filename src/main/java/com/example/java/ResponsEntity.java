package com.example.java;

import java.util.List;

public class ResponsEntity {
    public List<UserEntity> users;
    public Integer pageNumber;
    public Integer pagesCount;
    public Integer pageSize;
    public Integer totalCount;

    public ResponsEntity(List <UserEntity> users, Integer pagNumber, Integer pagesCount,Integer pageSize,Integer totalCount){
        this.users= users;
        this.pageNumber= pagNumber;
        this.pagesCount= pagesCount;
        this.pageSize= pageSize;
        this.totalCount= totalCount;


    }
}
