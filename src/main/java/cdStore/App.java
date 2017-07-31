package cdStore;
import cdStore.CD;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Guest on 7/31/17.
 */
public class App {
    public static void main(String[] args) {
        CD Shakira = new CD("Shakira", "Greatest Hits", 1997, 10);
        CD Tupac = new CD("Tupac", "Greatest Hits", 1998, 12);
        CD GreenDay = new CD("GreenDay", "Greatest Collection", 1995, 11);

        CD[] allCDs = {Shakira, Tupac, GreenDay};

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to our CD Collection. What would you like to do? Enter one of the following options: All CDs, Search by Artist, Search by Release Year, Search by Price or Add CD");

        try{
            String navigationChoice = bufferedReader.readLine();
            if (navigationChoice.equals("All CDs")){
                for (CD individualCD : allCDs){
                    System.out.println("------------");
                    System.out.println(individualCD.artistName);
                    System.out.println(individualCD.albumName);
                    System.out.println(individualCD.releaseYear);
                    System.out.println(individualCD.price);
                }
            }else if (navigationChoice.equals("Search by Artist")){
                System.out.println("Enter your Artist Name:");
                String artistName = bufferedReader.readLine();
                System.out.println("Here's what we have for your Artist: ");
                for (CD individualCD : allCDs){
                    if (artistName.equals(individualCD.artistName)){
                        System.out.println("------------");
                        System.out.println(individualCD.albumName);
                    }
                }

         } else if (navigationChoice.equals("Search by Release Year")){
                System.out.println("Enter a release year in 1995, 1997, or 1998: :");
                Integer releaseYear = Integer.parseInt(bufferedReader.readLine());
                System.out.println("Here are the available options: ");
                for (CD individualCD : allCDs){
                    if (releaseYear.equals(individualCD.releaseYear)){
                        System.out.println("------------");
                        System.out.println(individualCD.artistName);
                        System.out.println(individualCD.albumName);
                        System.out.println(individualCD.releaseYear);
                        System.out.println(individualCD.price);
                    }
                }
            }else if (navigationChoice.equals("Search by Price")){
                System.out.println("What is your budget for a CD?");
                int maxUserBudget = Integer.parseInt(bufferedReader.readLine());
                System.out.println("Here's what we have in your price range: ");
                for (CD individualCD : allCDs){
                    if (individualCD.worthBuying(maxUserBudget)){
                        System.out.println("------------");
                        System.out.println(individualCD.artistName);
                        System.out.println(individualCD.albumName);
                        System.out.println(individualCD.releaseYear);
                        System.out.println(individualCD.price);
                    }
                }
            }else{
                System.out.println("oops");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
}
}
