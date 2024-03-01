package com.tutorial;
import java.util.Scanner;

// player
class Player{
    String name;
    double health;
    int level;
    // object member
    Weapon weapon;
    Armor armor;

    Player(String name, double health){
        this.name = name;
        this.health = health;
    }

    void attack(Player opponent){
        double attackPower = this.weapon.attackPower;

        System.out.println(this.name + " attacking " + opponent.name + " with power " + attackPower);
        opponent.defence(attackPower);
    }

    void defence(double attackPower){
        // akan mengambil damage
        double damage;
        if (this.armor.defencePower < attackPower){
            damage = attackPower - this.armor.defencePower;
        } else {
            damage = 1;
        }

        this.health -= damage;
        System.out.println(this.name + " gets damage " + damage);
    }
    
    void equipWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    void equipArmor(Armor armor){
        this.armor = armor;
    }

    void display(){
        System.out.println("\nName\t: " + this.name);
        System.out.println("Health\t: " + this.health + " hp");
        this.weapon.display();
        this.armor.display();
    }
}

// senjata
class Weapon{
    double attackPower;
    String name;

    Weapon(String name, double attackPower){
        this.name = name;
        this.attackPower = attackPower;
    }

    void display(){
        System.out.println("Weapon\t: " + this.name + "\t( " + this.attackPower + " atk )");
    }
}

// armor
class Armor{
    double defencePower;
    String name;

    Armor(String name, double defencePower){
        this.name = name;
        this.defencePower = defencePower;
    }

    void display(){
        System.out.println("Armor\t: " + this.name + "\t( " + this.defencePower + " def )");
    }
}

public class Main{

    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        
        // membuat object player
        Player player1 = new Player("Ucup",100);
        Player player2 = new Player("Otong",50);

        // membuat object weapon
        Weapon pedang = new Weapon("Pedang",15);
        Weapon ketapel = new Weapon("Tongkat",12);

        // membuat object armor
        Armor bajuBesi = new Armor("Baju Besi",10);
        Armor kaos = new Armor("Jubah Hitam",20);
        
        // player 1
        player1.equipWeapon(pedang);
        player1.equipArmor(bajuBesi);
        

        // player 2
        player2.equipWeapon(ketapel);
        player2.equipArmor(kaos);
        
        // Game Start
        divider();
        System.out.println("Choose Your Character :");
        System.out.println("1.");
        player1.display();
        System.out.println();
        System.out.println("2.");
        player2.display();
        System.out.print("Type 1 or 2 : ");
        int whichChar = than.nextInt();
        int count = 1;
        if (whichChar == 1) {
            while (player1.health > 0 && player2.health > 0) {
                player1.attack(player2);
                player2.attack(player1);
                divider();
                System.out.println("Pertandingan " + count + " selesai.");
                player1.display();
                player2.display();
                System.out.println();
                count++;

            }
            if (player1.health <= 0) {
                System.out.println("You lose! Nice try!");
                
            } else System.out.println("You Win! Congrats!");
        } else {
            while (player1.health > 0 && player2.health > 0) {
                player2.attack(player1);
                player1.attack(player2);
                divider();
                System.out.println("Pertandingan " + count + " selesai.");
                player1.display();
                player2.display();
                System.out.println();
                count++;

            }
            if (player2.health <= 0) {
                System.out.println("You lose! Nice try!");
                
            } else System.out.println("You Win! Congrats!");

        }

        
    }

    static void divider(){
        System.out.println("=".repeat(50));
    }
}