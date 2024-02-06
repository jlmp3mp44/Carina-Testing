package com.solvd.carina_testing.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${config.api_url}/products/${id}", methodType = HttpMethodType.PUT)
@RequestTemplatePath(path = "api/products/put/put_product_rq.json")
@ResponseTemplatePath(path = "api/products/put/put_product_rs.json")
public class PutProductById extends AbstractApiMethodV2 {
    public PutProductById(String id) {
        replaceUrlPlaceholder("id",id);
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
