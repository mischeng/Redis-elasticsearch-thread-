package com.example.test.service;

import com.example.test.dao.BlogTestDao;
import com.example.test.modle.BlogDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogTestService {
    @Autowired
    private BlogTestDao blog_test_dao;
    public void add(BlogDocument blogDocument){
        this.blog_test_dao.add(blogDocument);
    }
    public List<BlogDocument>getAlldocument(){
        return this.blog_test_dao.getAlldocument();
    }
    public void delete(long id){
        this.blog_test_dao.delete(id);
    }
    public void edit(BlogDocument blogDocument){
       this.blog_test_dao.edit(blogDocument);
    }
    public BlogDocument getBlogDocument(long id){
        return this.blog_test_dao.getBlogDocument(id);
    }
}
