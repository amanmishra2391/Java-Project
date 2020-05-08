package machine;
import java.util.Scanner;
public class CoffeeMachine {
    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        coffee.action();
    }
}
class Coffee {
    int water;
    int milk;
    int coffeeBean;
    int noOfCup;
    int money;
    Scanner scanner = new Scanner(System.in);
    Coffee() {
        this.water = 400;
        this.milk = 540;
        this.coffeeBean = 120;
        this.noOfCup = 9;
        this.money = 550;
    }

    private void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " of water");
        System.out.println(this.milk + " of milk");
        System.out.println(this.coffeeBean + " of coffee beans");
        System.out.println(this.noOfCup + " of disposable cups");
        System.out.println("$" + this.money + " of money");

    }

    private String input() {
        String s = scanner.next();
        return s;
    }

    public void action() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String Action = input();
        switch (Action) {
            case "buy": buy();
            action();
            break;
            case "fill": fill();
            action();
            break;
            case "take": take();
            action();
            break;
            case "remaining": remaining();
            action();
            break;
            case "exit": break;
            default: action();
            break;
        }
    }

    private void buy() {
        System.out.println("What do you want to buy? 1 - expresso, 2 - latte, 3 - cappuccino, nack - to main menu:");
        String choice = input();
        int w = 0;
        int c = 0;
        int m = 0;
        int cup = 1;
        int mon = 0;
        switch (choice) {
            case "1": w = 250;
                c = 16;
                mon = 4;
                break;
            case "2": w = 350;
                m = 75;
                c = 20;
                mon = 7;
                break;
            case "3": w = 200;
                m = 100;
                c = 12;
                mon = 6;
                break;
            default: cup = 0;
                break;
        }
        if (this.water < w) {
            System.out.println("Sorry, not enough water");
        } else if (this.milk < m) {
            System.out.println("Sorry, not enough milk");
        } else if (this.coffeeBean < c) {
            System.out.println("Sorry, not enough coffee beans");
        } else if (this.noOfCup < cup) {
            System.out.println("Sorry, not enough disposable cups");
        } else {
            this.water -= w;
            this.milk -= m;
            this.coffeeBean -= c;
            this.noOfCup -= cup;
            this.money +=mon;
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    private void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        this.water += Integer.parseInt(input());
        System.out.println("Write how many ml of milk do you want to add:");
        this.milk += Integer.parseInt(input());
        System.out.println("Write how many grams of coffee beans do you want to add:");
        this.coffeeBean += Integer.parseInt(input());
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        this.noOfCup += Integer.parseInt(input());
    }

    private void take() {
        System.out.println("I gave you $" + this.money);
        this.money = 0;
    }
}
