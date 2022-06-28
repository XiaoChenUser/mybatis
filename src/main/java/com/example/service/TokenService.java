package com.example.service;

import com.example.dto.TokenDTO;
import com.example.mapper.TokenMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TokenService {
    private final TokenMapper tokenMapper;

    public TokenService(TokenMapper tokenMapper) {
        this.tokenMapper = tokenMapper;
    }

    //PageHelper.startPage(); 之后紧跟着的 SQL 查询语句，会被自动应用分页查询
    //SQL 将被自动拼接上 LIMIT ?,?
    public List<TokenDTO> getTokenByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return tokenMapper.getAll();
    }

    //可以将 list 用 PageInfo 包裹，获取包括总数量 total 在内的额外信息
    public PageInfo<TokenDTO> getPageInfo(int pageNum, int pageSize){
        List<TokenDTO> tokens = getTokenByPage(pageNum, pageSize);
        return new PageInfo<>(tokens);
    }
}
