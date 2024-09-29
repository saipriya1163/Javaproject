package tests;

import classes.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTests {
    @Test
    public void constructorTest(){
        Person test = new Person("Name1", 32, "address1");
    }

    @Test
    public void getNameTest(){
        Person test = new Person("Name1", 32, "address1");
        String compareString= "Name1";
        assertEquals(compareString, test.getName());
    }

    @Test
    public void getAgeTest(){
        Person test = new Person("Name1", 32, "address1");
        int compareInt = 32;
        assertEquals(compareInt, test.getAge());
    }

    @Test
    public void getAddress(){
        Person test = new Person("Name1", 32, "address1");
        String compareString = "address1";
        assertEquals(compareString, test.getAddress());
    }
}
