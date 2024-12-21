package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CartScreen extends JFrame {
    private Cart cart;

    public CartScreen(Cart cart) {
        super();
        
        this.cart = cart;
        
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setVisible(true);

        this.setSize(new Dimension(1024, 768));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    Scene scene = new Scene(root);

                    // Đảm bảo không gán lại một root đã có cho scene
                    fxPanel.setScene(scene);  // Đảm bảo fxPanel không bị thay đổi root scene trước đó
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
    public static void main(String[] args) {
        Cart cart = new Cart();

        // Compact Discs
        CompactDisc cd = new CompactDisc("Melodic Journey", "Pop", 11.49f, "Liam Rhodes", 180, "Liam Rhodes");
        CompactDisc cd1 = new CompactDisc("Classical Masterpieces", "Classical", 15.99f, "Various Artists", 160, "Beethoven");
        CompactDisc cd2 = new CompactDisc("Electronic Beats", "Electronic", 9.99f, "DJ Zane", 220, "DJ Zane");
        CompactDisc cd3 = new CompactDisc("Smooth Jazz Nights", "Jazz", 13.49f, "John Coltrane", 200, "John Coltrane");
        CompactDisc cd4 = new CompactDisc("Greatest Hits 2024", "Pop", 10.49f, "Ariana Grande", 150, "Ariana Grande");
        CompactDisc cd5 = new CompactDisc("Vibes of Nature", "Relaxation", 8.49f, "Ambient Sounds", 240, "Ambient Sounds");
        CompactDisc cd6 = new CompactDisc("Summer Beats", "Dance", 12.99f, "DJ Max", 210, "DJ Max");
        CompactDisc cd7 = new CompactDisc("Indie Hits", "Indie", 14.29f, "The Indie Band", 185, "Indie Band");
        CompactDisc cd8 = new CompactDisc("Retro Classics", "Classical", 16.99f, "Various Artists", 150, "Classical Music");
        CompactDisc cd9 = new CompactDisc("Top 100", "Pop", 17.99f, "Various Artists", 170, "Pop Artists");
        CompactDisc cd10 = new CompactDisc("Ultimate Jazz Collection", "Jazz", 20.99f, "Miles Davis", 220, "Miles Davis");

        // Digital Video Discs
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Dark Knight", "Action", 14.99f, "Christopher Nolan", 152);
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Avatar", "Sci-fi", 18.99f, "James Cameron", 162);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Grand Budapest Hotel", "Comedy", 12.49f, "Wes Anderson", 99);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Lion King", "Animation", 16.99f, "Disney", 88);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Avengers", "Action", 19.49f, "Joss Whedon", 143);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Matrix", "Sci-fi", 14.49f, "The Wachowskis", 136);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Interstellar", "Sci-fi", 22.99f, "Christopher Nolan", 169);
        DigitalVideoDisc dvd7 = new DigitalVideoDisc("The Godfather", "Drama", 18.29f, "Francis Ford Coppola", 175);
        DigitalVideoDisc dvd9 = new DigitalVideoDisc("Inception", "Thriller", 17.99f, "Christopher Nolan", 148);
        DigitalVideoDisc dvd10 = new DigitalVideoDisc("Frozen", "Animation", 13.59f, "Disney", 102);

        // Books
        Book book = new Book("The Silent Patient", "Thriller", 12.99f);
        Book book1 = new Book("The Great Gatsby", "Classic", 9.49f);
        Book book2 = new Book("1984", "Dystopian", 8.99f);
        Book book3 = new Book("Moby Dick", "Adventure", 11.29f);
        Book book4 = new Book("The Catcher in the Rye", "Classic", 7.79f);
        Book book5 = new Book("The Alchemist", "Adventure", 10.49f);
        Book book6 = new Book("Brave New World", "Dystopian", 8.29f);
        Book book7 = new Book("To Kill a Mockingbird", "Classic", 6.99f);
        Book book8 = new Book("Pride and Prejudice", "Romance", 5.99f);
        Book book9 = new Book("The Hobbit", "Fantasy", 7.49f);
        Book book10 = new Book("War and Peace", "Historical", 13.99f);

        // Add CompactDiscs to Cart
        cart.addMedia(cd);
        cart.addMedia(cd1);
        cart.addMedia(cd2);
        cart.addMedia(cd3);
        cart.addMedia(cd4);
        cart.addMedia(cd5);
        cart.addMedia(cd6);
        cart.addMedia(cd7);
        cart.addMedia(cd8);
        cart.addMedia(cd9);
        cart.addMedia(cd10);

        // Add DigitalVideoDiscs to Cart
        cart.addMedia(dvd);
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        cart.addMedia(dvd4);
        cart.addMedia(dvd5);
        cart.addMedia(dvd6);
        cart.addMedia(dvd7);
        cart.addMedia(dvd9);
        cart.addMedia(dvd10);

        // Add Books to Cart
        cart.addMedia(book);
        cart.addMedia(book1);
        cart.addMedia(book2);
        cart.addMedia(book3);
        cart.addMedia(book4);
        cart.addMedia(book5);
        cart.addMedia(book6);
        cart.addMedia(book7);
        cart.addMedia(book8);
        cart.addMedia(book9);
        cart.addMedia(book10);

        // Display Cart Screen
        new CartScreen(cart);
    }
}
    
 

