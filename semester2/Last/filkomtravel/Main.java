import customer.*;
import order.*;
import promotion.Promotion;
import vehicle.*;
import java.util.Scanner;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * The Main class represents the main entry point of the Filkom Travel
 * application.
 * It provides functionality for user login, registration, and vehicle selection
 * for rental.
 * The class contains a main method that executes the application logic.
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner than = new Scanner(System.in);

        LinkedList<Guest> userList = new LinkedList<>(); // menyimpan user
        ArrayList<Menu> menuList = new ArrayList<>(); // menyimpan nilai menu
        ArrayList<Promotion> promoList = new ArrayList<>(); // menyimpan promo
        ArrayList<Order> orderList = new ArrayList<>(); // menyimpan promo

        while (than.hasNextLine()){
            String input[] = than.nextLine().split(" ");
            String command = " ";
            switch (input[0]) {
                case "CREATE":
                    switch (input[1]) {
                        case "MEMBER":
                            for (int j = 2; j < input.length; j++) {
                                command += input[j];
                            }
                            String[] value = command.split("\\|");
                            String idAnggota = value[0];
                            String nama = value[1];
                            String tanggalDaftar = value[2];
                            String saldoAwalMember = value[3];
                            String memberMessage = !Guest.idExists(idAnggota, userList)
                                    ? userList.add(new Member(idAnggota, nama, tanggalDaftar, saldoAwalMember))
                                            ? "CREATE MEMBER SUCCESS: " + idAnggota
                                            : "CREATE MEMBER FAILED: " + idAnggota + " IS EXISTS"
                                    : "CREATE MEMBER FAILED: " + idAnggota + " IS EXISTS";
                            System.out.println(memberMessage);
                            break;
                        case "GUEST":
                            for (int j = 2; j < input.length; j++) {
                                command += input[j];
                            }
                            String[] valueGuest = command.split("\\|");
                            String idTamu = valueGuest[0];
                            String saldoAwalGuest = valueGuest[1];
                            String guestMessage = !Guest.idExists(idTamu, userList)
                                    ? userList.add(new Guest(idTamu, saldoAwalGuest))
                                            ? "CREATE GUEST SUCCESS: " + idTamu
                                            : "CREATE GUEST FAILED: " + idTamu + " IS EXISTS"
                                    : "CREATE GUEST FAILED: " + idTamu + " IS EXISTS";
                            System.out.println(guestMessage);
                            break;
                        case "MENU":
                            for (int j = 3; j < input.length; j++) {
                                command += input[j];
                            }
                            String[] menuValues = command.split("\\|");
                            String idMenu = menuValues[0];
                            String namaMenu = menuValues[1];
                            String platNomor = menuValues[2];
                            int harga = Integer.parseInt(menuValues[3]);

                            String menuMessage;
                            if (menuValues.length > 4) {
                                String customType = menuValues[4];
                                menuMessage = !Menu.idExists(idMenu, menuList)
                                        && !Menu.platNomorExists(platNomor, menuList)
                                                ? menuList.add(new Menu(idMenu, namaMenu, platNomor, harga, customType))
                                                        ? "CREATE MENU SUCCESS: " + idMenu + " " + namaMenu + " "
                                                                + platNomor
                                                        : "CREATE MENU FAILED: " + idMenu
                                                : Menu.idExists(idMenu, menuList)
                                                        ? "CREATE MENU FAILED: " + idMenu + "IS EXISTS"
                                                        : "CREATE MENU FAILED: " + platNomor + "IS EXISTS";
                            } else {
                                menuMessage = !Menu.idExists(idMenu, menuList)
                                        && !Menu.platNomorExists(platNomor, menuList)
                                                ? menuList.add(new Menu(idMenu, namaMenu, platNomor, harga))
                                                        ? "CREATE MENU SUCCESS: " + idMenu + " " + namaMenu + " "
                                                                + platNomor
                                                        : "CREATE MENU FAILED: " + idMenu
                                                : Menu.idExists(idMenu, menuList)
                                                        ? "CREATE MENU FAILED: " + idMenu + "IS EXISTS"
                                                        : "CREATE MENU FAILED: " + platNomor + "IS EXISTS";
                            }
                            System.out.println(menuMessage);
                            break;
                        case "PROMO":
                            
                            break;
                        default:
                            break;
                    }
                    break;
                case "ADD_TO_CART":
                    String idPemesan = input[1];
                    String idMenuCart = input[2];
                    int qty = Integer.parseInt(input[3]);
                    String tanggalAwal = input[4];

                    Guest user = findUserById(idPemesan, userList);
                    Menu menuItem = findMenuById(idMenuCart, menuList);

                    if (user != null && menuItem != null) {
                        if (Order.orderExists(idPemesan, idMenuCart, orderList)) {
                            Order existingOrder = Order.findOrder(idPemesan, idMenuCart, orderList);
                            existingOrder.setQty(existingOrder.getQty() + qty);
                            System.out.printf("ADD_TO_CART SUCCESS: %d days %s %s (UPDATED)\n", existingOrder.getQty(),
                                    menuItem.getNamaMenu(), menuItem.getPlatNomor());
                        } else {
                            Order newOrder = new Order(idPemesan, idMenuCart, qty, tanggalAwal);
                            orderList.add(newOrder);
                            System.out.printf("ADD_TO_CART SUCCESS: %d day %s %s (NEW)\n", qty, menuItem.getNamaMenu(),
                                    menuItem.getPlatNomor());
                        }
                    } else {
                        System.out.printf("ADD_TO_CART FAILED: NON EXISTENT CUSTOMER OR MENU\n");
                    }
                    break;
                case "REMOVE_FROM_CART":
                    String idPemesanRemove = input[1];
                    String idMenuCartRemove = input[2];
                    int qtyRemove = Integer.parseInt(input[3]);
                    Guest userRemove = findUserById(idPemesanRemove, userList);
                    Menu menuItemRemove = findMenuById(idMenuCartRemove, menuList);
                    if (userRemove != null && menuItemRemove != null) {
                        if (Order.orderExists(idPemesanRemove, idMenuCartRemove, orderList)) {
                            Order existingOrderRemove = Order.findOrder(idPemesanRemove, idMenuCartRemove, orderList);
                            int newQty = existingOrderRemove.getQty() - qtyRemove;
                            if (newQty > 0) {
                                existingOrderRemove.setQty(newQty);
                                System.out.printf("REMOVE_FROM_CART SUCCESS: %s %s DURATION IS DECREMENTED to %d\n",
                                        menuItemRemove.getNamaMenu(), menuItemRemove.getPlatNomor(), newQty);
                            } else {
                                orderList.remove(existingOrderRemove);
                                System.out.printf("REMOVE_FROM_CART SUCCESS: %s %s DURATION IS REMOVE\n",
                                        menuItemRemove.getNamaMenu(), menuItemRemove.getPlatNomor());
                            }
                        }
                    } else {
                        System.out.printf("REMOVE_FROM_CART FAILED: NON EXISTENT CUSTOMER OR MENU\n");
                    }
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

    private static Guest findUserById(String id, LinkedList<Guest> userList) {
        for (Guest user : userList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    private static Menu findMenuById(String id, ArrayList<Menu> menuList) {
        for (Menu menu : menuList) {
            if (menu.getIdMenu().equals(id)) {
                return menu;
            }
        }
        return null;
    }
}
