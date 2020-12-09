package com.crossover.image.controller;

import com.crossover.image.db.entity.ImageEntity;
import com.crossover.image.exceptions.RequestParamEmptyException;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @GetMapping(value = "/api/images")
    @Produces({MediaType.APPLICATION_JSON})
    public Response searchImage(@QueryParam("description") String description, @QueryParam("type") String type, @QueryParam("minSize") Integer minSize, @QueryParam("maxSize") Integer maxSize, @QueryParam("pageNumber") Integer pageNumber, @QueryParam("pageSize") Integer pageSize) {
        Response.Status statusValue = null;
        SearchHits<ImageEntity> searchHits = null;
        try {
            if (description == null || type == null || pageNumber < 0 || pageSize == 0 || pageSize < 0) {
                throw new RequestParamEmptyException("request parameters should not be empty");
            }
            Criteria criteria = new Criteria("description").is(description).and("type").is(type).and("minSize").is(minSize).and("maxSize").is(maxSize);
            Query query = new CriteriaQuery(criteria);

            searchHits = elasticsearchOperations.search(query, ImageEntity.class);
            statusValue = Response.Status.CREATED;
        } catch (RequestParamEmptyException e) {
            statusValue = Response.Status.BAD_REQUEST;
        }
        return Response.status(statusValue).entity(searchHits).build();
    }
}
