package classes;

import java.util.ArrayList;

import interfaces.I_Veterinary;

public class Veterinary implements I_Veterinary {
	Doctor[] doctors;
	Assistant[] assistants;
	List caseList;
	public Veterinary(Doctor[] doctors , Assistant[] assistants){
		this.doctors=doctors;
		this.assistants=assistants;
		this.caseList=new List();
		
	}
	@Override
	public Doctor[] getDoctors() {
		return this.doctors;
	}

	@Override
	public Assistant[] getAssistants() {
		return this.assistants;
	}

	@Override
	public List getCaseList() {
		return this.caseList;
	}

	@Override
	public boolean addCase(Case newCase) {
		boolean isdoctoravailable =false;
		//checking if there is any doctor who treats this kind of animal
		for(Doctor doctor:doctors) {
			AnimalKind[] authorizedanimals=doctor.getAuthorizedFor();
			for(AnimalKind kind:authorizedanimals) {
				if(newCase.getAnimal().getAnimalKind() == kind) {
					isdoctoravailable=true;
					break;	
				}
			if(isdoctoravailable) {
				break;
			}
			}	
		}
		//if there is any doctor who is available to treat this particular case then I am adding that case to caseList else not adding
		if(isdoctoravailable) {
			caseList.append(new Node(newCase));
			return true;
		}else
			return false;
		
	}

	@Override
	public boolean removeCase(String patientName) {
		int index=caseList.findIndex(patientName);
		if(index != -1) {
			caseList.remove(index);
			return true;
		}else
			return false;
	}

	@Override
	public void printMostUrgentCases(int k) {
		List urgentCases=caseList;
		urgentCases.sort();//sort method in List class automatically moves all urgent cases to front
		Node current=urgentCases.getHead();
		int index =0;
		if(k<0) {
			System.out.println("invalid index");
		}else {
			while(current!=null & index < k) {
				//printing ”ownerName, animalName, treatmentKind, standardTreatmentTime”.
				System.out.println(current.getCase().getOwner().getName()+", "+
				current.getCase().getAnimal().getName()+", "+
				current.getCase().getTreatment().toString()+","+
				getStandardTime(current.getCase().getTreatment().toString()));
				System.out.println();
				current = current.getNext();
				index++;
			}
		}
	}
	//additional method to get standard treatment time for particular treatment kind
	public int getStandardTime(String treatmentKind) {
		switch (treatmentKind) {
        case "vaccination":
            return 15;
        case "injury":
            return 30;
        case "diagnostics":
            return 45;
        case "emergency":
            return 60;
        default:
            return 0;
    }
	}
	@Override
	public ArrayList<String> execute() {
		ArrayList<String> protocol=new ArrayList<>();
		int currentTime=0;
		List cases=caseList;
		cases.sort();// this will prioritize emergency cases first
		Node current=cases.getHead();
		//treating all cases by iterating through caseList and doctors
		while (current!=null) {
	        for(Doctor doctor:doctors) {
	        	 current=cases.getHead();
	        	 if(current != null) {
	        		 int treatmentTime=calculateTreatmentTime(current.getCase());
	        		 if(!(doctor.isBusy())&& isAuthourizedDoctor(doctor,current.getCase())) {
	        			 doctor.setBusy(true);
	        		 	Assistant currentassistant=findAvailableAssistant();
	        			if(currentassistant!=null) {
	        				currentTime=doctor.getcurrentTime();
	        				String  protocolEntry=generateprotocolEntry(current.getCase(),doctor,currentTime,currentTime+treatmentTime);
	        				protocol.add(protocolEntry);
	        				currentassistant.setBusy(false);
	        				removeCase(current.getCase().getOwner().getName());
	        				doctor.setcurrentTime(treatmentTime);
	        				doctor.setBusy(false);
	        			}
					}
	        	 }else
	        		 return protocol;
	        }
	       
	        current=current.getNext();
	        sortDoctors(doctors);
	    }
		

	    return protocol;
	}
	
	
	//Method to check if doctor is authorized to treat particular case
	private boolean isAuthourizedDoctor(Doctor doctor,Case currentCase) {
		AnimalKind[] authorizedanimals=doctor.getAuthorizedFor();
		for(AnimalKind kind:authorizedanimals) {
			if(currentCase.getAnimal().getAnimalKind() == kind) {
				return true;	
			}
		}
		return false;
	}
	
	//method to find an available assistant
	private Assistant findAvailableAssistant() {
		for (Assistant assistant : assistants) {
            if (!assistant.isBusy()) {
                return assistant;
            }
		}
		return null;
	}
	
	//method to generate protocol entry for each treated case.
	private String generateprotocolEntry(Case currentCase,Doctor doctor,int startTime,int endTime) {
		return String.format("%s with %s was treated by %s, %s, started at: %d ended at: %d",
                currentCase.getOwner().getName(),
                currentCase.getAnimal().getName(),
                doctor.getName(),
                currentCase.getTreatment().toString(),
                startTime,
                endTime);
		
	}
	
	//method to return treatment time for particular case
	//if more number of assistants present in ante room than doctors it will return standard time 
	//otherwise it will return double the standard time
    private int calculateTreatmentTime(Case currentCase) {
        int standardTreatmentTime = getStandardTime(currentCase.getTreatment().toString());
        return (assistants.length>doctors.length) ? standardTreatmentTime : standardTreatmentTime * 2;
    }
    
    //Method to sort doctors so that whoever has less previous treatment time will  handle next case
  	private void sortDoctors(Doctor[] doctors) {
  		int n = doctors.length;
          boolean swapped;

          do {
              swapped = false;
              for (int i = 1; i < n; i++) {
                  if (doctors[i - 1].currentTime > doctors[i].currentTime) {
                      // Swap doctors[i-1] and doctors[i]
                      Doctor temp = doctors[i - 1];
                      doctors[i - 1] = doctors[i];
                      doctors[i] = temp;
                      swapped = true;
                  }
              }
              n--;
          } while (swapped);
      }
  		
   

}
