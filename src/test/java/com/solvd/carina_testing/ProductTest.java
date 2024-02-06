package com.solvd.carina_testing;

import com.solvd.carina_testing.api.*;
import com.solvd.carina_testing.domain.Product;
import com.solvd.carina_testing.domain.Rating;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;

public class ProductTest {
    @Test(testName = "verify product by exist product id")
    public void verifyProductByExistProductIdTest() {
        Rating rating = new Rating();
        rating.setRate(3.9);
        rating.setCount(120);

        Product product = new Product();
        product.setTitle("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops");
        product.setPrice(109.95);
        product.setDescription("Your perfect pack for everyday use and walks in the forest. " +
                "Stash your laptop (up to 15 inches) in the padded sleeve, your everyday");
        product.setCategory("men's clothing");
        product.setRating(rating);
        product.setImage("https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg");

        GetProductById getProductById = new GetProductById("1");
        getProductById.addProperty("product", product);
        getProductById.addProperty("rating", rating);

        getProductById.callAPIExpectSuccess();

        getProductById.validateResponse();
    }

    @Test(testName = "Verify product post with valid data")
    public void verifyProductPostWithValidDataTest() {
        Product product = createDefaultProduct();

        PostProduct addProduct = new PostProduct();
        addProduct.addProperty("product", product);

        addProduct.callAPIExpectSuccess();

        addProduct.validateResponse();
    }

    @Test(testName = "verify put product with valid data")
    public void verifyPutProductWithValidDataTest() {
        Product product = createDefaultProduct();

        PutProductById putProductById = new PutProductById("7");
        putProductById.addProperty("product", product);

        putProductById.callAPIExpectSuccess();

        putProductById.validateResponse();
    }

    @Test(testName = "verify put product with invalid data")
    public void verifyPutProductWithInvalidDataTest() {
        Product product = createDefaultProduct();

        PutProductById putProductById = new PutProductById(" ");
        putProductById.addProperty("product", product);

        putProductById.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        putProductById.callAPI();
    }

    @Test(testName = "verify patch product with valid data")
    public void verifyPatchProductWithValidDataTest() {
        Product product = createDefaultProduct();

        PatchProductById patchProductById = new PatchProductById("7");
        patchProductById.addProperty("product", product);

        patchProductById.callAPIExpectSuccess();

        patchProductById.validateResponse();
    }


    @Test(testName = "verify delete product test")
    public void verifyDeleteProductTest() {
        Rating rating = new Rating();
        rating.setRate(2.9);
        rating.setCount(340);

        Product product = new Product();
        product.setTitle("Lock and Love Women's Removable Hooded Faux Leather Moto Biker Jacket");
        product.setDescription("100% POLYURETHANE(shell) 100% POLYESTER(lining) 75% POLYESTER 25% COTTON (SWEATER)," +
                " Faux leather material for style and comfort / 2 pockets of front, 2-For-One Hooded denim style faux leather" +
                " jacket, Button detail on waist / Detail stitching at sides, HAND WASH ONLY / DO NOT BLEACH / LINE DRY / DO NOT" +
                " IRON");
        product.setPrice(29.95);
        product.setCategory("women's clothing");
        product.setImage("https://fakestoreapi.com/img/81XH0e8fefL._AC_UY879_.jpg");
        product.setRating(rating);

        DeleteProductById deleteProductById = new DeleteProductById("16");
        deleteProductById.addProperty("product", product);

        deleteProductById.callAPIExpectSuccess();

        deleteProductById.validateResponse();

    }

    public Product createDefaultProduct() {
        Rating rating = new Rating();
        rating.setCount(10);
        rating.setRate(5.0);

        Product product = new Product();
        product.setTitle("test");
        product.setPrice(1.0);
        product.setDescription("test");
        product.setCategory("electronic");
        product.setImage("test");
        product.setRating(rating);
        return product;

    }
}
