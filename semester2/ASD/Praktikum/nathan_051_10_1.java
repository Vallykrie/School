import java.util.Scanner;

public class nathan_051_10_1 {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        int n = than.nextInt();
        if (than.hasNextLine()) {
            than.nextLine();
        }
        
        WishlistItem[] wishlist = new WishlistItem[n];
        for (int i = 0; i < n; i++) {
            String[] input = than.nextLine().split(" ");
            String name = input[0];
            int price = Integer.parseInt(input[1]);
            wishlist[i] = new WishlistItem(name, price);
        }
        int uang = than.nextInt();
        if (than.hasNextLine()) {
            than.nextLine();
        }

        // Bubble Sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (wishlist[j].price > wishlist[j + 1].price) {
                    WishlistItem temp = wishlist[j];
                    wishlist[j] = wishlist[j + 1];
                    wishlist[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted Wishlist:");
        for (WishlistItem item : wishlist) {
            System.out.println(item.name + " = " + item.price);
        }

        System.out.println("\nRecommendation:");
        int totalSpent = 0;
        String itemsBought = "";

        for (WishlistItem item : wishlist) {
            if (totalSpent + item.price <= uang) {
            if (!itemsBought.isEmpty()) {
                itemsBought += ", ";
            }
            itemsBought += item.name;
            totalSpent += item.price;
            } else {
            break;
            }
        }

        if (totalSpent == 0) {
            System.out.println("Items bought = ");
        } else {
            System.out.println("Items bought = " + itemsBought);
        }
        System.out.println("Total spent = " + totalSpent);
    }
}

class WishlistItem {
    String name;
    int price;

    WishlistItem(String name, int price) {
        this.name = name;
        this.price = price;
    }
}