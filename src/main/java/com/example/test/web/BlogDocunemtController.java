package com.example.test.web;

import com.example.test.modle.BlogDocument;
import com.example.test.service.BlogDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Controller
@RequestMapping("/es")
public class BlogDocunemtController {
    @Autowired
    private BlogDocumentService service;

    @RequestMapping(value = "/save")
    public ResponseEntity<String>save(BlogDocument blogDocument)

    {
        System.out.println("aaa");
        try {
            this.service.saveDocument(blogDocument);
            System.out.println("aaa1");
            return ResponseEntity.status(HttpStatus.OK).body("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).body("保存失败");
    }
    @RequestMapping(value = "/search")
    @ResponseBody
    public List<BlogDocument> search(String key) throws IOException {
        System.out.println("1233");
        System.out.println(key);
        return this.service.search(key);

    }
    @RequestMapping("/delete")
    @ResponseBody
    public void delete(long blogid , HttpServletResponse response) throws IOException {
        this.service.delete(blogid);
        Writer out=response.getWriter();
        response.setCharacterEncoding("utf-8");
        out.write("删除成功");
    }

}
