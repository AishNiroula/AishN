import java.util.Scanner;

public class MovieDriver {
	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		
		Movie movie = new Movie();
		
		
		String continueInput;
		do {
		System.out.println("Enter the name of a movie" );
	
		String title = sc.nextLine();
		
		System.out.println("Enter the rating of the movie" );
		String rating = sc.nextLine();
		
		System.out.println("Enter the number of tickets sold for this movie" );
		int soldTickets = sc.nextInt();
		
		movie.setTitle(title);
		movie.setRating(rating);
		movie.setSoldTickets(soldTickets);
		
	
		System.out.println(movie.toString());
		
		sc.nextLine();
		System.out.println("Do you want to enter another? (y or n)");
	    continueInput = sc.nextLine();
		
		} while (continueInput.equals("y"));
		
		System.out.println("Goodbye");
		sc.close();
	}
}
