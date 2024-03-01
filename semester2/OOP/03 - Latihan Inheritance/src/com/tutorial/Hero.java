package com.tutorial;

public class Hero{

	/* Concept
	 * Strength
	 *  - Dealt .75 damage
	 *  - Receive .5 damage
	 * 
	 * Intelligence
	 *  - Dealt 2 damage
	 *  - Receive 1.5 damage
	 * 
	 * Agility
	 *  - 50% Chance to move 2 times
	 *  - 20% Chance to dodge damage
	 * 
	 * 
	 * 
	 * 
	 */
	
	// attribute
	String name;
	double attackPower, health;

	// constructor
	Hero(String nameInput, double attackInput, double healthInput){
		this.name = nameInput;
		this.attackPower = attackInput;
		this.health = healthInput;
	}

	// method attack
	void attack(Hero enemy){
		System.out.println("\n//" + this.name + " attack " + enemy.name);
		enemy.takeDamage(this.attackPower);
	}

	void takeDamage(double damage){
		System.out.println(this.name + " receive damage " + damage);
		this.health = this.health - damage;
	}

	void display(){
		System.out.println("\nName: " + this.name);
		System.out.println("Health: " + this.health);
		System.out.println("Power: " + this.attackPower);
	}
}