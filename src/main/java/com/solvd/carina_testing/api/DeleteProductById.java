package com.solvd.carina_testing.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${config.api_url}/products/${id}", methodType = HttpMethodType.DELETE)
@ResponseTemplatePath(path = "api/products/delete/delete_product_rs.json")
public class DeleteProductById extends AbstractApiMethodV2 {
    public DeleteProductById(String id) {
        replaceUrlPlaceholder("id", id);
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
