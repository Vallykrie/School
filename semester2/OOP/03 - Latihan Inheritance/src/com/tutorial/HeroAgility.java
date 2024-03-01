package com.tutorial;

public class HeroAgility extends Hero{
    String type = "Agility";

    /**
     * 
     * @param nameInput
     * @param attackInput
     * @param healthInput
     */
    HeroAgility(String nameInput, double attackInput, double healthInput){
        super(nameInput, attackInput, healthInput);
    }

    @Override
	void display(){
		super.display();
		System.out.println("Type : " + this.type);
	}

    @Override
    void attack(Hero enemy){
        double RNG = Math.random();
        System.out.println("\n//" + this.name + " attack " + enemy.name);
        if (RNG >= 0.5) {
            System.out.println("\n" + this.name + " dealt damage " + this.attackPower);
            System.out.println(this.name + " dealt damage " + this.attackPower);
            double damage = this.attackPower*2;
            enemy.takeDamage(damage); 
        } else {
            System.out.println("\n" + this.name + " dealt damage " + this.attackPower);
            enemy.takeDamage(this.attackPower); 

        }
	}
  

	@Override
	void takeDamage(double damage){
        double RNG = Math.random();
        if (RNG >= 0.8) {
            System.out.println(this.name + " dodged, no damage taken. " );
        } else {
            System.out.println(this.name + " receive damage " + damage);
            this.health = this.health - damage;
        }

    }
}
