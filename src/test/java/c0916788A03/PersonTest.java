package c0916788A03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testValidPerson() {
        Person person = Person.builder()
                .id("1")
                .firstName("Darshan")
                .lastName("Gautam")
                .age(30)
                .gender("Male")
                .build();
        
        assertNotNull(person);
        assertEquals("1", person.getId());
        assertEquals("Darshan", person.getFirstName());
        assertEquals("Gautam", person.getLastName());
        assertEquals(30, person.getAge());
        assertEquals("Male", person.getGender());
    }

    @Test
    public void testNullIdThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Person.builder()
                    .firstName("Darshan")
                    .lastName("Gautam")
                    .age(25)
                    .gender("Male")
                    .build();
        });
        assertEquals("ID cannot be null", exception.getMessage());
    }

    @Test
    public void testBlankFirstNameThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Person.builder()
                    .id("2")
                    .firstName("")
                    .lastName("Gautam")
                    .age(25)
                    .gender("Male")
                    .build();
        });
        assertEquals("First name cannot be null or blank", exception.getMessage());
    }

    @Test
    public void testNegativeAgeThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Person.builder()
                    .id("3")
                    .firstName("Darshan")
                    .lastName("Gautam")
                    .age(-1)
                    .gender("Male")
                    .build();
        });
        assertEquals("Age must be >= 0", exception.getMessage());
    }

    @Test
    public void testBlankLastNameThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Person.builder()
                    .id("4")
                    .firstName("Darshan")
                    .lastName(" ")
                    .age(25)
                    .gender("Male")
                    .build();
        });
        assertEquals("Last name cannot be null or blank", exception.getMessage());
    }
}
