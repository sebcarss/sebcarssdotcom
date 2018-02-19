package com.sebcarss;

import com.sebcarss.domain.Post;
import com.sebcarss.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		postRepository.save(createPost(
				"Year of Ramen #01: Soy Chicken Ramen with 63&deg;C Sous-Vide Egg",
				"2016-2-6",
				"year-of-ramen-01-soy-chicken-ramen-with-63c-sous-vide-egg",
				"ramen",
				"/images/ramen/year-of-ramen-soy-chicken-ramen-200x200.jpeg",
				"<p>I fell in love with instant ramen when I was a kid. It was one of the first things I learnt to cook on my own and\n" +
						"    managed to get me through some tight university days, when all I could afford to eat was noodles that cost 6p\n" +
						"    (because I’d spent all my money on alcohol!). I remember looking at the recipe on the back of the packet and making\n" +
						"    the decision to try cooking them differently because I didn’t like how watery they were. This goes against what\n" +
						"    ramen is, but I didn’t like the soup that came with instant ramen, I wanted the concentrated flavour on the noodles\n" +
						"    only. So I experimented until I found the perfect amount of water to add to the noodles, to allow the packet’s\n" +
						"    seasoning to coat each noodle for maximum flavour (for those of you that are wondering it was 100ml of water, which\n" +
						"    really isn’t a lot).</p>\n" +
						"<p>Since my childhood days I’ve improved somewhat in my cooking. When I was 17 I worked in Duttons Winebar in Chester,\n" +
						"    as a prep chef, and then worked in The Living Room in both Chester and Liverpool, as a commis chef. When I met my\n" +
						"    wife, whilst in university, I remember cooking her a 3-course meal for the first time and being blown away by the\n" +
						"    joy she got from eating the food I’d cooked. From that point on I knew that I wanted to challenge myself to cook\n" +
						"    much more interesting dishes.</p>\n" +
						"<p>Along my culinary adventures I fell in love with Japanese cuisine. I couldn’t help but be attracted to delicious\n" +
						"    sushi, which is everywhere in the world now; sashimi, pure and unadulterated fish; and ramen, the nostalgic noodle\n" +
						"    that started me on my journey into umami heaven. Japanese cuisine is an art form, which is based on the Power of\n" +
						"    Five, in short, all 5 senses should be reflected in the meal that is prepared, e.g. there should be 5 tastes: salty,\n" +
						"    sweet, bitter, sour and umami (that delicious savoury flavour found in meats and cheeses); and 5 colours: white\n" +
						"    (rice), brown (mushrooms), yellow (egg yolk), red (radish) and green (spring onions); amongst the other 3 senses as\n" +
						"    well. It’s a wonderful and healthy way to live your life and I recommend everyone try it. For more in depth\n" +
						"    information on the power of five checkout <a href=\"http://www.savoryjapan.com/learn/culture/power.of.five.html\">http://www.savoryjapan.com/learn/culture/power.of.five.html</a>.\n" +
						"</p>\n" +
						"<p>After Japan I moved onto other cuisines such as Vietnamese and Thai and these days I hardly cook any Japanese.\n" +
						"    However, I was recently introduced to a programme on Netflix called ‘The Mind of a Chef’, where the chef is a guy\n" +
						"    called David Chang, i.e. this guy:</p>\n" +
						"<p>David owns a restaurant called Momofuku and after watching how excited he was getting about ramen, my nostalgic love\n" +
						"    affair with the noodle was back! So, I’ve decided to set myself a challenge of cooking one ramen dish a week for a\n" +
						"    whole year, blogging the recipe and my experience and understanding as much as I can about the art of ramen. I hope\n" +
						"    you enjoy my posts and learn a bit more about this complex dish.</p>\n" +
						"<h2>Soy Chicken Ramen with a 63&deg;C Sous-Vide Egg</h2>\n" +
						"<img srcset=\"\n" +
						"            ../images/ramen/year-of-ramen-soy-chicken-ramen-feature-image-sm.jpg 300w,\n" +
						"            ../images/ramen/year-of-ramen-soy-chicken-ramen-feature-image-lg.jpg 400w\"\n" +
						"     sizes=\"\n" +
						"            (min-width: 767px) 400px,\n" +
						"            300px\"\n" +
						"     src=\"../images/ramen/year-of-ramen-soy-chicken-ramen-feature-image-sm.jpg\"\n" +
						"     alt=\"Soy Chicken Ramen\"\n" +
						"/>"));

	//		postRepository.save(createPost(
	//				"Year of Ramen #02: Evalyn's Second Birthday Salmon and Egg Miso Ramen",
	//				"2016-2-13",
	//				"year-of-ramen-02-evalyns-second-birthday-salmon-and-egg-miso-ramen",
	//				"ramen",
	//				"/images/ramen/year-of-ramen-soy-chicken-ramen-200x200.jpeg"));
	//
	//		postRepository.save(createPost(
	//				"Year of Ramen #03: Pressure-Cooked Pork Ramen with a Shio Broth",
	//				"2016-2-20",
	//				"year-of-ramen-03-pressure-cooked-pork-ramen-with-a-shio-broth",
	//				"ramen",
	//				"/images/ramen/year-of-ramen-soy-chicken-ramen-200x200.jpeg"));
	//
	//		postRepository.save(createPost(
	//				"Year of Ramen #04: Simple Seafood Ramen with Ajitsuke Tamago (Soy Marinated Egg)",
	//				"2016-2-27",
	//				"year-of-ramen-04-simple-seafood-ramen-with-ajitsuke-tamago-soy-marinated-egg",
	//				"ramen",
	//				"/images/ramen/year-of-ramen-soy-chicken-ramen-200x200.jpeg"));
	//
	//		postRepository.save(createPost(
	//				"Year of Ramen #05: Mother's Day Chicken and Egg Udon Noodle Soup \"Oyakudon\"",
	//				"2016-3-5",
	//				"year-of-ramen-05-mothers-day-chicken-and-egg-udon-noodle-soup-oyakudon",
	//				"ramen",
	//				"/images/ramen/year-of-ramen-soy-chicken-ramen-200x200.jpeg"));
	//
	//		postRepository.save(createPost(
	//				"Year of Ramen #06: First-Aid Chicken Soup Ramen",
	//				"2016-3-13",
	//				"year-of-ramen-06-first-aid-chicken-soup-ramen",
	//				"ramen",
	//				"/images/ramen/year-of-ramen-soy-chicken-ramen-200x200.jpeg"));
	//
	//		postRepository.save(createPost(
	//				"The Books I Read in 2016: My 2 Books a Month Challenge",
	//				"2017-1-4",
	//				"the-books-i-read-in-2016-my-2-books-a-month-challenge",
	//				"books"));
	}

	private Post createPost(String title, String date, String permalink, String category, String thumbnail, String body) throws ParseException {
		Post post = new Post();
		post.setTitle(title);
		post.setDatePosted(parseDate(date));
		post.setPermalink(permalink);
		post.setCategory(category);
		post.setThumbnail(thumbnail);
		post.setBody(body);
		return post;
	}

	private Date parseDate(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(date);
	}
}
