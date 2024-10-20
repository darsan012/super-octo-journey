package c0916788A03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BlogPostsTest {
    @Test
    public void testBlogPostWithNullId() {
    	Exception exception = assertThrows(IllegalArgumentException.class, () -> 
    	BlogPosts.builder()
    			 .id(null)
    			 .authorId("1")
    			 .postContent("Content")
    			 .build());
    	
    	assertEquals("ID cannot be null", exception.getMessage());
    	
    }

    @Test
    public void testBlogPostWithNullAuthorId() {
        assertThrows(IllegalArgumentException.class, () -> BlogPosts.builder().id("1").authorId(null).postContent("Content").build());
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
    	BlogPosts.builder()
    			 .id("1")
    			 .authorId(null)
    			 .postContent("Content")
    			 .build());
    	
    	assertEquals("authorId cannot be null", exception.getMessage());
    }

    @Test
    public void testBlogPostValid() {
        BlogPosts blogPost = BlogPosts.builder().id("1").authorId("1").postContent("Content").build();
        assertEquals("1", blogPost.getId());
    }
}

