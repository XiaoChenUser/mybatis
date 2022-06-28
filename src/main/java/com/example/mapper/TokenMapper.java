package com.example.mapper;

import com.example.dto.TokenDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TokenMapper {
    List<TokenDTO> getAll();

    Integer add(TokenDTO tokenDTO);

    void addBatch(List<TokenDTO> tokenDTOList);
}
