
import java.util.Arrays;
import java.util.Scanner;
public class SortedArray {

	public static void main(String[] args) {
		int n;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Nhap vao do dai cua mang: ");
		n = input.nextInt();
		
		int[] arr = new int[n];
		float sum = 0;
		System.out.println("Nhap vao cac phan tu cua mang: ");
		for (int i = 0; i < n; i++) {
			arr[i] = input.nextInt();
			sum += arr[i];
		}
		
		System.out.println("Mang da sap xep la: ");
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.printf("Sum: %.2f\n", sum);
		System.out.printf("Average: %.2f", sum/n);
		
		input.close();
	}

}
