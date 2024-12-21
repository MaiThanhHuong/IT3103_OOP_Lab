import java.util.Scanner;

public class Giai_phuong_trinh_2_2_6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Chọn 1 dạng bài toán để giải: ");
		System.out.println("1. Phương trình bậc 1");
		System.out.println("2. Hệ phương trình bậc 1");
		System.out.println("3. Phương trình bậc 2");
		System.out.println("4. Thoát");
				
		int num = sc.nextInt();
		
		switch (num) {
		case 1:
			GiaiPTBacMot(sc);
			break;
		case 2:
			GiaiHePTBacMot(sc);
			break;
		case 3:
			GiaiPTBacHai(sc);
			break;
		case 4:
			System.out.println("Chương trình kết thúc.");
			break;
		default:
			System.out.println("Lựa chọn không hợp lệ");
		}
		sc.close();		
				
	}
	
	//Giai phuong trinh bac nhat: ax + b = 0;
	private static void GiaiPTBacMot(Scanner sc) {
		System.out.println("Giải phương trình ax + b = 0");
		System.out.print("Nhập a: ");
		double a = sc.nextDouble();
		System.out.print("Nhập b: ");
		double b = sc.nextDouble();
		
		//Kiểm tra nếu a = 0
		if (a == 0) {
			System.out.println("Lỗi: a phải khác 0.");
		} else {
			double x = -b / a;
			System.out.println("Nghiệm của phương trình " + a + "x + " + b +" = 0 là x = " + x);
		}
	}

	//Giai he phuong trinh
	private static void GiaiHePTBacMot(Scanner sc) {
		System.out.println("Giải phương trình bậc nhất hai ẩn");
		System.out.print("Nhập a11: ");
		double a11 = sc.nextDouble();
		System.out.print("Nhập a12: ");
		double a12 = sc.nextDouble();
		System.out.print("Nhập b1: ");
		double b1 = sc.nextDouble();
		System.out.print("Nhập a21: ");
		double a21 = sc.nextDouble();
		System.out.print("Nhập a22: ");
		double a22 = sc.nextDouble();
		System.out.print("Nhập b2: ");
		double b2 = sc.nextDouble();
		
		// Tinh dinh thuc
		double D = a11 * a22 - a12 * a21;
		double D1 = b1 * a22 - b2 * a12;
		double D2 = a11 * b2 - a21 * b1;
		
		//Kiem tra cac truong hop dac biet
		if (D == 0) {
			if (D1 == 0 && D2 == 0) {
				System.out.println("Hệ phương trình có vô số nghiệm.");
			} else {
				System.out.println("Hệ phương trình vô nghiệm.");
			}
		} else {
			//Tinh nghiem cua he
			double x1 = D1 / D;
			double x2 = D2 / D;
			System.out.println("Hệ phương trình\n" + a11 + "x1 + " + a12 + "x2 = " + b1 +
					"\n" + a21 + "x1 + " + a22 + "x2 = " + b2 + "\n" +
					"x1 = " + x1 + "\n" +
					"x2 = " + x2);
		}
	}

	//Giai phuong trinh bac 2
	private static void GiaiPTBacHai(Scanner sc) {
		System.out.println("Giải phương trình bậc hai ax^2 + bx + c = 0");
		System.out.print("Nhập a: ");
		double a = sc.nextDouble();
		System.out.print("Nhập b: ");
		double b = sc.nextDouble();
		System.out.print("Nhập c: ");
		double c = sc.nextDouble();
		
		// Kiem tra a
		if (a == 0) {
			System.out.println("Lỗi: a không thể bằng 0.");
		} else {
			// Tính delta
			double D = b * b - 4 * a * c;
			
			if (D > 0) {
				double x1 = (-b + Math.sqrt(D)) / (2 * a);
				double x2 = (-b - Math.sqrt(D)) / (2 * a);
				System.out.println("Phương trình có hai nghiệm thực: x1 = " + x1 + " và x2 = " + x2 + "\n");		
			} else if (D == 0) {
				double x = -b / (2 * a);
				System.out.println("Phương trình vó một nghiệm kép: x = " + x);
			} else {
				System.out.println("Phương trình vô nghiệm.");
			}
		}
	}
}

