package com.solvd.carina_testing.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/products/${id}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/products/get/get_product_rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetProductById extends AbstractApiMethodV2 {
    public GetProductById(String id) {
        replaceUrlPlaceholder("id", id);
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
