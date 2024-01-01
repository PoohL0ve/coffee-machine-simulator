package machine;

import java.util.*;
public class CoffeeMachine {
    public static Coffee javaCoffee = new Coffee();
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {

                System.out.println("Write action (buy, fill, take, remaining, exit): ");
                String option = scanner.nextLine().toLowerCase();

                if (option.equals("buy")) {
                    System.out.println();
                    System.out.println("What do you want to buy?" +
                            " 1 - espresso, 2 - latte, 3 - cappuccino," +
                            " back - to main menu:");
                    String choose = scanner.nextLine();
                    if (choose.equals("1") || choose.equals("2") || choose.equals("3")) {
                        int coffee = Integer.parseInt(choose);
                        buyCoffee(coffee);
                    } else if (choose.equals("back")) {
                        continue;
                    }
                }
                else if (option.equals("fill")) {
                    System.out.println();
                    System.out.println("Write how many ml of water you want to add: ");
                    int water = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Write how many ml of milk you want to add: ");
                    int milk = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Write how many grams of coffee beans you want to add: ");
                    int beans = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Write how may disposable cups you want to add: ");
                    int cups = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println();
                    fillMachine(water, milk, beans, cups);
                }
                else if (option.equals("take")) {
                    System.out.println();
                    takeAll();
                }
                else if (option.equals("remaining")) {
                    System.out.println();
                    update();
                }
                else if (option.equals("exit")) {
                    break;
                }
            }
        }
    }

    public static void update() {
        int water = javaCoffee.getAmountWater();
        int milk = javaCoffee.getAmountMilk();
        int beans = javaCoffee.getAmountBeans();
        int cups = javaCoffee.getCups();
        int cash = javaCoffee.getCash();

        System.out.println("The coffee machine has: ");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + cash + " of money");
        System.out.println();
    }
   /* public static void howMany(Coffee want) {
        //boolean canIt = want.canMakeIt();
        int numberOfCups = want.howManyCups();
        int wanted = want.getCups();

        if (canIt) {
            if (numberOfCups == wanted) {
                System.out.println("Yes, I can make that amount of coffee");
            } else if (numberOfCups > wanted) {
                int remaining = numberOfCups - wanted;
                System.out.println("Yes, I can make that amount of coffee (and " +
                        "even " + remaining + " more than that)");
            }
        } else {
            System.out.println("No, I can make only " + numberOfCups + " cups(s)" +
                    " of coffee");
        }
    } */

    public static void buyCoffee(int number) {
        String coffeeType = "";
        if (number == 1) {
            coffeeType += "Espresso";
        } else if (number == 2) {
            coffeeType += "Latte";
        } else if (number == 3) {
            coffeeType += "Cappuccino";
        }

        boolean canIt = javaCoffee.canMakeIt(coffeeType);
        if (canIt) {
            javaCoffee.makeCoffee(coffeeType);
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            System.out.println("Sorry, not enough " + javaCoffee.getNotEnough() + "!");
        }
        System.out.println();

    }

    public static void fillMachine(int water, int milk, int beans, int cups) {
        javaCoffee.setAmountWater(water);
        javaCoffee.setAmountMilk(milk);
        javaCoffee.setAmountBeans(beans);
        javaCoffee.setCups(cups);
       // System.out.println();
    }

    public static void takeAll() {
        System.out.println("I give you $" +javaCoffee.getCash());
        javaCoffee.takeMoney();
        System.out.println();
    }
}
