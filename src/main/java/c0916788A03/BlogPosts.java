package c0916788A03;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE) // Private constructor)
public class BlogPosts {
	private final String id;
	private final String authorId;
	private final String postContent;
	
	@Builder
	@Jacksonized
	public static BlogPosts of(@JsonProperty("id") String id,
			         @JsonProperty("authorId") String authorId,
			         @JsonProperty("postContent") String postContent) {
		if(id == null) {
			throw new IllegalArgumentException("ID cannot be null");
		}
		if(authorId == null) {
			throw new IllegalArgumentException("authorId cannot be null");
		}
		return new BlogPosts(id, authorId, postContent);
	}

}
