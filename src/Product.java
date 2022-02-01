import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Product {

    int id;
    String title;
    String description;
    int price;
    boolean inStock;
    float volume;

    public Product(int id, String title, String description, Integer price, boolean inStock, float volume) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.inStock = inStock;
        this.volume = volume;
    }

    public void showInfo(){
        System.out.println("title: " + title + "\n" + "id: " + id + "\n"+ "description: " + description + "\n" + "price: " + price + "\n" + "inStock: " + inStock + "\n" + "volume: " + volume + "\n");
    }

    public boolean isAvailable(){
        return inStock;
    }

    static int total = 0;
    static int money = 500;

    public static void askToBuy(){
        Scanner sc = new Scanner(System.in);
        int askToBuy = sc.nextInt();
        System.out.println("You choose: " + askToBuy);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        System.out.println("We have:");
        System.out.println("What do you want to buy? " + " (you have " + money + ")");

        Product smallBottle = new Product(1, "Small Bottle", "desc", 50, true, 0.5F);
        smallBottle.showInfo();
        System.out.println("Do you want to buy this?");

        Scanner sc = new Scanner(System.in);
        String askToBuy = sc.nextLine();

        if(!smallBottle.isAvailable()){
            System.out.println("PRODUCT IS NOT AVAILABLE!");
            askToBuy = "N";
        }
        if(askToBuy.equals("Y")){
            list.add(smallBottle.title);
            total += smallBottle.price;
        }if(askToBuy.equals("N")){
            System.out.println("You didn't buy this");
        }

        Product bottle = new Product(2, "Bottle", "desc", 100, true, 1F);
        bottle.showInfo();
        System.out.println("Do you want to buy this?");

        askToBuy = sc.nextLine();
        if(!bottle.isAvailable()){
            System.out.println("PRODUCT IS NOT AVAILABLE!");
            askToBuy = "N";
        }if(askToBuy.equals("Y")){
            list.add(bottle.title);
            total += bottle.price;
        }if(askToBuy.equals("N")){
            System.out.println("You didn't buy this");
        }

        Product bigBottle = new Product(3, "Big Bottle", "desc", 200, false, 2F);
        bigBottle.showInfo();

        System.out.println("Do you want to buy this?");

        askToBuy = sc.nextLine();
        if(!bigBottle.isAvailable()){
            System.out.println("PRODUCT IS NOT AVAILABLE!");
            askToBuy = "N";
        }if(askToBuy.equals("Y")){
            list.add(bigBottle.title);
            total += bigBottle.price;
        }if(askToBuy.equals("N")){
            System.out.println("You didn't buy this");
        }

        System.out.println("In your cart you have: " + list);
        System.out.println("Total: " + total + " Now you have: " + (money -= total));
    }

}