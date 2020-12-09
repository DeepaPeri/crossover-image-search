package com.crossover.image.db.entity;

import javax.persistence.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Document(indexName = "crossover-elastic-search", indexStoreType = "_doc")
public class ImageEntity {

    @Id
    private int id;

    private String description;

    private String type;

    private long minSize;

    private long maxSize;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getMinSize() {
        return minSize;
    }

    public void setMinSize(long minSize) {
        this.minSize = minSize;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(long maxSize) {
        this.maxSize = maxSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
