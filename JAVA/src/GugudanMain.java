
import java.util.Scanner;

public class GugudanMain {
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		String inputValue = scanner.nextLine();
		
		String[] splitedValue = inputValue.split(",");
		if (splitedValue.length == 1) {
			int first = Integer.parseInt(splitedValue[0]);
			for(int i = 2; i <= first; i++) {
				for(int k = 1;k < 10; k++) {
					System.out.println(i + " * " + k + " = " + i * k);
				}
			}

			
		}else if(splitedValue.length == 2) {
			int first = Integer.parseInt(splitedValue[0]);
			int second = Integer.parseInt(splitedValue[1]);
			for(int i = 2; i <= first; i++) {
				for(int k = 1;k <= second; k++) {
					System.out.println(i + " * " + k + " = " + i * k);
				}
			}
			
		}else {
			System.out.println("error!");
		}
		
	}
}
