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
@RequiredArgsConstructor(access = AccessLevel.PRIVATE) // Private constructor

public class Person {

    private final String id;
    private final String firstName;
    private final String lastName;
    private final Integer age;
    private final String gender;

    @Builder
    @Jacksonized
    public static Person of(
            @JsonProperty("id") String id,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("age") Integer age,
            @JsonProperty("gender") String gender) {

        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or blank");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or blank");
        }
        if (age == null || age < 0) {
            throw new IllegalArgumentException("Age must be >= 0");
        }

        return new Person(id, firstName, lastName, age, gender);
    }
    
}
