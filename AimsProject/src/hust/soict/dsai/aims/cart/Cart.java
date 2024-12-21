package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 1000;
    private static ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public float totalCost() {
        float totalMoney = 0;
        for (Media media : itemsOrdered) {
            totalMoney += media.getCost();
        }
        return totalMoney;
    }

    public static void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
        } else {
            System.out.println("The cart is full. Cannot add more items.");
        }
    }

    public void removeMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            System.out.println("The selected item is not in the cart.");
        } else {
            itemsOrdered.remove(media);
            System.out.println("Removed successfully.");
        }
    }

    public boolean isMatch(String mediaTitle, String inputTitle) {
        return mediaTitle.contains(inputTitle);
    }

    public Media searchByTitle(String userTitle) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (isMatch(media.getTitle(), userTitle)) {
                System.out.println(media.toString()); // Assuming Media has a toString method
                found = true;
                return media;
            }
        }
        if (!found) {
            System.out.println("No matching titles found for \"" + userTitle + "\".");
        }
        return null;
    }

    public void searchByCategory(String userCategory) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (isMatch(media.getCategory(), userCategory)) {
                System.out.println(media.toString()); // Assuming Media has a toString method
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching categories found for \"" + userCategory + "\".");
        }
    }

    public void print(){
        System.out.println("************************************LIST OF ITEMS IN CART********************************");
        if(itemsOrdered == null){
            System.out.println("You have not added anything");
        }else{
            for(Media media : this.itemsOrdered){
                System.out.println(media.toString());
            }
        }
        System.out.println("******************************************************************************************");
    }

    public void filterByID(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println(media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with ID: " + id);
        }
    }

    public void filterByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (isMatch(media.getTitle(), title)) {
                System.out.println(media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with title: \"" + title + "\".");
        }
    }

    public void emptyCart(){
        itemsOrdered.clear();
    }

    public void sortCartByTitleAndCost(){
        print();
        System.out.println("Sorting by Title then Cost: ");
        itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
        print();
    }

    public void sortCartByCostAndTitle(){
        print();
        System.out.println("Sorting by Cost then Title: ");
        itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
        print();
    }
    public static List<Media> getCart() {
        return new ArrayList<>(itemsOrdered); // Return a copy to prevent external modification
    }

    public static ObservableList<Media> getItemsOrdered() {
        return FXCollections.observableArrayList(itemsOrdered);
    }

	public void placeOrder() {
		itemsOrdered.clear();
		
	}
}
