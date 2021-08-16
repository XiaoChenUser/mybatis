package com.example.mapper;

import com.example.dto.AuthorDTO;
import com.example.dto.BlogDTO;
import com.example.dto.CommentDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogMapper {
    void addBlog(BlogDTO blogDTO);

    void addCoAuthor(@Param("blogId") Integer blogId, @Param("coAuthorId") Integer coAuthorId);

    void addAuthor(AuthorDTO authorDTO);

    void addComment(@Param("id") Integer id, @Param("commentDTO") CommentDTO commentDTO);

    BlogDTO selectBlog(@Param("id") Integer id);
}
