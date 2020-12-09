# CROSSOVER IMAGE UPLOAD

## 1. Download and Open as gradle project in IDE
* Download the project.
* Open the project in intellij or any other IDE

# 2 Amazon aws elastic search url
```java

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        return new RestHighLevelClient(RestClient.builder(HttpHost.create("https://search-crossover-elastic-search-miqrsbjbk43u3uvftsel4p5d2u.ap-south-1.es.amazonaws.com:443")));
    }
```
* Change host url as required for connecting to elastic search client

# 3. Run the project
* Run the project 
* Note : Java version is java 8

# 4. Api check
* The rest call for upload image is 
> http://localhost:8080/api/images
* Sample input 

# 5. Connection to the elastic search
* Connection url : https://search-crossover-elastic-search-miqrsbjbk43u3uvftsel4p5d2u.ap-south-1.es.amazonaws.com:443
* document : crossover-elastic-search


