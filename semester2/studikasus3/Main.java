package studikasus3;

public class Main {
    public static void main(String[] args) {
        java.util.Scanner than = new java.util.Scanner(System.in);
        while (than.hasNextLine()) {
            String[] input = than.nextLine().split(" ");
            switch (input[0]) {
                case "CREATE":
                    switch (input[1]) {
                        case "MEMBER":
                            String[] inpt = input[3].split("|");
                            addMember(inpt[0], inpt[1], inpt[2], inpt[3]);
                            break;
                        case "GUEST":
                            inpt = input[3].split("|");
                            addGuest(inpt[0], inpt[1]);
                            break;
                        case "MENU":
                            inpt = input[3].split("|");
                            addMenu(inpt[0], inpt[1], inpt[2], inpt[3]);
                            break;
                        case "PROMO":
                            String jenisPromo = input[3];
                            inpt = than.nextLine().split("|");
                            addGuest(jenisPromo, inpt[1], inpt[2], inpt[3], inpt[4], inpt[5], inpt[6]);
                            break;
                        default:
                            break;
                    }
                    break;
                case "ADD_TO_CART":
                    addToCart(input[1], input[2], input[3], input[4]);
                    break;
                case "REMOVE_FROM_CART":
                    removeFromCart(input[1], input[2], input[3]);
                    break;
                case "APPLY_PROMO":

                    break;
                case "TOPUP":
                    break;
                case "CHECK_OUT":
                    break;
                case "PRINT":
                    break;
                case "PRINT_HISTORY":
                    break;

                default:
                    break;
            }
        }
    }
}
