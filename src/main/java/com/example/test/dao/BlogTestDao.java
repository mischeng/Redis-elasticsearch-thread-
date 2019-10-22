package com.example.test.dao;

import com.example.test.modle.BlogDocument;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface BlogTestDao {
    @Insert("insert into BlogDocument(id,name,content) value(#{id},#{name},#{content})")
    public void add(BlogDocument blogDocument);
    @Delete("delete from BlogDocument where id=#{id}")
    public void delete(long id);
    @Update("update BlogDocument set name=#{name},content=#{content} where id=#{id}")
    public void edit(BlogDocument blogDocument);
    @Select("select * from BlogDocument where id=#{id}")
    public BlogDocument getBlogDocument(long id);
    @Select("select * from BlogDocument")
    public List<BlogDocument>getAlldocument();
}
