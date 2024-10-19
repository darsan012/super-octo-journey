package c0916788A03;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Blog {
	private final List<BlogPosts> posts;
	private final List<Person> contributors;
	
   
	public List<String> getPostsByAuthorAge(Integer age){
		return posts.stream()
					.filter(post -> contributors.stream()
												.anyMatch(person -> person.getId().equals(post.getAuthorId()) 
												 && person.getAge().equals(age)))
					.map(BlogPosts :: getId)
					.collect(Collectors.toList());
	}
}
