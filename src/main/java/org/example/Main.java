package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Add Order");
        System.out.println("2. Update Order");
        System.out.println("3. Remove Order");
        System.out.println("4. View Order");
        System.out.println("5. Exit");

        boolean isExit = false;
        ArrayList<String> pizzas = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();

        do {
            System.out.print("Choose option: ");
            int option = -1;
            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (option){
                case 1:
                    System.out.print("Pizza type: ");
                    String pizzaType = sc.nextLine();
                    System.out.print("Quantity: ");
                    int quantity = -1;
                    try {
                        quantity = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid quantity. Please enter a number.");
                        break;
                    }
                    addOrder(pizzas, quantities, pizzaType, quantity);
                    break;
                case 2:
                    System.out.print("Order number to update: ");
                    int orderNumToUpdate = -1;
                    try {
                        orderNumToUpdate = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid order number. Please enter a number.");
                        break;
                    }
                    System.out.print("New quantity: ");
                    int newQuantity = -1;
                    try {
                        newQuantity = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid quantity. Please enter a number.");
                        break;
                    }
                    updateOrder(quantities, orderNumToUpdate - 1, newQuantity);
                    break;
                case 3:
                    System.out.print("Order number to remove: ");
                    int orderNumToRemove = -1;
                    try {
                        orderNumToRemove = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid order number. Please enter a number.");
                        break;
                    }
                    removeOrder(pizzas, quantities, orderNumToRemove - 1);
                    break;
                case 4:
                    printOrders(pizzas, quantities);
                    break;
                case 5:
                    System.out.println("---Thank you!---");
                    isExit = true;
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        } while (!isExit);
        sc.close();
    }
    public static void addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, String pizzaType, int quantity) {
        if (quantity > 0) {
            pizzas.add(pizzaType);
            quantities.add(quantity);
        } else {
            System.out.println("Quantity must be above zero.");
        }
    }
    public static void updateOrder(ArrayList<Integer> quantities, int index, int newQuantity){
        if (index >= 0 && index < quantities.size()){
            if (newQuantity > 0){
                quantities.set(index, newQuantity);
            } else {
                System.out.println("New quantity must be above zero.");
            }
        } else {
            System.out.println("Invalid order number. Please enter a valid order number.");
        }
    }
    public static void removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int index){
        if (index >= 0 && index < pizzas.size()) {
            pizzas.remove(index);
            quantities.remove(index);
        } else {
            System.out.println("Invalid order number. Please enter a valid order number.");
        }
    }
    public static void printOrders(ArrayList<String> pizzas, ArrayList<Integer> quantities){
        if (pizzas.isEmpty()) {
            System.out.println("No orders yet.");
        } else {
            System.out.println("--- Current Orders ---");
            for (int i = 0; i < pizzas.size(); i++) {
                System.out.printf("%d. %s x %d%n", i + 1, pizzas.get(i), quantities.get(i));
            }
        }
    }
}