package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.media.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailScreen extends JFrame {
    private Media media;

    public DetailScreen(Media media) {
        super("Details");
        this.media = media;

        // Cấu hình cơ bản
        setLayout(new BorderLayout());
        setBounds(450, 200, 400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Hiển thị thông tin
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        displayInformation(infoPanel);
        add(new JScrollPane(infoPanel), BorderLayout.CENTER);

        // Thêm các nút điều khiển
        addButtons();

        setVisible(true);
    }

    private void displayInformation(JPanel infoPanel) {
        addInfoLine(infoPanel, "Media type:",
                media instanceof DigitalVideoDisc ? "Digital Video Disc"
                        : media instanceof CompactDisc ? "Compact Disc" : "Book");
        addInfoLine(infoPanel, "Title:", media.getTitle());
        addInfoLine(infoPanel, "Category:", media.getCategory());

        if (media instanceof CompactDisc) {
            addInfoLine(infoPanel, "Artist:", ((CompactDisc) media).getArtist());
        }
        if (media instanceof Disc) {
            addInfoLine(infoPanel, "Director:", ((Disc) media).getDirector());
            addInfoLine(infoPanel, "Length:", ((Disc) media).getLength() + " minutes");
        }
        if (media instanceof CompactDisc) {
            addInfoLine(infoPanel, "Number of tracks:", String.valueOf(((CompactDisc) media).getTracks().size()));
        }
        if (media instanceof Book) {
            addInfoLine(infoPanel, "Author(s):", String.join(", ", ((Book) media).getAuthors()));
        }

        addInfoLine(infoPanel, "Cost:", String.format("%.2f $", media.getCost()));
    }

    private void addInfoLine(JPanel panel, String label, String info) {
        JPanel linePanel = new JPanel(new BorderLayout());
        JLabel lblLabel = new JLabel(label);
        lblLabel.setFont(new Font(lblLabel.getFont().getName(), Font.BOLD, 14));
        JLabel lblInfo = new JLabel(info != null && !info.isEmpty() ? info : "Unknown");
        lblInfo.setFont(new Font(lblInfo.getFont().getName(), Font.PLAIN, 14));
        linePanel.add(lblLabel, BorderLayout.WEST);
        linePanel.add(lblInfo, BorderLayout.CENTER);
        panel.add(linePanel);
    }

    private void addButtons() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAddToCart = new JButton("Add to cart");
        btnAddToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aims.getCart().addMedia(media);
                JOptionPane.showMessageDialog(null,
                        String.format("Added '%s' to cart.\nCurrent number of items in cart: %d",
                                media.getTitle(), Aims.getCart().getItemsOrdered().size()));
            }
        });

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Đóng cửa sổ hiện tại
            }
        });

        buttonPanel.add(btnAddToCart);
        buttonPanel.add(btnCancel);

        add(buttonPanel, BorderLayout.SOUTH);
    }
}
