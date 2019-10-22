package com.example.test.service;

import com.example.test.dao.BlogDocumentDao;
import com.example.test.modle.BlogDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@Service
public class BlogDocumentService {
    @Autowired
    private BlogDocumentDao dao;
    public void saveDocument( BlogDocument document) throws Exception {

        this.dao.save(document);
    }
    public List<BlogDocument>search(String key) throws IOException {
        return this.dao.search(key);
    }
    public  void delete(long blogId) throws IOException {
        this.dao.delete(blogId);
    }
    public void saveAll(List<BlogDocument>blogDocument) throws IOException {
        this.dao.saveall(blogDocument);
    }

}
