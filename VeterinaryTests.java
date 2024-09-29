package tests;

import classes.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VeterinaryTests {
    @Test
    public void constructorTest(){
        //Initializing the Doctors
        Doctor testDoctor1 = new Doctor("Doctor1", 32, "doctorAddress1", new AnimalKind[]{AnimalKind.dog, AnimalKind.bird});
        Doctor testDoctor2 = new Doctor("Doctor2", 32, "doctorAddress2", new AnimalKind[]{AnimalKind.cat, AnimalKind.bird});

        //Initializing the Assistants
        Assistant testAssistant1 = new Assistant("Assistant1", 32, "assistantAddress1");
        Assistant testAssistant2 = new Assistant("Assistant2", 32, "assistantAddress2");
        Assistant testAssistant3 = new Assistant("Assistant3", 32, "assistantAddress3");

        //Initializing Veterinary and Testing
        Veterinary testVeterinary = new Veterinary(new Doctor[]{testDoctor1, testDoctor2}, new Assistant[]{testAssistant1, testAssistant2, testAssistant3});
    }

    @Test
    public void getDoctorsTest(){
        //Initializing the Doctors
        Doctor testDoctor1 = new Doctor("Doctor1", 32, "doctorAddress1", new AnimalKind[]{AnimalKind.dog, AnimalKind.bird});
        Doctor testDoctor2 = new Doctor("Doctor2", 32, "doctorAddress2", new AnimalKind[]{AnimalKind.cat, AnimalKind.bird});

        //Initializing the Assistants
        Assistant testAssistant1 = new Assistant("Assistant1", 32, "assistantAddress1");
        Assistant testAssistant2 = new Assistant("Assistant2", 32, "assistantAddress2");
        Assistant testAssistant3 = new Assistant("Assistant3", 32, "assistantAddress3");

        //Initializing Veterinary and Testing
        Veterinary testVeterinary = new Veterinary(new Doctor[]{testDoctor1, testDoctor2}, new Assistant[]{testAssistant1, testAssistant2, testAssistant3});
        Doctor[] compareData = new Doctor[]{testDoctor1, testDoctor2};
        Doctor[] actualData = testVeterinary.getDoctors();
        assertArrayEquals(compareData, actualData);
    }

    @Test
    public void getAssistantsTest(){
        //Initializing the Doctors
        Doctor testDoctor1 = new Doctor("Doctor1", 32, "doctorAddress1", new AnimalKind[]{AnimalKind.dog, AnimalKind.bird});
        Doctor testDoctor2 = new Doctor("Doctor2", 32, "doctorAddress2", new AnimalKind[]{AnimalKind.cat, AnimalKind.bird});

        //Initializing the Assistants
        Assistant testAssistant1 = new Assistant("Assistant1", 32, "assistantAddress1");
        Assistant testAssistant2 = new Assistant("Assistant2", 32, "assistantAddress2");
        Assistant testAssistant3 = new Assistant("Assistant3", 32, "assistantAddress3");

        //Initializing Veterinary and Testing
        Veterinary testVeterinary = new Veterinary(new Doctor[]{testDoctor1, testDoctor2}, new Assistant[]{testAssistant1, testAssistant2, testAssistant3});
        Assistant[] compareData = new Assistant[]{testAssistant1, testAssistant2, testAssistant3};
        Assistant[] actualData = testVeterinary.getAssistants();
        assertArrayEquals(compareData, actualData);
    }

    @Test
    public void addCaseTest(){
        //Initializing the Doctors
        Doctor testDoctor1 = new Doctor("Doctor1", 32, "doctorAddress1", new AnimalKind[]{AnimalKind.dog, AnimalKind.bird});
        Doctor testDoctor2 = new Doctor("Doctor2", 32, "doctorAddress2", new AnimalKind[]{AnimalKind.cat, AnimalKind.bird});

        //Initializing the Assistants
        Assistant testAssistant1 = new Assistant("Assistant1", 32, "assistantAddress1");
        Assistant testAssistant2 = new Assistant("Assistant2", 32, "assistantAddress2");
        Assistant testAssistant3 = new Assistant("Assistant3", 32, "assistantAddress3");

        //Initializing the Solution.Classes.Animal and adding a species
        Animal testAnimal1 = new Animal("animal1", 2, 2, "female");
        testAnimal1.setAnimalKind("dog");

        //Initializing the Case and Testing
        Case testCase1 = new Case(new Person("Owner2", 32, "ownerAddress1"), testAnimal1, Treatment.diagnostics);
        Veterinary testVeterinary = new Veterinary(new Doctor[]{testDoctor1, testDoctor2}, new Assistant[]{testAssistant1, testAssistant2, testAssistant3});
        assertTrue(testVeterinary.addCase(testCase1));
    }

    @Test
    public void getCaseListTest1(){
        //Initializing the Doctors
        Doctor testDoctor1 = new Doctor("Doctor1", 32, "doctorAddress1", new AnimalKind[]{AnimalKind.dog, AnimalKind.bird});
        Doctor testDoctor2 = new Doctor("Doctor2", 32, "doctorAddress2", new AnimalKind[]{AnimalKind.cat, AnimalKind.bird});

        //Initializing the Assistants
        Assistant testAssistant1 = new Assistant("Assistant1", 32, "assistantAddress1");
        Assistant testAssistant2 = new Assistant("Assistant2", 32, "assistantAddress2");
        Assistant testAssistant3 = new Assistant("Assistant3", 32, "assistantAddress3");

        //Initializing the Animals and adding a species
        Animal testAnimal1 = new Animal("animal1", 2, 2, "female");
        testAnimal1.setAnimalKind("dog");
        Animal testAnimal2 = new Animal("animal1", 2, 2, "female");
        testAnimal2.setAnimalKind("dog");
        Animal testAnimal3 = new Animal("animal1", 2, 2, "female");
        testAnimal3.setAnimalKind("cat");
        Animal testAnimal4 = new Animal("animal1", 2, 2, "female");
        testAnimal4.setAnimalKind("bird");
        Animal testAnimal5 = new Animal("animal1", 2, 2, "female");
        testAnimal5.setAnimalKind("cat");

        //Initializing the Cases
        Case testCase1 = new Case(new Person("Owner1", 32, "ownerAddress1"),testAnimal1, Treatment.diagnostics);
        Case testCase2 = new Case(new Person("Owner2", 32, "ownerAddress2"), testAnimal2, Treatment.emergency);
        Case testCase3 = new Case(new Person("Owner3", 32, "ownerAddress3"), testAnimal3, Treatment.vaccination);
        Case testCase4 = new Case(new Person("Owner4", 32, "ownerAddress4"),testAnimal4, Treatment.diagnostics);
        Case testCase5 = new Case(new Person("Owner5", 32, "ownerAddress5"), testAnimal5, Treatment.emergency);

        //Initializing the Solution.Classes.Veterinary and adding the Cases
        Veterinary testVeterinary = new Veterinary(new Doctor[]{testDoctor1, testDoctor2}, new Assistant[]{testAssistant1, testAssistant2, testAssistant3});
        testVeterinary.addCase(testCase1);
        testVeterinary.addCase(testCase2);
        testVeterinary.addCase(testCase3);
        testVeterinary.addCase(testCase4);
        testVeterinary.addCase(testCase5);

        //Getting the list
        List testList = testVeterinary.getCaseList();

        //Saving the cases in an array
        Node currentNode = testList.getHead();
        ArrayList<Case> casesArrayList = new ArrayList<>();
        while(currentNode!= null){
            casesArrayList.add(currentNode.getCase());
            currentNode = currentNode.getNext();
        }
        Case[] actualData = casesArrayList.toArray(new Case[0]);

        Case[]compareData = {testCase1, testCase2, testCase3, testCase4, testCase5};

        assertArrayEquals(compareData, actualData);
    }

    @Test
    public void removeCaseTest1(){
        //Initializing the Doctors
        Doctor testDoctor1 = new Doctor("Doctor1", 32, "doctorAddress1", new AnimalKind[]{AnimalKind.dog, AnimalKind.bird});
        Doctor testDoctor2 = new Doctor("Doctor2", 32, "doctorAddress2", new AnimalKind[]{AnimalKind.cat, AnimalKind.bird});

        //Initializing the Assistants
        Assistant testAssistant1 = new Assistant("Assistant1", 32, "assistantAddress1");
        Assistant testAssistant2 = new Assistant("Assistant2", 32, "assistantAddress2");
        Assistant testAssistant3 = new Assistant("Assistant3", 32, "assistantAddress3");

        //Initializing the Animals and adding a species
        Animal testAnimal1 = new Animal("animal1", 2, 2, "female");
        testAnimal1.setAnimalKind("dog");
        Animal testAnimal2 = new Animal("animal1", 2, 2, "female");
        testAnimal2.setAnimalKind("dog");
        Animal testAnimal3 = new Animal("animal1", 2, 2, "female");
        testAnimal3.setAnimalKind("cat");
        Animal testAnimal4 = new Animal("animal1", 2, 2, "female");
        testAnimal4.setAnimalKind("bird");
        Animal testAnimal5 = new Animal("animal1", 2, 2, "female");
        testAnimal5.setAnimalKind("cat");

        //Initializing the Cases
        Case testCase1 = new Case(new Person("Owner1", 32, "ownerAddress1"),testAnimal1, Treatment.diagnostics);
        Case testCase2 = new Case(new Person("Owner2", 32, "ownerAddress2"), testAnimal2, Treatment.emergency);
        Case testCase3 = new Case(new Person("Owner3", 32, "ownerAddress3"), testAnimal3, Treatment.vaccination);
        Case testCase4 = new Case(new Person("Owner4", 32, "ownerAddress4"),testAnimal4, Treatment.diagnostics);
        Case testCase5 = new Case(new Person("Owner5", 32, "ownerAddress5"), testAnimal5, Treatment.emergency);

        //Initializing the Solution.Classes.Veterinary and adding the Cases
        Veterinary testVeterinary = new Veterinary(new Doctor[]{testDoctor1, testDoctor2}, new Assistant[]{testAssistant1, testAssistant2, testAssistant3});
        testVeterinary.addCase(testCase1);
        testVeterinary.addCase(testCase2);
        testVeterinary.addCase(testCase3);
        testVeterinary.addCase(testCase4);
        testVeterinary.addCase(testCase5);

        assertTrue(testVeterinary.removeCase("Owner2"));
    }

    @Test
    public void removeCaseTest2(){
        //Initializing the Doctors
        Doctor testDoctor1 = new Doctor("Doctor1", 32, "doctorAddress1", new AnimalKind[]{AnimalKind.dog, AnimalKind.bird});
        Doctor testDoctor2 = new Doctor("Doctor2", 32, "doctorAddress2", new AnimalKind[]{AnimalKind.cat, AnimalKind.bird});

        //Initializing the Assistants
        Assistant testAssistant1 = new Assistant("Assistant1", 32, "assistantAddress1");
        Assistant testAssistant2 = new Assistant("Assistant2", 32, "assistantAddress2");
        Assistant testAssistant3 = new Assistant("Assistant3", 32, "assistantAddress3");

        //Initializing the Animals and adding a species
        Animal testAnimal1 = new Animal("animal1", 2, 2, "female");
        testAnimal1.setAnimalKind("dog");
        Animal testAnimal2 = new Animal("animal1", 2, 2, "female");
        testAnimal2.setAnimalKind("dog");
        Animal testAnimal3 = new Animal("animal1", 2, 2, "female");
        testAnimal3.setAnimalKind("cat");
        Animal testAnimal4 = new Animal("animal1", 2, 2, "female");
        testAnimal4.setAnimalKind("bird");
        Animal testAnimal5 = new Animal("animal1", 2, 2, "female");
        testAnimal5.setAnimalKind("cat");

        //Initializing the Cases
        Case testCase1 = new Case(new Person("Owner1", 32, "ownerAddress1"),testAnimal1, Treatment.diagnostics);
        Case testCase2 = new Case(new Person("Owner2", 32, "ownerAddress2"), testAnimal2, Treatment.emergency);
        Case testCase3 = new Case(new Person("Owner3", 32, "ownerAddress3"), testAnimal3, Treatment.vaccination);
        Case testCase4 = new Case(new Person("Owner4", 32, "ownerAddress4"),testAnimal4, Treatment.diagnostics);
        Case testCase5 = new Case(new Person("Owner5", 32, "ownerAddress5"), testAnimal5, Treatment.emergency);

        //Initializing the Solution.Classes.Veterinary and adding the Cases
        Veterinary testVeterinary = new Veterinary(new Doctor[]{testDoctor1, testDoctor2}, new Assistant[]{testAssistant1, testAssistant2, testAssistant3});
        testVeterinary.addCase(testCase1);
        testVeterinary.addCase(testCase2);
        testVeterinary.addCase(testCase3);
        testVeterinary.addCase(testCase4);
        testVeterinary.addCase(testCase5);

        //Removing a case
        testVeterinary.removeCase("Owner2");

        //Getting the list
        List testList = testVeterinary.getCaseList();

        //Saving the cases in an array
        Node currentNode = testList.getHead();
        ArrayList<Case> casesArrayList = new ArrayList<>();
        while(currentNode!= null){
            casesArrayList.add(currentNode.getCase());
            currentNode = currentNode.getNext();
        }
        Case[] actualData = casesArrayList.toArray(new Case[0]);

        Case[]compareData = {testCase1, testCase3, testCase4, testCase5};

        assertArrayEquals(compareData, actualData);
    }
    @Test
    public void printMostUrgentCasesTest (){
        //Initializing the Doctors
        Doctor testDoctor1 = new Doctor("Doctor1", 32, "doctorAddress1", new AnimalKind[]{AnimalKind.dog, AnimalKind.bird});
        Doctor testDoctor2 = new Doctor("Doctor2", 32, "doctorAddress2", new AnimalKind[]{AnimalKind.cat, AnimalKind.bird});

        //Initializing the Assistants
        Assistant testAssistant1 = new Assistant("Assistant1", 32, "assistantAddress1");
        Assistant testAssistant2 = new Assistant("Assistant2", 32, "assistantAddress2");
        Assistant testAssistant3 = new Assistant("Assistant3", 32, "assistantAddress3");

        //Initializing the Animals and adding a species
        Animal testAnimal1 = new Animal("animal1", 2, 2, "female");
        testAnimal1.setAnimalKind("dog");
        Animal testAnimal2 = new Animal("animal1", 2, 2, "female");
        testAnimal2.setAnimalKind("dog");
        Animal testAnimal3 = new Animal("animal1", 2, 2, "female");
        testAnimal3.setAnimalKind("cat");
        Animal testAnimal4 = new Animal("animal1", 2, 2, "female");
        testAnimal4.setAnimalKind("bird");
        Animal testAnimal5 = new Animal("animal1", 2, 2, "female");
        testAnimal5.setAnimalKind("cat");

        //Initializing the Cases
        Case testCase1 = new Case(new Person("Owner1", 32, "ownerAddress1"),testAnimal1, Treatment.diagnostics);
        Case testCase2 = new Case(new Person("Owner2", 32, "ownerAddress2"), testAnimal2, Treatment.emergency);
        Case testCase3 = new Case(new Person("Owner3", 32, "ownerAddress3"), testAnimal3, Treatment.vaccination);
        Case testCase4 = new Case(new Person("Owner4", 32, "ownerAddress4"),testAnimal4, Treatment.diagnostics);
        Case testCase5 = new Case(new Person("Owner5", 32, "ownerAddress5"), testAnimal5, Treatment.emergency);

        //Initializing the Solution.Classes.Veterinary and adding the Cases
        Veterinary testVeterinary = new Veterinary(new Doctor[]{testDoctor1, testDoctor2}, new Assistant[]{testAssistant1, testAssistant2, testAssistant3});
        testVeterinary.addCase(testCase1);
        testVeterinary.addCase(testCase2);
        testVeterinary.addCase(testCase3);
        testVeterinary.addCase(testCase4);
        testVeterinary.addCase(testCase5);

        testVeterinary.printMostUrgentCases(3);

        /*What should be printed:
        Owner2, animal1, emergency, 60
        Owner5, animal1, emergency, 60
        Owner1, animal1, diagnostics, 45
        Owner3, animal1, vaccination, 15
        */
    }

    @Test
    public void executeTest(){
        //Initializing the Doctors
        Doctor testDoctor1 = new Doctor("Doctor1", 32, "doctorAddress1", new AnimalKind[]{AnimalKind.dog, AnimalKind.bird});
        Doctor testDoctor2 = new Doctor("Doctor2", 32, "doctorAddress2", new AnimalKind[]{AnimalKind.cat, AnimalKind.bird});

        //Initializing the Assistants
        Assistant testAssistant1 = new Assistant("Assistant1", 32, "assistantAddress1");
        Assistant testAssistant2 = new Assistant("Assistant2", 32, "assistantAddress2");
        Assistant testAssistant3 = new Assistant("Assistant3", 32, "assistantAddress3");

        //Initializing the Animals and adding a species
        Animal testAnimal1 = new Animal("animal1", 2, 2, "female");
        testAnimal1.setAnimalKind("dog");
        Animal testAnimal2 = new Animal("animal2", 2, 2, "female");
        testAnimal2.setAnimalKind("dog");
        Animal testAnimal3 = new Animal("animal3", 2, 2, "female");
        testAnimal3.setAnimalKind("cat");
        Animal testAnimal4 = new Animal("animal4", 2, 2, "female");
        testAnimal4.setAnimalKind("bird");
        Animal testAnimal5 = new Animal("animal5", 2, 2, "female");
        testAnimal5.setAnimalKind("cat");

        //Initializing the Cases
        Case testCase1 = new Case(new Person("Owner1", 32, "ownerAddress1"),testAnimal1, Treatment.diagnostics);
        Case testCase2 = new Case(new Person("Owner2", 32, "ownerAddress2"), testAnimal2, Treatment.emergency);
        Case testCase3 = new Case(new Person("Owner3", 32, "ownerAddress3"), testAnimal3, Treatment.vaccination);
        Case testCase4 = new Case(new Person("Owner4", 32, "ownerAddress4"),testAnimal4, Treatment.diagnostics);
        Case testCase5 = new Case(new Person("Owner5", 32, "ownerAddress5"), testAnimal5, Treatment.emergency);

        //Initializing the Veterinary and adding the Cases
        Veterinary testVeterinary = new Veterinary(new Doctor[]{testDoctor1, testDoctor2}, new Assistant[]{testAssistant1, testAssistant2, testAssistant3});
        testVeterinary.addCase(testCase1);
        testVeterinary.addCase(testCase2);
        testVeterinary.addCase(testCase3);
        testVeterinary.addCase(testCase4);
        testVeterinary.addCase(testCase5);

        //Execute the Function, filling the compare Data and Testing
        ArrayList<String> actualDataArrayList = testVeterinary.execute();

        ArrayList<String> compareDataArrayList = new ArrayList<>();
        compareDataArrayList.add("Owner2 with animal2 was treated by Doctor1, emergency, started at: 0 ended at: 60");
        compareDataArrayList.add("Owner5 with animal5 was treated by Doctor2, emergency, started at: 0 ended at: 60");
        compareDataArrayList.add("Owner3 with animal3 was treated by Doctor2, vaccination, started at: 61 ended at: 76");
        compareDataArrayList.add("Owner1 with animal1 was treated by Doctor1, diagnostics, started at: 61 ended at: 106");
        compareDataArrayList.add("Owner4 with animal4 was treated by Doctor2, diagnostics, started at: 77 ended at: 122");


        // Sort the ArrayList using a Comparator
        Comparator<String> ownerComparator = (str1, str2) -> {
            String owner1 = extractOwner(str1);
            String owner2 = extractOwner(str2);
            return owner1.compareTo(owner2);
        };

        Collections.sort(actualDataArrayList, ownerComparator);
        Collections.sort(compareDataArrayList, ownerComparator);

        String[] actualData = actualDataArrayList.toArray(new String[0]);
        String[] compareData = compareDataArrayList.toArray(new String[0]);

        //Assertion
        assertArrayEquals(compareData, actualData);
        /* Note on why we are asserting the sorted arrays:
        The assignment of cases to doctors in this case is unambiguous,
        however, since several cases have the same starting time,
        your resulting list could differ slightly while still being correct
        (for example, testCase3 and testCase1 could be switched).
        To avoid this test failing on that technicality, we sort the resulting
        arrays before assertion.
        */
    }

    private static String extractOwner(String input) {
        int startIndex = input.indexOf("Owner");
        if (startIndex != -1) {
            int endIndex = input.indexOf(" ", startIndex);
            if (endIndex != -1) {
                return input.substring(startIndex, endIndex);
            }
        }
        return input;
    }

}
