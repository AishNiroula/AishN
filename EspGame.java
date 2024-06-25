import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class EspGame {
	public static void main(String [] args) throws FileNotFoundException {
		
		
		Scanner scan = new Scanner(System.in); 
		
		System.out.println("CMSC203 Assignment1: Test your ESP skills!");
		
		System.out.print("Enter the filename: ");
		String filename;
		filename = scan.nextLine();
		
		System.out.println("There are sixteen colors from a file: ");
		
		int correctNumGuess = 0;
		
		File colors = new File("colors.txt");
		Scanner sc = new Scanner(colors);	

		while (sc.hasNext()) {
		   String colorList = sc.nextLine();
		   System.out.println(colorList);
		}
		
		
		
		for(int i = 1; i <= 3; i++) {
			System.out.println("\nRound " + i);
			System.out.println("\nI am thinking of a color. "
					+ "\nIs it one of list of colors above? " );
			
			
			System.out.println("Enter your guess: ");
			String guessColor = "";
			guessColor = scan.nextLine().toLowerCase();
			
			Random rand = new Random(); 
			 
			
			int colorIndex;
			colorIndex = rand.nextInt(16)+1; 
			
 
			
			String randomColor = null;
			
		
		 switch(colorIndex){ 
		 case 1: randomColor = "black"; 
		 break;
		 case 2: randomColor = "white";
		 break;
		 case 3: randomColor = "gray"; 
		 break;
		 case 4: randomColor = "silver";
		 break;
		 case 5: randomColor = "maroon"; 
		 break;
		 case 6: randomColor = "red";
		 break;
		 case 7: randomColor ="purple"; 
		 break;
		 case 8: randomColor = "fuchsia"; 
		 break;
		 case 9: randomColor = "green";
		 break;
		 case 10: randomColor = "lime"; 
		 break;
		 case 11: randomColor = "olive"; 
		 break;
		 case 12:randomColor = "yellow"; 
		 break;
		 case 13: randomColor = "navy"; 
		 break;
		 case 14: randomColor ="blue"; 
		 break;
		 case 15: randomColor = "teal";
		 break;
		 case 16: randomColor = "aqua";
		 
		 }

		 System.out.println("\nI was thinking of " + randomColor);
		 
		
		if(randomColor.equalsIgnoreCase(guessColor))
			{correctNumGuess++;}
		 
	
		 }
		
		System.out.println("\nGame Over");
		
		System.out.println("\nYou guessed " + correctNumGuess + 
		  " out of 3 colors correctly.");
		
		System.out.print("Enter your name: "); 
		String name = scan.nextLine();
		
		System.out.println("Enter a sentence that describes yourself: ");
		String description = scan.nextLine();
		
		System.out.println("Due Date(Ex: 6182024): "); 
		int dueDate = scan.nextInt();
		
		
		System.out.println("user name: " + name +
				"\nUser description: "+ description +
				"\nDue Date: " + dueDate);
	
		 
		scan.close();
		sc.close();
		 
		}
		
	}



		
		 

		

		
		
		/*
		 * }
		 * 
		 * int randomGuess = rand.nextInt(16)+1; String randomGuessColor1 = null;
		 * 
		 * 
		 * switch(randomGuess){ case 1: randomGuessColor1 = "black"; break; case 2:
		 * randomGuessColor1 = "white"; break; case 3: randomGuessColor1 = "gray";
		 * break; case 4: randomGuessColor1 = "silver"; break; case 5: randomGuessColor1
		 * = "maroon"; break; case 6: randomGuessColor1 = "red"; break; case 7:
		 * randomGuessColor1 ="purple"; break; case 8: randomGuessColor1 = "fuchsia";
		 * break; case 9: randomGuessColor1 = "green"; break; case 10: randomGuessColor1
		 * = "lime"; break; case 11: randomGuessColor1 = "olive"; break; case 12:
		 * randomGuessColor1 = "yellow"; break; case 13: randomGuessColor1 = "navy";
		 * break; case 14: randomGuessColor1 ="blue"; break; case 15: randomGuessColor1
		 * = "teal"; break; case 16: randomGuessColor1 = "aqua";
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */