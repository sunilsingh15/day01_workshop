package sg.edu.nus.iss;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        System.out.println("Welcome to your shopping cart \n");

        List<String> cartItems = new ArrayList<String>();

        Console con = System.console();
        String input = "";
        
        while(!input.equals("quit")) {
            input = con.readLine("Type 'help' to show list of commands >>");

            if (input.equals("help")) {
                System.out.println("'list' to show a list of items in the shopping cart");
                System.out.println("'add <item name>' to add to your cart");
                System.out.println("'delete <item number>' to remove an item from your cart");
                System.out.println("'quit' to terminate the program");
            }

            if (input.startsWith("add")) {

                input = input.replace(',', ' ');
                Scanner scan = new Scanner(input.substring(4));
                String content = "";

                while (scan.hasNext()) {
                    content = scan.next();

                    if (cartItems.contains(content)) {
                        System.out.println("You have " + content + " in your cart");
                    } else {
                        cartItems.add(content);
                        System.out.println(content + " added to cart");
                    }
                    
                }
            }
            
            if (input.equals("list")) {

                if (cartItems.size() > 0) {

                int i = 0;
                for (String item: cartItems) {
                    i++;
                    System.out.println(i + ". " + item);
                }
            } else {
                System.out.println("Your cart is empty");
            }
                
            }

            if (input.startsWith("delete")) {
                Scanner scan = new Scanner(input.substring(6));
                String content = "";

                while (scan.hasNext()) {
                    content = scan.next();

                    int listIndex = Integer.parseInt(content);
                    listIndex--;

                    if (listIndex < cartItems.size()) {
                        System.out.println(cartItems.get(listIndex) + " removed from cart");
                        cartItems.remove(listIndex);                        
                    } else {
                        System.err.println("Incorrect item index");
                    }
                    
                }
                
            }

        }

        System.out.println("Goodbye!");

    }
}
