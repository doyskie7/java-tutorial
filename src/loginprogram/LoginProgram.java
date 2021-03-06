package loginprogram;
import java.util.Scanner;
public class LoginProgram {
  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User userInput = new User();
        int tries = 1;
        
        System.out.println("Welcom to the World of Programming. \nMY LOGIN PROGRAM");
        System.out.print("Enter User ID:");
        userInput.UserId = scanner.nextLine();
            
        System.out.print("Enter User Password:");
        userInput.Password = scanner.nextLine();
        
        while(tries > 0){
            if(userInput.LoginTries >= 2){
                System.out.print("Try later \n");
                System.exit(0);
            }else{
                userInput = ValidateEntry(userInput.UserId,userInput.Password, tries);
            }
            tries++;
        }
        
    }
    public static User ValidateEntry(String UserId, String Password, int tries){
        StoredCredential checker = new StoredCredential();
        Scanner scanner = new Scanner(System.in);
        User userInput = new User();
        
        userInput.UserId = UserId;
        userInput.Password = Password;
        userInput.LoginTries = tries;
        
       
        
        if(!UserId.equals(checker.UserId) && Password.equals(checker.Password)){
            
            System.out.println("Wrong User ID \n");
            System.out.print("Enter User ID:");
            userInput.UserId = scanner.nextLine();          
            return userInput;
            
        }else if(!Password.equals(checker.Password) && UserId.equals(checker.UserId)){
            
            System.out.println("Wrong Password \n");
            System.out.print("Enter Password:");
            userInput.Password = scanner.nextLine();
            return userInput;
            
        }else if(!Password.equals(checker.Password) && !UserId.equals(checker.UserId)){
            
            System.out.println("Wrong User ID and Password \n");
            
            System.out.print("Enter User ID:");
            userInput.UserId = scanner.nextLine();
            
            System.out.print("Enter Password:");
            userInput.Password = scanner.nextLine();
            
            return userInput;
        }else {
            System.out.println("Welcome!");
            System.exit(0);
        }
        return userInput;
    }
}
