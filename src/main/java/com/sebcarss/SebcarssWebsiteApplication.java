package com.sebcarss;

import com.sebcarss.domain.BooksPost;
import com.sebcarss.domain.RecipePost;
import com.sebcarss.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
				"2016-2-6",
				"year-of-ramen-01-soy-chicken-ramen-with-63c-sous-vide-egg",
				"ramen",
				"/images/ramen/year-of-ramen-soy-chicken-ramen-thumbnail.jpeg"));

		postRepository.save(createRecipePost(
				"Year of Ramen #02: Evalyn's Second Birthday Salmon and Egg Miso Ramen",
				"2016-2-13",
				"year-of-ramen-02-evalyns-second-birthday-salmon-and-egg-miso-ramen",
				"ramen",
				"/images/ramen/year-of-ramen-salmon-and-egg-miso-ramen-thumbnail.jpg"));

		postRepository.save(createRecipePost(
				"Year of Ramen #03: Pressure-Cooked Pork Ramen with a Shio Broth",
				"2016-2-20",
				"year-of-ramen-03-pressure-cooked-pork-ramen-with-a-shio-broth",
				"ramen",
				"/images/ramen/year-of-ramen-soy-chicken-ramen-thumbnail.jpeg"));

		postRepository.save(createRecipePost(
				"Year of Ramen #04: Simple Seafood Ramen with Ajitsuke Tamago (Soy Marinated Egg)",
				"2016-2-27",
				"year-of-ramen-04-simple-seafood-ramen-with-ajitsuke-tamago-soy-marinated-egg",
				"ramen",
				"/images/ramen/year-of-ramen-soy-chicken-ramen-thumbnail.jpeg"));

		postRepository.save(createRecipePost(
				"Year of Ramen #05: Mother's Day Chicken and Egg Udon Noodle Soup \"Oyakudon\"",
				"2016-3-5",
				"year-of-ramen-05-mothers-day-chicken-and-egg-udon-noodle-soup-oyakudon",
				"ramen",
				"/images/ramen/year-of-ramen-soy-chicken-ramen-thumbnail.jpeg"));

		postRepository.save(createRecipePost(
				"Year of Ramen #06: First-Aid Chicken Soup Ramen",
				"2016-3-13",
				"year-of-ramen-06-first-aid-chicken-soup-ramen",
				"ramen",
				"/images/ramen/year-of-ramen-soy-chicken-ramen-thumbnail.jpeg"));

		postRepository.save(createBooksPost(
				"The Books I Read in 2016: My 2 Books a Month Challenge",
				"2017-1-4",
				"the-books-i-read-in-2016-my-2-books-a-month-challenge",
				"books"));
	}

	private RecipePost createRecipePost(String title, String date, String permalink, String category, String thumbnail) throws ParseException {
		RecipePost post = new RecipePost();
		post.setTitle(title);
		post.setDatePosted(parseDate(date));
		post.setPermalink(permalink);
		post.setCategory(category);
		post.setThumbnail(thumbnail);
		return post;
	}

	private BooksPost createBooksPost(String title, String date, String permalink, String category) throws ParseException {
		BooksPost post = new BooksPost();
		post.setTitle(title);
		post.setDatePosted(parseDate(date));
		post.setPermalink(permalink);
		post.setCategory(category);
		return post;
	}

	private Date parseDate(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(date);
	}
}
