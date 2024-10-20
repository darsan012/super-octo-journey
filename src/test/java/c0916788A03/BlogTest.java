package c0916788A03;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BlogTest {
    @Test
    public void testGetPostsByAuthorAge() {
        Person person = Person.builder().id("1").firstName("Darshan").lastName("Gautam").age(30).build();
        BlogPosts blogPost = BlogPosts.builder().id("101").authorId("1").postContent("Post").build();
        
        Blog blog = new Blog(List.of(blogPost), List.of(person));
        List<String> postIds = blog.getPostsByAuthorAge(30);
        
        assertEquals(1, postIds.size());
        assertEquals("101", postIds.get(0));
    }
}
