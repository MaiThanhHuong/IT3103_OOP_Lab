package hust.soict.dsai.test.cart;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		cart.addDigitalVideoDisc(dvd3);
		
		//Test the print method
		cart.printCart();
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose search type (1: By ID, 2: By Title): ");
		int searchType = sc.nextInt();
		sc.nextLine();
		
		if (searchType == 1) {
			// Search by ID
			System.out.println("Enter the ID of DVD you want to search: ");
			int idForSearch = sc.nextInt();
			
			if (cart.search(idForSearch)) {
				System.out.println("Found DVD with ID " + idForSearch + ":");
				System.out.println(cart.getDiscById(idForSearch));
			} else {
				System.out.println("Not found DVD with ID " + idForSearch);
			}
		} else if (searchType == 2) {
			//Search by title
			System.out.println("Enter the title of DVD you want to search: ");
			String titleForSearch = sc.nextLine();
			
			if (cart.search(titleForSearch)) {
				System.out.println("Found DVD with title \"" + titleForSearch + "\"");
				System.out.println(cart.getDiscByTitle(titleForSearch));
			} else {
				System.out.println("Not found DVD with title \" " + titleForSearch +"\"");
			}
		} else {
			System.out.println("Invalid search type. Please enter 1 or 2.");
		}
		
		sc.close();
	}
}
