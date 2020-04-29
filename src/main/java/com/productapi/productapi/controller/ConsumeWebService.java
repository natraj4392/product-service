package com.productapi.productapi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import java.util.Arrays;
import com.productapi.productapi.model.Products;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ConsumeWebService {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/template/getproducts")
    public String getProductList() {
       HttpHeaders headers = new HttpHeaders();
       headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
       HttpEntity<String> entity = new HttpEntity<String>(headers);

       return restTemplate.exchange(
         "http://localhost:8085/products/getproducts", HttpMethod.GET, entity, String.class).getBody();
    }

    @PostMapping(value = "/template/createproducts")
   public String createProducts(@RequestBody Products products) {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity <Products> entity = new HttpEntity <Products> (products,headers);
      
      return restTemplate.exchange(
         "http://localhost:8085/products/createproducts", HttpMethod.POST, entity, String.class).getBody();
   }

   @PutMapping(value = "/template/updateproduct/{product_id}")
   public String updateProduct(@PathVariable("product_id") int product_id, @RequestBody Products products) {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity <Products> entity = new HttpEntity <Products> (products,headers);
      
      return restTemplate.exchange(
         "http://localhost:8085/products/updateproduct/"+product_id, HttpMethod.PUT, entity, String.class).getBody();
   }

   @DeleteMapping(value = "/template/deleteproduct/{product_id}")
   public String deleteProduct(@PathVariable("product_id") int product_id) {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity <Products> entity = new HttpEntity <Products> (headers);
      
      return restTemplate.exchange(
         "http://localhost:8085/products/deleteProduct/"+product_id, HttpMethod.DELETE, entity, String.class).getBody();
   }
}