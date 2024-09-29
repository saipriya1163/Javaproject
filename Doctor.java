package classes;

import interfaces.I_Doctor;

public class Doctor extends Person implements I_Doctor {
	String name;
	int age;
	String address;
	AnimalKind[] authorizedAnimals=new AnimalKind[10];
	int noofauthorizedanimals;
	boolean isbusy;
	int currentTime=0;
	public Doctor(String name, int age, String address , AnimalKind[] authorizedFor) {
		super(name,age,address);
		noofauthorizedanimals=0;
		this.isbusy=false;
		for(AnimalKind animal:authorizedFor) {
			addAuthorizedAnimal(animal.name());
		}
	}
	public AnimalKind[] getAuthorizedFor() {
		//I created a random size for authorizedAnimals array in the beginning but now we know actual size so this array will not return 
		//any extra null values.that is why i created new array with the exact size.
		AnimalKind[] result=new AnimalKind[noofauthorizedanimals];
		System.arraycopy(authorizedAnimals, 0, result, 0, noofauthorizedanimals);
		return result;
	}
	public boolean addAuthorizedAnimal(String animalKind) {
		AnimalKind newAnimal = AnimalKind.valueOf(animalKind);
		boolean duplicateFound=false;
		//check for duplicates
		for(AnimalKind animal:authorizedAnimals) {
			if(animal == newAnimal) {
				duplicateFound=true;
			}
		}
		if(!(duplicateFound) & isValidKind(animalKind)) {
			int length =authorizedAnimals.length;
			for(int i=0;i<length;i++) {
				if(authorizedAnimals[i]==null) {
					authorizedAnimals[i]=newAnimal;//new animal added successfully
					noofauthorizedanimals++;
					return true;	
				}
			}
		}
		
		return false;
		
	}
	//method to check if kind of animal is valid
	public boolean isValidKind(String animalKind) {
		
		for (AnimalKind kind1 : AnimalKind.values()) {
			if (animalKind.equals(kind1.toString())) {
				return true;
			}
		}
		return false;
	
	}
	public boolean isBusy() {
		return isbusy;
		
    }

    public void setBusy(boolean busy) {
    	this.isbusy=busy;
    	
    }   
	public void setcurrentTime(int tratmentTime) {
		this.currentTime=currentTime+tratmentTime+1;
		
	}
	public int getcurrentTime() {
		return this.currentTime;
	}
	
}


