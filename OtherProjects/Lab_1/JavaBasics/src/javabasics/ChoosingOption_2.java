package javabasics;

import javax.swing.JOptionPane;

public class ChoosingOption_2 {
    public static void main(String[] args) {
        // Tùy chọn tùy chỉnh
        Object[] options = {"I do", "I don't"};
        
        // Hiển thị hộp thoại với các tùy chọn tùy chỉnh
        int option = JOptionPane.showOptionDialog(null, 
                "Do you want to change to the first class ticket?", 
                "Custom Option Dialog", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, options, options[0]);

        // Xử lý lựa chọn của người dùng
        if (option == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "You've chosen: I do");
        } else if (option == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "You've chosen: I don't");
        } else {
            JOptionPane.showMessageDialog(null, "You've chosen: Cancel");
        }

        System.exit(0);
    }
}