import javax.swing.JOptionPane;
public class CalculateTwoNumber {

	public static void main(String[] args) {
		String strNum1, strNum2;
	    strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", 
					JOptionPane.INFORMATION_MESSAGE);
	    double num1 = Double.parseDouble(strNum1);
	    
	    strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", 
					JOptionPane.INFORMATION_MESSAGE);
	    double num2 = Double.parseDouble(strNum2);
	    
	    String resultMessage = 
	    		"Tong cua 2 so la: " + (num1 + num2) + "\n" +
	    		"Hieu cua 2 so la: " + (num1 - num2) + "\n" +
	    		"Tich cua 2 so la: " + (num1 * num2) + "\n";
	     
	    if (num2 != 0) {
	    	resultMessage += "Thuong cua 2 so la: " + (num1/num2) + "\n";
	    } else {
	    	resultMessage += "Khong the chia cho 0.\n";
	    }
	    
	    JOptionPane.showMessageDialog(null, resultMessage, "Result", JOptionPane.INFORMATION_MESSAGE);
	    
	    System.exit(0);
	}

}
