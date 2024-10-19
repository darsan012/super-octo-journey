package c0916788A03;

import java.util.List;
import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	public static void main(String[] args) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			// read the persons.json
			List<Person> persons = List.of(mapper.readValue(new File("persons.json"), Person[].class));
			List<BlogPosts> blogPosts = List.of(mapper.readValue(new File("blogPosts.json"), BlogPosts[].class));
			
			Blog blog = Blog.builder()
                    .contributors(persons)
                    .posts(blogPosts)
                    .build();
			
            System.out.println(blog.toString());

			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
