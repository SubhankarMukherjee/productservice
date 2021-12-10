package com.connecttosubh.web;

import com.connecttosubh.model.Coupon;
import com.connecttosubh.model.Product;
import com.connecttosubh.repository.ProductRepo;
import com.connecttosubh.web.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {
    @Autowired
    ProductRepo repo;

    @Autowired
    TokenService tokenService;

    //@Autowired
    //RestTemplate restTemplate;

    @Value("${couponservice.url}")
    private String couponserviceURL;

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {

        // Now we need to secure this URL
        RestTemplate restTemplate= new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String Auth_value = "Bearer ".concat(tokenService.getJWTToken());
        System.out.println(Auth_value);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", Auth_value);
//               // create request
        HttpEntity request = new HttpEntity(headers);
//
      System.out.println("Calling Coupon Service Start-------------------->");
//        System.out.println(request.getHeaders().toString());
        // make a request
   Coupon coupon= restTemplate.exchange(couponserviceURL+ product.getCouponCode(), HttpMethod.GET, request, Coupon.class).getBody();
        System.out.println("Calling Coupon Service End-------------------->");

   //     Coupon coupon = restTemplate.getForObject(couponserviceURL+ product.getCouponCode(), Coupon.class);
        System.out.println("Coupon code"+ coupon.getCode());
        product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
        return repo.save(product);
    }
    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable("productId") Integer id)
    {
        return repo.findById(id).get();

    }

    @GetMapping("/token")
    public String getTokenKey()
    {
        return tokenService.getJWTToken();
    }
}
