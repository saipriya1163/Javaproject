package classes;

import interfaces.I_Case;

public class Case implements I_Case {
	Person owner;
	Animal animal;
	Treatment treatment;
	public Case(Person owner , Animal animal , Treatment treatment) {
		this.owner=owner;
		this.animal=animal;
		this.treatment=treatment;
	}
	public Person getOwner() {
		return this.owner;
	}
	public Animal getAnimal() {
		return this.animal;
	}
	public Treatment getTreatment() {
		return this.treatment;
	}
	
}
