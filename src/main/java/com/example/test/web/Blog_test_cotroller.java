package com.example.test.web;


import com.example.test.modle.BlogDocument;
import com.example.test.service.BlogDocumentService;
import com.example.test.service.BlogTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Max;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Controller
public class Blog_test_cotroller {
    @Autowired
    private BlogTestService blog_test_service;
    @Autowired
    private BlogDocumentService blogDocumentService;

    com.example.test.web.BlogDocunemtController blogDocunemtController=new com.example.test.web.BlogDocunemtController();
    @RequestMapping("/add")
    public void add(BlogDocument blogDocument, HttpServletResponse response) throws Exception {
        this.blog_test_service.add(blogDocument);
        System.out.println(blogDocument.getId());
        this.blogDocumentService.saveDocument(blogDocument);
        Writer out=response.getWriter();

        response.setCharacterEncoding("utf-8");

        out.write("添加成功");
    }
    @RequestMapping("/delete")
    public void delete(long id, HttpServletResponse response) throws IOException {
        this.blog_test_service.delete(id);
        this.blogDocumentService.delete(id);
        Writer out=response.getWriter();
        response.setCharacterEncoding("utf-8");
        out.write("删除成功");
    }
    @RequestMapping("/edit")
    public void edit(BlogDocument blogDocument,HttpServletResponse response) throws Exception {
        System.out.println(blogDocument.getId());
        this.blog_test_service.edit(blogDocument);
        blogDocument=this.blog_test_service.getBlogDocument(blogDocument.getId());
        this.blogDocumentService.delete(blogDocument.getId());
        this.blogDocumentService.saveDocument(blogDocument);
        Writer out=response.getWriter();
        response.setCharacterEncoding("utf-8");

        out.write("编辑成功");
    }
    @RequestMapping("/getAll")
    public void getAlldocument(HttpServletResponse response) throws IOException {
        List<BlogDocument> blogDocument=this.blog_test_service.getAlldocument();
        this.blogDocumentService.saveAll(blogDocument);
        response.setCharacterEncoding("utf-8");
        Writer out=response.getWriter();
        out.write("保存所有成功");
        out.flush();
    }
}
