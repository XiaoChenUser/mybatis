package com.example;

import com.alibaba.fastjson.JSON;
import com.example.dto.AuthorDTO;
import com.example.dto.BlogDTO;
import com.example.dto.CommentDTO;
import com.example.dto.UserDTO;
import com.example.mapper.BlogMapper;
import com.example.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class MybatisDemoApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(MybatisDemoApplicationTests.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BlogMapper blogMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void testInsert() {
        UserDTO user = new UserDTO().setUsername(UUID.randomUUID().toString())
                .setPassword("nicai").setCreateTime(new Date());
        userMapper.insert(user);
    }

    @Test
    public void testUpdateById() {
        UserDTO updateUser = new UserDTO().setId(4)
                .setPassword("wobucai");
        userMapper.updateById(updateUser);
    }

    @Test
    public void testDeleteById() {
        userMapper.deleteById(5);
    }

    @Test
    public void testSelectById() {
        userMapper.selectById(6);
    }

    @Test
    public void testSelectByUsername() {
        userMapper.selectByUsername("yunai");
    }

    @Test
    public void testSelectByIds() {
        List<UserDTO> users = userMapper.selectByIds(Arrays.asList(4,5,6,7));
        System.out.println("users：" + users.size());
    }

    @Test
    public void testAddBlog(){
        AuthorDTO author = new AuthorDTO();
        author.setId(1);
        BlogDTO blogDTO = new BlogDTO("悲惨世界", author);
        BlogDTO blogDTO1 = new BlogDTO("巴黎圣母院", author);
        blogMapper.addBlog(blogDTO);
        blogMapper.addBlog(blogDTO1);

        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(2);
        BlogDTO blogDTO2 = new BlogDTO("老人与海", authorDTO);
        blogMapper.addBlog(blogDTO2);
    }

    @Test
    public void testAddCoAuthor(){
        AuthorDTO coAuthor = new AuthorDTO();
        coAuthor.setId(1);
        blogMapper.addCoAuthor(3, 1);
    }

    @Test
    public void testAddAuthor(){
        AuthorDTO authorDTO = new AuthorDTO("雨果", "abc", "abc@gmail.com");
        AuthorDTO authorDTO1 = new AuthorDTO("海明威", "hmw", "hmw@gmail.com");
        blogMapper.addAuthor(authorDTO);
        blogMapper.addAuthor(authorDTO1);
    }

    @Test
    public void testAddComment(){
        CommentDTO commentDTO = new CommentDTO().setUsername("Meng ment").setComment("Very good!").setCommentTime(new Date());
        CommentDTO commentDTO2 = new CommentDTO().setUsername("Zhang san").setComment("delicious.").setCommentTime(new Date());
        blogMapper.addComment(1, commentDTO);
        blogMapper.addComment(3, commentDTO2);

    }

    @Test
    public void testSelectBlog(){
        for (int i = 0; i < 5; i++) {
            BlogDTO blogDTO = blogMapper.selectBlog(i);
            if (blogDTO != null) {
                logger.info(JSON.toJSONString(blogDTO));
            }
        }
    }
    
}
