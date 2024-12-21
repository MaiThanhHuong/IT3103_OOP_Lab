package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.screen.CartScreen;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;


public class Aims {
	private static Scanner sc;
    private static Store store;
    private static Cart cart;
    private static StoreScreen storeScreen;
    private static CartScreen cartScreen;

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();

        Media[] sampleMedia = new Media[]{
                new CompactDisc("Summer Vibes 2024", "Pop", 14.49f, "Ariana Grande", 210, "Ariana Grande"),
                new CompactDisc("Lover", "Pop", 18.99f, "Taylor Swift", 250, "Taylor Swift"),
                new CompactDisc("Rosie", "Pop", 22.07f, "Rosé", 300, "Rosé"),
                new Book("The Invisible Man", "Science Fiction", 11.29f),
                new Book("San Famille", "Novel", 15.49f),
                new Book("Pride and Prejudice", "Classic Literature", 9.99f),
                new DigitalVideoDisc("Our Beloved Summer", "Romance", 12.99f, "Kim Yoon-jin", 95),
                new DigitalVideoDisc("When The Phone Rings", "Horror", 14.99f, "James Wan", 102),
                new DigitalVideoDisc("Queen of Tears", "Drama", 18.49f, "Lee Jung-hyo", 120),
                
        };

        for (Media m : sampleMedia) {
            store.addMedia(m);
        }

        openStoreScreen();
    }

    public static Store getStore() {
        return store;
    }

    public static Cart getCart() {
        return cart;
    }

    public static StoreScreen getStoreScreen() {
        return storeScreen;
    }

    public static CartScreen getCartScreen() {
        return cartScreen;
    }

    public static void openStoreScreen() {
        storeScreen = new StoreScreen(store);
    }

    public static void closeStoreScreen() {
        storeScreen.setVisible(false);
        storeScreen = null;
    }

    public static void openCartScreen() {
        cartScreen = new CartScreen(cart);
    }

    public static void closeCartScreen() {
        cartScreen.setVisible(false);
        cartScreen = null;
    }
	

}
