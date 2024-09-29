package tests;

import classes.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ListTests {
    @Test
    public void constructorTest(){
      List testList = new List();
    }

    @Test
    public void appendTest(){
        List testList = new List();
        Case testCase = new Case(new Person("name1", 32, "address1"),new Animal("animal1", 2, 2, "female"), Treatment.diagnostics);
        Node testNode = new Node(testCase);
        assertTrue(testList.append(testNode));
    }

    @Test
    public void getHeadTest(){
        List testList = new List();
        Case testCase = new Case(new Person("name1", 32, "address1"),new Animal("animal1", 2, 2, "female"), Treatment.diagnostics);
        Node testNode = new Node(testCase);
        testList.append(testNode);
        assertEquals(testNode, testList.getHead());
    }
    @Test
    public void getTailTest(){
        List testList = new List();
        Case testCase = new Case(new Person("name1", 32, "address1"),new Animal("animal1", 2, 2, "female"), Treatment.diagnostics);
        Node testNode1 = new Node(testCase);
        Node testNode2 = new Node(testCase);
        testList.append(testNode1);
        testList.append(testNode2);
        assertEquals(testNode2, testList.getTail());
    }

    @Test
    public void insertTest1(){
        List testList = new List();
        Case testCase = new Case(new Person("name1", 32, "address1"),new Animal("animal1", 2, 2, "female"), Treatment.diagnostics);
        Node testNode1 = new Node(testCase);
        Node testNode2 = new Node(testCase);
        Node testNode3 = new Node(testCase);
        testList.append(testNode1);
        testList.append(testNode3);
        assertTrue(testList.insert(1, testNode2));
    }

    @Test
    public void insertTest2(){
        List testList = new List();
        Case testCase1 = new Case(new Person("name1", 32, "address1"),new Animal("animal1", 2, 2, "female"), Treatment.diagnostics);
        Case testCase2 = new Case(new Person("name2", 32, "address2"),new Animal("animal2", 2, 2, "female"), Treatment.diagnostics);
        Case testCase3 = new Case(new Person("name3", 32, "address3"),new Animal("animal3", 2, 2, "female"), Treatment.diagnostics);
        Node testNode1 = new Node(testCase1);
        Node testNode2 = new Node(testCase2);
        Node testNode3 = new Node(testCase3);
        testList.append(testNode1);
        testList.append(testNode3);
        testList.insert(1, testNode2);
        String[] compareData = {"name1", "address1", "animal1", "name2", "address2", "animal2", "name3", "address3", "animal3" };
        ArrayList<String> actualDataList = new ArrayList<>();
        Node currentNode = testList.getHead();
        while(currentNode != null){
            actualDataList.add(currentNode.getCase().getOwner().getName());
            actualDataList.add(currentNode.getCase().getOwner().getAddress());
            actualDataList.add(currentNode.getCase().getAnimal().getName());
            currentNode= currentNode.getNext();
        }
        String[] actualData = actualDataList.toArray(new String[0]);
        assertArrayEquals(compareData, actualData);
    }

    @Test
    public void remove1(){
        List testList = new List();
        Case testCase1 = new Case(new Person("name1", 32, "address1"),new Animal("animal1", 2, 2, "female"), Treatment.diagnostics);
        Case testCase2 = new Case(new Person("name2", 32, "address2"),new Animal("animal2", 2, 2, "female"), Treatment.diagnostics);
        Case testCase3 = new Case(new Person("name3", 32, "address3"),new Animal("animal3", 2, 2, "female"), Treatment.diagnostics);
        Node testNode1 = new Node(testCase1);
        Node testNode2 = new Node(testCase2);
        Node testNode3 = new Node(testCase3);
        testList.append(testNode1);
        testList.append(testNode2);
        testList.append(testNode3);
        assertTrue(testList.remove(1));
    }

    @Test
    public void remove2(){
        List testList = new List();
        Case testCase1 = new Case(new Person("name1", 32, "address1"),new Animal("animal1", 2, 2, "female"), Treatment.diagnostics);
        Case testCase2 = new Case(new Person("name2", 32, "address2"),new Animal("animal2", 2, 2, "female"), Treatment.diagnostics);
        Case testCase3 = new Case(new Person("name3", 32, "address3"),new Animal("animal3", 2, 2, "female"), Treatment.diagnostics);
        Node testNode1 = new Node(testCase1);
        Node testNode2 = new Node(testCase2);
        Node testNode3 = new Node(testCase3);
        testList.append(testNode1);
        testList.append(testNode2);
        testList.append(testNode3);
        testList.remove(1);
        String[] compareData = {"name1", "address1", "animal1", "name3", "address3", "animal3" };
        ArrayList<String> actualDataList = new ArrayList<>();
        Node currentNode = testList.getHead();
        while(currentNode != null){
            actualDataList.add(currentNode.getCase().getOwner().getName());
            actualDataList.add(currentNode.getCase().getOwner().getAddress());
            actualDataList.add(currentNode.getCase().getAnimal().getName());
            currentNode= currentNode.getNext();
        }
        String[] actualData = actualDataList.toArray(new String[0]);
        assertArrayEquals(compareData, actualData);
    }
    @Test
    public void swap1() {
        List testList = new List();
        Case testCase1 = new Case(new Person("name1", 32, "address1"), new Animal("animal1", 2, 2, "female"), Treatment.diagnostics);
        Case testCase2 = new Case(new Person("name2", 32, "address2"), new Animal("animal2", 2, 2, "female"), Treatment.diagnostics);
        Case testCase3 = new Case(new Person("name3", 32, "address3"), new Animal("animal3", 2, 2, "female"), Treatment.diagnostics);
        Case testCase4 = new Case(new Person("name4", 32, "address4"), new Animal("animal4", 2, 2, "female"), Treatment.diagnostics);
        Node testNode1 = new Node(testCase1);
        Node testNode2 = new Node(testCase2);
        Node testNode3 = new Node(testCase3);
        Node testNode4 = new Node(testCase4);

        testList.append(testNode1);
        testList.append(testNode3);
        testList.append(testNode2);
        testList.append(testNode4);
        assertTrue(testList.swap(1, 2));
    }

    @Test
    public void swap2(){
        List testList = new List();
        Case testCase1 = new Case(new Person("name1", 32, "address1"),new Animal("animal1", 2, 2, "female"), Treatment.diagnostics);
        Case testCase2 = new Case(new Person("name2", 32, "address2"),new Animal("animal2", 2, 2, "female"), Treatment.diagnostics);
        Case testCase3 = new Case(new Person("name3", 32, "address3"),new Animal("animal3", 2, 2, "female"), Treatment.diagnostics);
        Case testCase4 = new Case(new Person("name4", 32, "address4"),new Animal("animal4", 2, 2, "female"), Treatment.diagnostics);
        Node testNode1 = new Node(testCase1);
        Node testNode2 = new Node(testCase2);
        Node testNode3 = new Node(testCase3);
        Node testNode4 = new Node(testCase4);

        testList.append(testNode1);
        testList.append(testNode3);
        testList.append(testNode2);
        testList.append(testNode4);
        testList.swap(1, 2);

        String[] compareData = {"name1", "address1", "animal1", "name2", "address2", "animal2", "name3", "address3", "animal3", "name4", "address4", "animal4" };
        ArrayList<String> actualDataList = new ArrayList<>();
        Node currentNode = testList.getHead();
        while(currentNode != null){
            actualDataList.add(currentNode.getCase().getOwner().getName());
            actualDataList.add(currentNode.getCase().getOwner().getAddress());
            actualDataList.add(currentNode.getCase().getAnimal().getName());
            currentNode= currentNode.getNext();
        }
        String[] actualData = actualDataList.toArray(new String[0]);
        assertArrayEquals(compareData, actualData);
    }

    @Test
    public void sort(){
        List testList = new List();
        Case testCase1 = new Case(new Person("name1", 32, "address1"),new Animal("animal1", 2, 2, "female"), Treatment.diagnostics);
        Case testCase2 = new Case(new Person("name2", 32, "address2"),new Animal("animal2", 2, 2, "female"), Treatment.emergency);
        Case testCase3 = new Case(new Person("name3", 32, "address3"),new Animal("animal3", 2, 2, "female"), Treatment.vaccination);
        Case testCase4 = new Case(new Person("name4", 32, "address4"),new Animal("animal4", 2, 2, "female"), Treatment.diagnostics);
        Case testCase5 = new Case(new Person("name5", 32, "address5"),new Animal("animal5", 2, 2, "female"), Treatment.emergency);
        Case testCase6 = new Case(new Person("name6", 32, "address6"),new Animal("animal6", 2, 2, "female"), Treatment.injury);
        Node testNode1 = new Node(testCase1);
        Node testNode2 = new Node(testCase2);
        Node testNode3 = new Node(testCase3);
        Node testNode4 = new Node(testCase4);
        Node testNode5 = new Node(testCase5);
        Node testNode6 = new Node(testCase6);

        testList.append(testNode1);
        testList.append(testNode2);
        testList.append(testNode3);
        testList.append(testNode4);
        testList.append(testNode5);
        testList.append(testNode6);
        testList.sort();

        String[] compareData = {"name2", "address2", "animal2", "name5", "address5", "animal5", "name1", "address1", "animal1", "name3", "address3", "animal3" , "name4", "address4", "animal4", "name6", "address6", "animal6"};
        ArrayList<String> actualDataList = new ArrayList<>();
        Node currentNode = testList.getHead();
        while(currentNode != null){
            actualDataList.add(currentNode.getCase().getOwner().getName());
            actualDataList.add(currentNode.getCase().getOwner().getAddress());
            actualDataList.add(currentNode.getCase().getAnimal().getName());
            currentNode= currentNode.getNext();
        }
        String[] actualData = actualDataList.toArray(new String[0]);
        assertArrayEquals(compareData, actualData);
    }

    @Test
    public void findIndexTest(){
        List testList = new List();
        Case testCase1 = new Case(new Person("name1", 32, "address1"),new Animal("animal1", 2, 2, "female"), Treatment.diagnostics);
        Case testCase2 = new Case(new Person("name2", 32, "address2"),new Animal("animal2", 2, 2, "female"), Treatment.emergency);
        Case testCase3 = new Case(new Person("name3", 32, "address3"),new Animal("animal3", 2, 2, "female"), Treatment.vaccination);
        Case testCase4 = new Case(new Person("name4", 32, "address4"),new Animal("animal4", 2, 2, "female"), Treatment.diagnostics);
        Case testCase5 = new Case(new Person("name5", 32, "address5"),new Animal("animal5", 2, 2, "female"), Treatment.emergency);
        Case testCase6 = new Case(new Person("name6", 32, "address6"),new Animal("animal6", 2, 2, "female"), Treatment.injury);
        Node testNode1 = new Node(testCase1);
        Node testNode2 = new Node(testCase2);
        Node testNode3 = new Node(testCase3);
        Node testNode4 = new Node(testCase4);
        Node testNode5 = new Node(testCase5);
        Node testNode6 = new Node(testCase6);

        testList.append(testNode1);
        testList.append(testNode2);
        testList.append(testNode3);
        testList.append(testNode4);
        testList.append(testNode5);
        testList.append(testNode6);

        int compareData = 2;
        int actualData = testList.findIndex("name3");
        assertEquals(compareData, actualData);
    }

}
