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

@SpringBootApplication
public class DataLayerApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private CategoryService categoryService;

	public static void main(String[] args) {
		SpringApplication.run(DataLayerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Iterable<Product> products = productService.getProducts();
		Iterable<Comment> comments = commentService.getComments();
		Iterable<Category> categories = categoryService.getCategories();

		products.forEach(product -> System.out.println(product.getName()));
		comments.forEach(comment -> System.out.println(comment.getContent()));
		categories.forEach(category -> System.out.println(category.getName()));
	}
}
