package com.crossover.image.controller;

import javax.ws.rs.core.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class ImageControllerTest {

    @MockBean
    private ElasticsearchOperations elasticsearchOperations;

    @InjectMocks
    ImageController imageController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void searchImageTest() {
        Response response = imageController.searchImage("description", "type", 1, 1, 0, 0);

        Assert.assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }

    @Test
    public void searchImageForSuccessfulTest() {
        SearchHits searchHits = mock(SearchHits.class);
        when(elasticsearchOperations.search(Mockito.any(Query.class), anyObject())).thenReturn(searchHits);
        Response response = imageController.searchImage("description", "type", 1, 1, 1, 1);
        Assert.assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
    }

}
