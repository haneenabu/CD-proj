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
            }else if (navigationChoice.equals("Add CD")){
                System.out.println("Alright, let's add a CD! What was the year of the album?");
                int userYear = Integer.parseInt(bufferedReader.readLine());
                System.out.println("Great! What is the name of the artist?");
                String userArtist = bufferedReader.readLine();
                System.out.println("Got it! What is the name of the album?");
                String userAlbum = bufferedReader.readLine();
                System.out.println("Finally, what is the price?");
                int userPrice = Integer.parseInt(bufferedReader.readLine());
                CD userCD = new CD(userArtist, userAlbum, userYear, userPrice);
                System.out.println("Alright, here's your new CD:");
                System.out.println("------------------");
                System.out.println(userCD.artistName);
                System.out.println(userCD.albumName);
                System.out.println(userCD.releaseYear);
                System.out.println(userCD.price);

            }else{
                System.out.println("oops");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
}
}
