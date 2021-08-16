package com.example.dto;

import lombok.Data;

import java.util.List;

@Data
public class BlogDTO {
    private Integer id;
    private String title;
    private AuthorDTO author;
    private AuthorDTO coAuthor;
    private List<CommentDTO> comments;

    public BlogDTO() {
    }

    public BlogDTO(String title, AuthorDTO author) {
        this.title = title;
        this.author = author;
    }
}
