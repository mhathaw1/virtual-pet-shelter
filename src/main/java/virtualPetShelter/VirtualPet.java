package virtualPetShelter;


public class VirtualPet {
	
	private String catName;
	private String description;
	private int hunger = 3;
	private int thirst = 3;
	private int boredom = 3;
	
	public VirtualPet(String catName, String description, int hunger, int thirst, int boredom) {
		this.catName = catName;
		this.description = description;
		this.hunger = hunger;
		this.thirst = thirst;
		this.boredom = boredom;
		
	}
	public VirtualPet(String catName, String description) {
		this.catName = catName;
		this.description = description;
	}
	
	public String getCatName() {
		return catName;
	}
	
	public String getCatDescription() {
		return description;
	}
	
	public int getHunger() {
		return hunger;
	}
	
	public int getThirst() {
		return thirst;
	}
	
	public int getBoredom() {
		return boredom;
	}
	
	public void feed() {
		if (hunger > 2) {
			hunger -= 3;
		}	else if (hunger < 3){
				hunger = -1;
		}
	}

	public void water() {
		if (thirst > 2) {
			thirst -= 3;
		} else if (thirst < 3) {
			thirst = -1;
		}
	}
	
	public void givePets() {
		if (boredom > 4) {
			boredom -= 5;
		} else if (boredom < 5) {
			boredom = -1;
		}
	}
	
	public void tick() {
		hunger += 1;
		thirst += 1;
		boredom += 1;
	}	
	
	
}
		
	
	
	
	
	
	
	
	
	

