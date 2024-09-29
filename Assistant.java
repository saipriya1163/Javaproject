package classes;

import interfaces.I_Assistant;

public class Assistant extends Person implements I_Assistant {
	String name;
	int age;
	String address;
	boolean isbusy;
	public Assistant(String name, int age, String address) {
		super(name, age, address);
		this.isbusy=false;
	}
	public boolean isBusy() {
        return this.isbusy;
    }

    public void setBusy(boolean busy) {
        this.isbusy = busy;
    }


}
