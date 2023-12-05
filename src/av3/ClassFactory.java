package av3;
import java.util.Scanner;

import Entities.Entity;
import Entities.Mage;
import Entities.Rogue;
import Entities.Warrior;


public class ClassFactory {
	public static Scanner sc = new Scanner(System.in);
	 
	public static Entity createClass() {
		System.out.println("1 - Guerreiro");
		System.out.println("2 - Mago");
		System.out.println("3 - Ladino");
			
		
		
		while(true) {
			int choice = sc.nextInt();
			
			if (choice == 1) {
				return new Warrior();
			} else if (choice == 2) {
				return new Mage();
			} else if (choice == 3) {
				return new Rogue();
			} else {
				System.out.println("Opção inválida, tente novamente.");
			}
		}	
		
	}
	
}
