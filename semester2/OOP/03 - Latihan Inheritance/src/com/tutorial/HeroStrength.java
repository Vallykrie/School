package com.tutorial;

public class HeroStrength extends Hero{
	String type = "Strength";

	// subclass constructor
	HeroStrength(String nameInput, double attackInput, double healthInput){
		super(nameInput, attackInput, healthInput);
	}

	@Override
	void display(){
		super.display();
		System.out.println("Type : " + this.type);
	}

    @Override
    void attack(Hero enemy){
		System.out.println("\n//" + this.name + " attack " + enemy.name);
		System.out.println("\n" + this.name + " dealt third quarter damage " + this.attackPower + " -> " +  this.attackPower*0.75);
        double damage = this.attackPower*0.75;
		enemy.takeDamage(damage);
	}

	@Override
	void takeDamage(double damage){
		System.out.println(this.name + " receive half damage " + damage + " -> " + 0.5*damage);
		this.health = this.health - 0.5*damage;
	}
}