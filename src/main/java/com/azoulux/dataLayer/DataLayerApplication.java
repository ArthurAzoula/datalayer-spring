package com.azoulux.dataLayer;

import com.azoulux.dataLayer.model.Category;
import com.azoulux.dataLayer.model.Comment;
import com.azoulux.dataLayer.model.Product;
import com.azoulux.dataLayer.repository.CategoryRepository;
import com.azoulux.dataLayer.repository.ProductRepository;
import com.azoulux.dataLayer.service.CategoryService;
import com.azoulux.dataLayer.service.CommentService;
import com.azoulux.dataLayer.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class DataLayerApplication implements CommandLineRunner {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CommentService commentService;

	public static void main(String[] args) {
		SpringApplication.run(DataLayerApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		Iterable<Product> searchResults = productService.getProductByName("AssuranceTousRisques");
		searchResults.forEach(product -> System.out.println(product.getProductId()));

		searchResults = productService.getProductByCategoryName("Standard");
		searchResults.forEach(product -> System.out.println(product.getName()));

	}
}
