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

		categoryService.getCategories().forEach(
				category -> System.out.println(category.getName()));

		Category newCategory = new Category();
		newCategory.setName("Promotion");

		newCategory = categoryService.addCategory(newCategory);

		categoryService.getCategories().forEach(
				category -> System.out.println(category.getName()));

		productService.getProducts().forEach(
				product -> System.out.println(product.getName()));

		Product newProduct = new Product();
		newProduct.setName("AssuranceAuto");
		newProduct.setDescription("Assurance Auto pour les jeunes conducteurs");
		newProduct.setCost(1000);

		newCategory.addProduct(newProduct);

		newProduct = productService.addProduct(newProduct);

		productService.getProducts().forEach(
				product -> System.out.println(product.getName()));

		newProduct.getCategories().forEach(
				category -> System.out.println(category.getName()));
	}
}
