package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {

    private Media media;
    private StoreScreen storeScreen;

    public MediaStore(Media media, StoreScreen storeScreen) {
        this.media = media;
        //this.storeScreen = storeScreen;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(String.format("%.2f $", media.getCost()));
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAddToCart = new JButton("Add to cart");
        btnAddToCart.addActionListener(new ButtonListener());
        container.add(btnAddToCart);

        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            btnPlay.addActionListener(new ButtonListener());
            container.add(btnPlay);
        }

//        JButton btnDetails = new JButton("Details");
//        btnDetails.addActionListener(new ButtonListener());
//        container.add(btnDetails);

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            switch (button) {
                case "Add to cart":
                    Cart.addMedia(media);
                    JOptionPane.showMessageDialog(null,
                            String.format("Added %s to cart.\nCurrent number of items in cart: %d", media.toString(),
                                    Cart.getItemsOrdered().size()));
                    break;

                case "Play":
                    JDialog playDialog = new JDialog();
                    Container container = playDialog.getContentPane();
                    playDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
                    container.add(Box.createRigidArea(new Dimension(10, 10)));

                    if (media instanceof DigitalVideoDisc) {
                        DigitalVideoDisc dvd = (DigitalVideoDisc) media; // Explicit cast
                        container.add(new JLabel("Playing DVD: " + dvd.getTitle()));
                        container.add(new JLabel("DVD length: " + dvd.getLength() + " min"));
                    } else if (media instanceof CompactDisc) {
                        CompactDisc cd = (CompactDisc) media; // Explicit cast
                        container.add(new JLabel("Title: " + cd.getTitle()));
                        container.add(new JLabel("Artist: " + cd.getArtist()));
                        for (Track track : cd.getTracks()) {
                            container.add(new JLabel("Play: " + track.getTitle() + ". Length: " + track.getLength() + " min"));
                        }
                    }

                    
                    playDialog.setTitle("Play " + media.getTitle());
                    playDialog.setSize(400, 300); // Đặt kích thước phù hợp

                    // Hiển thị cửa sổ ở giữa màn hình
                    playDialog.setLocationRelativeTo(null);

                    // Hiển thị hộp thoại
                    playDialog.setVisible(true);
                    break;

            }
        }
    }
    

}
