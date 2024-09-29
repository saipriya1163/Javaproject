package tests;

import classes.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaseTests {
    @Test
    public void constructorTest(){
        Case test = new Case(new Person("name1", 32, "address1"), new Animal("animal1", 2, 2, "female"), Treatment.diagnostics);
    }

    @Test
    public void getOwnerTest(){
        Case test = new Case(new Person("name1", 32, "address1"),new Animal("animal1", 2, 2, "female"), Treatment.diagnostics);
        String[] compareData = {"name1", "32", "address1"};
        Person returnedOwner = test.getOwner();
        String[] actualData = {returnedOwner.getName(), String.valueOf(returnedOwner.getAge()), returnedOwner.getAddress()};
        assertArrayEquals(compareData, actualData);
    }

    @Test
    public void getAnimalTest(){
        Case test = new Case(new Person("name1", 32, "address1"),new Animal("animal1", 2, 2, "female"), Treatment.diagnostics);
        String[] compareData = {"animal1", "2", "2.0", "female"};
        Animal returnedAnimal = test.getAnimal();
        String[] actualData = {returnedAnimal.getName(), String.valueOf(returnedAnimal.getAge()), String.valueOf(returnedAnimal.getWeight()), returnedAnimal.getGender()};
        assertArrayEquals(compareData, actualData);
    }

    @Test
    public void getTreatmentTest(){
        Case test = new Case(new Person("name1", 32, "address1"),new Animal("animal1", 2, 2, "female"), Treatment.diagnostics);
        Treatment compareData = Treatment.diagnostics;
        Treatment actualData = test.getTreatment();
        assertEquals(compareData, actualData);
    }

}
