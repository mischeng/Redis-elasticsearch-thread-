package com.example.test.dao;

import com.example.test.modle.BlogDocument;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Bulk;
import io.searchbox.core.DeleteByQuery;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import org.codelibs.elasticsearch.index.query.BoolQueryBuilder;
import org.codelibs.elasticsearch.index.query.QueryBuilder;
import org.codelibs.elasticsearch.index.query.QueryBuilders;
import org.codelibs.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class BlogDocumentDao {
    @Autowired
    private JestClient jestClient;
    public void save(BlogDocument document)throws Exception{
        Index index=new Index.Builder(document).index(BlogDocument.Index_Name).type(BlogDocument.Type_Name).build();
        this.jestClient.execute(index);
    }
    public  void saveall(List<BlogDocument>documents) throws IOException {
        Bulk.Builder bulk=new Bulk.Builder();
        for (BlogDocument document:documents){
            Index index=new Index.Builder(document).index(BlogDocument.Index_Name).
                    type(BlogDocument.Type_Name).build();
            bulk.addAction(index);
        }
        this.jestClient.execute(bulk.build());
    }
  public List<BlogDocument>search(String key) throws IOException {
        BoolQueryBuilder queryBuilder= QueryBuilders.boolQuery();
        queryBuilder.should(QueryBuilders.matchQuery("name",key));
        queryBuilder.should(QueryBuilders.matchQuery("content",key));
      SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
      searchSourceBuilder.query(queryBuilder);
      System.out.println(searchSourceBuilder.toString());
      Search search=new Search.Builder(searchSourceBuilder.toString()).addIndex(BlogDocument.Index_Name).addType(BlogDocument.Type_Name).build();
      JestResult result=this.jestClient.execute(search);
      return result.getSourceAsObjectList(BlogDocument.class);

  }

   public void delete (long blodId) throws IOException {
        BoolQueryBuilder queryId=QueryBuilders.boolQuery();
        queryId.must(QueryBuilders.termQuery("id",blodId));
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
        searchSourceBuilder.query(queryId);
       DeleteByQuery db=new DeleteByQuery.Builder(searchSourceBuilder.toString()).addIndex(
               BlogDocument.Index_Name).addType(BlogDocument.Type_Name).build();
       JestResult result=this.jestClient.execute(db);
       System.out.println(result.getJsonString());
   }
}
