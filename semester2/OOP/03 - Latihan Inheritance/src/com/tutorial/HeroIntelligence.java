package com.tutorial;

public class HeroIntelligence extends Hero{
    String type = "Intelligence";

    HeroIntelligence(String nameInput, double attackInput, double healthInput){
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
		System.out.println("\n" + this.name + " dealt twice damage " + this.attackPower + " -> " +  this.attackPower*2);
        double damage = this.attackPower*2;
		enemy.takeDamage(damage);
	}

	@Override
	void takeDamage(double damage){
		System.out.println(this.name + " receive half more damage " + damage + " -> " + 1.5*damage);
		this.health = this.health - 1.5*damage;
	}
}
