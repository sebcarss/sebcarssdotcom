package com.sebcarss;

import com.sebcarss.domain.RecipePost;
import com.sebcarss.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SebcarssWebsiteApplication implements CommandLineRunner {

	@Autowired
	private PostRepository postRepository;

	public static void main(String[] args) {
		SpringApplication.run(SebcarssWebsiteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		postRepository.deleteAll();

		// Add Ramen posts
		postRepository.save(createRecipePost(
				"Year of Ramen #01: Soy Chicken Ramen with 63C Sous-Vide Egg",
				2016, 2, 6,
				"year-of-ramen-01-soy-chicken-ramen-with-63c-sous-vide-egg"));
	}

	private RecipePost createRecipePost(String title, int year, int month, int day, String name) {
		RecipePost post = new RecipePost();
		post.setTitle(title);
		post.setYear(year);
		post.setMonth(month);
		post.setDay(day);
		post.setPermalink(name);
		return post;
	}
}
