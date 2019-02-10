package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		List<Product> prodList = new ArrayList<>();

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of products: ");
		int number = scanner.nextInt();

		for (int i = 1; i <= number; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = scanner.next().charAt(0);
			System.out.print("Name: ");
			scanner.nextLine();
			String name = scanner.nextLine();
			System.out.print("Price: ");
			double price = scanner.nextDouble();
			
			if(ch == 'i' || ch == 'I') {	
				System.out.print("Customs fee: ");
				double customsFee = scanner.nextDouble();
				prodList.add(new ImportedProduct(name, price, customsFee));
			} 
			else if(ch == 'c' || ch == 'C') {
				prodList.add(new Product(name, price));
			}
			else if(ch == 'u' || ch == 'U') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(scanner.next());
				prodList.add(new UsedProduct(name, price, manufactureDate));
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		
		for (Product prod : prodList) {
			System.out.println(prod.priceTag());
		}

		scanner.close();
	}

}
