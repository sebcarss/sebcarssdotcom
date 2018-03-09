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
				"../images/ramen/year-of-ramen/01/soy-chicken-ramen-thumbnail-400w.jpg",
				"<p>I fell in love with instant ramen when I was a kid. It was one of the first things I learnt to cook on my own and\n" +
						"                managed to get me through some tight university days, when all I could afford to eat was noodles that cost 6p\n" +
						"                (because I’d spent all my money on alcohol!). I remember looking at the recipe on the back of the packet and making\n" +
						"                the decision to try cooking them differently because I didn’t like how watery they were. This goes against what\n" +
						"                ramen is, but I didn’t like the soup that came with instant ramen, I wanted the concentrated flavour on the noodles\n" +
						"                only. So I experimented until I found the perfect amount of water to add to the noodles, to allow the packet’s\n" +
						"                seasoning to coat each noodle for maximum flavour (for those of you that are wondering it was 100ml of water, which\n" +
						"                really isn’t a lot).</p>\n" +
						"            <p>Since my childhood days I’ve improved somewhat in my cooking. When I was 17 I worked in Duttons Winebar in Chester,\n" +
						"                as a prep chef, and then worked in The Living Room in both Chester and Liverpool, as a commis chef. When I met my\n" +
						"                wife, whilst in university, I remember cooking her a 3-course meal for the first time and being blown away by the\n" +
						"                joy she got from eating the food I’d cooked. From that point on I knew that I wanted to challenge myself to cook\n" +
						"                much more interesting dishes.</p>\n" +
						"            <p>Along my culinary adventures I fell in love with Japanese cuisine. I couldn’t help but be attracted to delicious\n" +
						"                sushi, which is everywhere in the world now; sashimi, pure and unadulterated fish; and ramen, the nostalgic noodle\n" +
						"                that started me on my journey into umami heaven. Japanese cuisine is an art form, which is based on the Power of\n" +
						"                Five, in short, all 5 senses should be reflected in the meal that is prepared, e.g. there should be 5 tastes: salty,\n" +
						"                sweet, bitter, sour and umami (that delicious savoury flavour found in meats and cheeses); and 5 colours: white\n" +
						"                (rice), brown (mushrooms), yellow (egg yolk), red (radish) and green (spring onions); amongst the other 3 senses as\n" +
						"                well. It’s a wonderful and healthy way to live your life and I recommend everyone try it. For more in depth\n" +
						"                information on the power of five checkout <a href=\"http://www.savoryjapan.com/learn/culture/power.of.five.html\">The Power of Five</a>.\n" +
						"            </p>\n" +
						"            <p>After Japan I moved onto other cuisines such as Vietnamese and Thai and these days I hardly cook any Japanese.\n" +
						"                However, I was recently introduced to a programme on Netflix called ‘The Mind of a Chef’, where the chef is a guy\n" +
						"                called David Chang, i.e. this guy:</p>\n" +
						"            <p>David owns a restaurant called Momofuku and after watching how excited he was getting about ramen, my nostalgic love\n" +
						"                affair with the noodle was back! So, I’ve decided to set myself a challenge of cooking one ramen dish a week for a\n" +
						"                whole year, blogging the recipe and my experience and understanding as much as I can about the art of ramen. I hope\n" +
						"                you enjoy my posts and learn a bit more about this complex dish.</p>\n" +
						"            <h2>Soy Chicken Ramen with a 63&deg;C Sous-Vide Egg</h2>\n" +
						"            <img srcset=\"\n" +
						"                    ../images/ramen/year-of-ramen/01/soy-chicken-ramen-600w.jpg 600w,\n" +
						"                    ../images/ramen/year-of-ramen/01/soy-chicken-ramen-900w.jpg 900w,\n" +
						"                    ../images/ramen/year-of-ramen/01/soy-chicken-ramen-1500w.jpg 1500w\"\n" +
						"                 sizes=\"\n" +
						"                    (max-width: 767px) 100vw,\n" +
						"                    600px\"\n" +
						"                 src=\"../images/ramen/year-of-ramen/01/soy-chicken-ramen-1500w.jpg\"\n" +
						"                 alt=\"Soy Chicken Ramen\"\n" +
						"            />\n" +
						"            <h3>Ingredients (serves 2)</h3>\n" +
						"            <h4>the broth</h4>\n" +
						"            <ul>\n" +
						"                <li>Splash of sesame oil</li>\n" +
						"                <li>2cm piece of ginger, minced</li>\n" +
						"                <li>1 garlic clove, minced</li>\n" +
						"                <li>3 tbsp light soy sauce</li>\n" +
						"                <li>2 tbsp mirin</li>\n" +
						"                <li>1l chicken stock</li>\n" +
						"            </ul>\n" +
						"            <h4>the toppings</h4>\n" +
						"            <ul>\n" +
						"                <li>2 chicken breasts</li>\n" +
						"                <li>150g chestnut mushrooms, sliced</li>\n" +
						"                <li>2 large eggs</li>\n" +
						"                <li>1 leek, trimmed, sliced and cleaned</li>\n" +
						"                <li>2 radishes, sliced</li>\n" +
						"                <li>3 spring onions, sliced</li>\n" +
						"            </ul>\n" +
						"            <h4>the noodles</h4>\n" +
						"            <ul>\n" +
						"                <li>2 Medium egg noodle slabs</li>\n" +
						"            </ul>\n" +
						"            <h3>Method</h3>\n" +
						"            <ol>\n" +
						"                <li>Set the sous-vide to 63C, vac-seal the chicken and place in the water bath for 1 hour and 30 minutes.</li>\n" +
						"                <li>Gently place the eggs in the sous-vide after 45 minutes so they cook for the remaining 45 minutes.</li>\n" +
						"                <li>Place the sesame oil in a heavy based saucepan over a medium heat and add the garlic and ginger, leave to gently cook for a few minutes. Add the soy sauce and mirin and cook for another 5 minutes. Add the stock and bring to a gentle simmer.</li>\n" +
						"                <li>When the chicken is ready start cooking the noodles in boiling water, add the mushrooms to the stock and put the eggs in an ice bath for 5 minutes.</li>\n" +
						"                <li>Drain the noodles and divide between two warmed bowls. Blanch the leek and place in the noodles, to one side of the bowl, add the radish next to them, use a slotted spoon to place the mushrooms next to them, and finally, take the chicken out of the sous-vide and slice before settling in between the mushrooms and the leeks.</li>\n" +
						"                <li>Peel the eggs and place, whole, in the centre of the dish, scatter with the Spring onions and ladle over the hot broth.</li>\n" +
						"                <li>Serve with light soy sauce and nanami togarashi (Japanese 9-spice).</li>\n" +
						"            </ol>\n" +
						"            <p>\n" +
						"                This was my first ramen in a long time and it did not disappoint! I hope you are able to try it and get as\n" +
						"                much pleasure from it as I did. If you have any questions or comments then please leave them in the comments\n" +
						"                section and I’ll get back to you. Oh, and don’t worry if you don’t have a sous-vide as the chicken will\n" +
						"                work just as well fried, grilled or poached and the eggs will be perfectly fine boiled.\n" +
						"            </p>\n" +
						"            <p>SC.</p>"));

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
