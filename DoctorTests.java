package tests;

import classes.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoctorTests {
    @Test
    public void constructorTest(){
        Doctor test = new Doctor("Name1", 32, "address1", new AnimalKind[]{AnimalKind.dog, AnimalKind.bird});
    }

    @Test
    public void getAuthorizedForTest(){
        Doctor test = new Doctor("Name1", 32, "address1", new AnimalKind[]{AnimalKind.dog, AnimalKind.bird});
        AnimalKind[] compareData = new AnimalKind[]{AnimalKind.dog, AnimalKind.bird};
        AnimalKind[] actualData = test.getAuthorizedFor();
        assertArrayEquals(compareData, actualData);
    }

    @Test
    public void addAuthorizedAnimalTest(){
        Doctor test = new Doctor("Name1", 32, "address1", new AnimalKind[]{AnimalKind.dog, AnimalKind.bird});
        assertTrue(test.addAuthorizedAnimal("cat"));
    }

}
