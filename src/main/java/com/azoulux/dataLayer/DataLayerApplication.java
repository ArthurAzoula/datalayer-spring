package com.azoulux.dataLayer;

import com.azoulux.dataLayer.model.Category;
import com.azoulux.dataLayer.model.Comment;
import com.azoulux.dataLayer.model.Product;
import com.azoulux.dataLayer.repository.CategoryRepository;
import com.azoulux.dataLayer.repository.ProductRepository;
import com.azoulux.dataLayer.service.CategoryService;
import com.azoulux.dataLayer.service.CommentService;
import com.azoulux.dataLayer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class DataLayerApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(DataLayerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Optional<Product> optProduct = productService.getProductById(1);
		Product productId1 = optProduct.get();

		System.out.println(productId1.getName());

		productId1.getComments().forEach(
				comment -> System.out.println(comment.getContent()));

	}
}
