package tests;

import classes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTests {

    @Test
    public void constructorWithPreTest(){
        Animal test = new Animal("Animal1", 6, 12.5, "female", new String[]{"Condition1", "Condition2"});
    }

    @Test
    public void constructorWithoutPreTest(){
        Animal test = new Animal("Animal1", 6, 12.5, "female");
    }
    
    @Test
    public void setWeightTest(){
        Animal test = new Animal("Animal1", 6, 12.5, "female", new String[]{"Condition1", "Condition2"});
        test.setWeight(11.3);
        assertEquals(11.3, test.getWeight());
    }

    @DisplayName("setAnimalKind Tests")
    public class setAnimalTests{
        @Test
        public void setAnimalDogTest(){
            Animal test = new Animal("Animal1", 6, 12.5, "female", new String[]{"Condition1", "Condition2"});
            assertTrue(test.setAnimalKind("dog"));
        }
        @Test
        public void setAnimalCatTest(){
            Animal test = new Animal("Animal1", 6, 12.5, "female", new String[]{"Condition1", "Condition2"});
            assertTrue(test.setAnimalKind("cat"));
        }
        @Test
        public void setAnimalRodentTest(){
            Animal test = new Animal("Animal1", 6, 12.5, "female", new String[]{"Condition1", "Condition2"});
            assertTrue(test.setAnimalKind("rodent"));
        }
        @Test
        public void setAnimalBirdTest(){
            Animal test = new Animal("Animal1", 6, 12.5, "female", new String[]{"Condition1", "Condition2"});
            assertTrue(test.setAnimalKind("bird"));
        }
        @Test
        public void setAnimalReptileTest(){
            Animal test = new Animal("Animal1", 6, 12.5, "female", new String[]{"Condition1", "Condition2"});
            assertTrue(test.setAnimalKind("reptile"));
        }
    }

    @Test
    public void getNameTest(){
        Animal test = new Animal("Animal1", 6, 12.5, "female", new String[]{"Condition1", "Condition2"});
        assertEquals("Animal1", test.getName());
    }

    @Test
    public void getAgeTest(){
        Animal test = new Animal("Animal1", 6, 12.5, "female", new String[]{"Condition1", "Condition2"});
        assertEquals(6, test.getAge());
    }

    @Test
    public void getWeightTest(){
        Animal test = new Animal("Animal1", 6, 12.5, "female", new String[]{"Condition1", "Condition2"});
        assertEquals(12.5, test.getWeight());
    }

    @Test
    public void getAnimalTest(){
        Animal test = new Animal("Animal1", 6, 12.5, "female", new String[]{"Condition1", "Condition2"});
        test.setAnimalKind("dog");
        assertEquals(AnimalKind.dog, test.getAnimalKind());
    }

    @Test
    public void getGenderTest(){
        Animal test = new Animal("Animal1", 6, 12.5, "female", new String[]{"Condition1", "Condition2"});
        assertEquals("female", test.getGender());
    }

    @Test
    public void getPreexistingConditionTest(){
        Animal test = new Animal("Animal1", 6, 12.5, "female", new String[]{"Condition1", "Condition2"});
        String [] compareData = {"Condition1", "Condition2"};
        String[] actualData = test.getPreexistingCondition();
        Arrays.sort(compareData);
        Arrays.sort(actualData);
        assertArrayEquals(compareData, actualData);
    }

    @Test
    public void addPreexistingConditionTest(){
        Animal test = new Animal("Animal1", 6, 12.5, "female");
        test.addPreexistingCondition(new String[]{"Condition1", "Condition2"});
        String [] compareData = {"Condition1", "Condition2"};
        String[] actualData = test.getPreexistingCondition();
        Arrays.sort(compareData);
        Arrays.sort(actualData);
        assertArrayEquals(compareData, actualData);
    }

}
