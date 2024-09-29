package classes;

import interfaces.I_Animal;

public class Animal implements I_Animal {
	String name;
	int age;
	double weight;
	String gender;
	String []preexistingConditions=new String[10];
	int noofconditions;
	AnimalKind animalkind;
	public Animal(String name, int age, double weight , String gender) {
		this.name=name;
		this.age=age;
		this.weight=weight;
		this.gender=gender;
	}
	public Animal(String name, int age, double weight , String gender ,
			String [] preexistingConditions) {
		this.name=name;
		this.age=age;
		this.weight=weight;
		this.gender=gender;
		this.preexistingConditions=preexistingConditions;
		noofconditions=preexistingConditions.length;
		
	}
	public boolean setAnimalKind(String kind) {
		AnimalKind newanimalkind =AnimalKind.valueOf(kind);//converting String to type AnimalKind
		// to check if given animal kind is valid
		for (AnimalKind kind1 : AnimalKind.values()) {
			if (kind.equals(kind1.name())) {
				this.animalkind = newanimalkind ;
				return true;
			}
		}
		return false;
	}

	
	public void setWeight(double weight) {
		this.weight=weight;
	}
	public void addPreexistingCondition(String[] conditions) {
		for(String condition1:conditions) {
			if(!isAlreadyListed(condition1)) {
				this.preexistingConditions[noofconditions]=condition1;
				noofconditions++;		
			}	
		}	
	}
	private boolean isAlreadyListed(String condition1) {
		for(String condition2:preexistingConditions) {
			if(condition1.equals(condition2)){
				return true;
			}
		}
		return false;
	}
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
	public double getWeight() {
		return this.weight;
	}
	public AnimalKind getAnimalKind() {
		return this.animalkind;
	}
	public String getGender(){
		return this.gender;
	}
	public String[] getPreexistingCondition() {
		String[] newconditions=new String[noofconditions];
		// copying all pre-existing(already existing and added conditions) to new array
		//I created a random size for preexistingConditions array in the beginning but now we know actual size so this array will not return 
		//any extra null values.that is why i created new array with the exact size.
		System.arraycopy(preexistingConditions, 0, newconditions, 0,noofconditions);
		return newconditions;
	}

}
