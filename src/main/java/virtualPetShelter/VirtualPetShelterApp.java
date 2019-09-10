package virtualPetShelter;
import java.util.Scanner;

public class VirtualPetShelterApp {
	
	static VirtualPetShelter catWelfare = new VirtualPetShelter();

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		catWelfare.add(new VirtualPet("Julius", "Friendly & vocal. Wanders all over the neighborhood. Don't touch his belly."));
		catWelfare.add(new VirtualPet("Mysh", "The lap cat-iest of lap cats. A big bay."));
		catWelfare.add(new VirtualPet("Dottie", "Very friendly, plays in the street"));
		catWelfare.add(new VirtualPet("Moose", "King of the house. An enormous floof."));
		catWelfare.add(new VirtualPet("Kiki", "Playful & curious but NOT cuddly."));
		
		System.out.println("Thank you for volunteering at Cat Welfare.");
		System.out.println("");
		
		printCatStatus();
		
		clockIn: while (true){
			
			printTasks();
			int userInput = input.nextInt();
			input.nextLine();
			
			switch(userInput) {
			case 1:
				feedCats();
				break;
			case 2:
				waterCats();
				break;
			case 3:
				petCat();
				break;
			case 4: 
				adoptCat();
				break;
			case 5: 
				admitCat();
				break;
			case 6:
				System.out.println("Great work today!");
				break clockIn; 
			}
			catWelfare.tickCats();	
		}
	}

	private static void printTasks() {
		System.out.println("What would you like to do next?");
		System.out.println("");
		System.out.println("1. Feed the cats");
		System.out.println("2. Water the cats");
		System.out.println("3. Pet a cat");
		System.out.println("4. Adopt a cat");
		System.out.println("5. Admit a pet");
		System.out.println("6. Clock out");
	}
		
	private static void printCats() {
		catWelfare.getAllCats().forEach(cats -> System.out.println(cats.getCatName() + ": " + cats.getCatDescription()));
	}
	
	public static void printCatStatus() {
		System.out.println("Here's how your cats are doing:");
		System.out.println("Name" + "\t" + "|Hunger" + "\t" + "|Thirst" + "\t" + "|Boredom|");
		System.out.println("--------|-------|-------|-------|");
		catWelfare.getAllCats().forEach(cat -> System.out.println(cat.getCatName() + "\t" + cat.getHunger() + "\t" + cat.getThirst() + "\t" + cat.getBoredom()));
		System.out.println();
	}

	private static void feedCats() {
		catWelfare.getAllCats().forEach(cat -> cat.feed());
		printCatStatus();
		System.out.println("You fed the cats!\n");
	}
	
	private static void waterCats() {
		catWelfare.getAllCats().forEach(cat -> cat.water());
		printCatStatus();
		System.out.println("You filled the cats' water bowls!\n");
	}
	
	private static void petCat() {
		System.out.println("Here are the cats available for pets:");
		printCats();
		System.out.println("Which cat would you like to choose?");
		String catName = input.nextLine();
		VirtualPet cat = catWelfare.getCat(catName);
		catWelfare.pet(cat);
		System.out.println("You give " + catName + " some pets!\n");
	}

	private static void adoptCat() {
		System.out.println("You have chosen to adopt a cat - yay! Here are our cats:");
		printCats();
		System.out.println("Type the name of the cat you would like to adopt.");
		String catName = input.nextLine();
		VirtualPet cat = catWelfare.getCat(catName);
		catWelfare.adopt(cat);
		System.out.println("Take good care of " + catName + "!\n");
		}
	
	private static void admitCat() {
		//prompt user for pet's information, requiring user to specify NAME & DESCRIPTION
		System.out.println("You have chosen to admit a cat. Type the name of the cat you would like to adopt.");
		String newCat = input.nextLine();
		System.out.println("Please enter a description for " + newCat + ":");
		String newCatDescription = input.nextLine();
		catWelfare.add(new VirtualPet(newCat, newCatDescription, 5, 5, 5));
		System.out.println("We will take good care of " + newCat + ".\n");
	}
	
}

