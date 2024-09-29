package tests;

import classes.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NodeTests {
    @Test
    public void constructorTest(){
        Case testCase = new Case(new Person("name1", 32, "address1"),new Animal("animal1", 2, 2, "female"), Treatment.diagnostics);
        Node test = new Node(testCase);
    }

    @Test
    public void getPrevTest(){
        Case testCase = new Case(new Person("name1", 32, "address1"),new Animal("animal1", 2, 2, "female"), Treatment.diagnostics);
        Node test = new Node(testCase);
        assertNull(test.getPrev());
    }

    @Test
    public void getNextTest(){
        Case testCase = new Case(new Person("name1", 32, "address1"),new Animal("animal1", 2, 2, "female"), Treatment.diagnostics);
        Node test = new Node(testCase);
        assertNull(test.getNext());
    }

    @Test
    public void setPrevTest(){
        Case testCase = new Case(new Person("name1", 32, "address1"),new Animal("animal1", 2, 2, "female"), Treatment.diagnostics);
        Node testNode1 = new Node(testCase);
        Node testNode2 = new Node(testCase);
        testNode1.setPrev(testNode2);
        assertEquals(testNode2, testNode1.getPrev());
    }

    @Test
    public void setNextTest(){
        Case testCase = new Case(new Person("name1", 32, "address1"),new Animal("animal1", 2, 2, "female"), Treatment.diagnostics);
        Node testNode1 = new Node(testCase);
        Node testNode2 = new Node(testCase);
        testNode1.setNext(testNode2);
        assertEquals(testNode2, testNode1.getNext());
    }

    @Test
    public void getCaseTest(){
        Case testCase = new Case(new Person("name1", 32, "address1"),new Animal("animal1", 2, 2, "female"), Treatment.diagnostics);
        Node testNode1 = new Node(testCase);
        String[] compareData = {"name1", "32","address1", "animal1", "2", "2.0", "female", "diagnostics"};
        Case compareCase = testNode1.getCase();
        String[] actualData =   {compareCase.getOwner().getName(), String.valueOf(compareCase.getOwner().getAge()),compareCase.getOwner().getAddress(),
                                compareCase.getAnimal().getName(), String.valueOf(compareCase.getAnimal().getAge()), String.valueOf(compareCase.getAnimal().getWeight()),
                                compareCase.getAnimal().getGender(), String.valueOf(compareCase.getTreatment())};
        assertArrayEquals(compareData, actualData);
    }

}
