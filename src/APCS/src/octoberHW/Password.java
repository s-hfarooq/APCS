package octoberHW;

import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);    
       String password = "Bunnies are fluffy";
       
       System.out.print("Enter password: ");
       String guess = input.nextLine();
       
       if(guess.equals(password))
           System.out.println("You may enter");
       else
           System.out.println("Wrong!!");
    }
}