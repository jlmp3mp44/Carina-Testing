package com.solvd.carina_testing.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_url}/products/${id}", methodType = HttpMethodType.PATCH)
@RequestTemplatePath(path = "api/products/patch/patch_product_rq.json")
@ResponseTemplatePath(path = "api/products/patch/patch_product_rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PatchProductById extends AbstractApiMethodV2 {
    public PatchProductById(String id) {
        replaceUrlPlaceholder("id", id);
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
