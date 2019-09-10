package virtualPetShelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VirtualPetShelter {
	
	Map<String, VirtualPet> cats = new HashMap<>();
	

	public void tickCats() {
		for(VirtualPet cat: cats.values()) {
			cat.tick();
		}
	}
	public void add(VirtualPet cat) {
		cats.put(cat.getCatName(), cat);
	}
	
	public void adopt(VirtualPet cat) {
		cats.remove(cat.getCatName(), cat);
	}

	public Collection<VirtualPet> getAllCats() {
		return cats.values();
	}
	
	public VirtualPet getCat(String catName) {
		return cats.get(catName);
	}
		
	public void pet(VirtualPet cat) {
		cat.givePets();
		
	}

}
	

//public void playWithAPet(VirtualPet pet) {
  //  pet.play();		
	

