package com.tutorial;


public class Main {
	public static void main(String[] args) {
		Hero Tanjiro = new HeroIntelligence("Tanjiro",2,100);
		Hero Zenitsu = new HeroStrength("Zenitsu", 1, 175);
		Hero Nezuko = new HeroAgility("Nezuko", 1.5, 125);

		Tanjiro.display();
		Nezuko.display();

		while (Tanjiro.health>=0 || Nezuko.health>=0) {
			Tanjiro.attack(Nezuko);
			Nezuko.attack(Tanjiro);
			
		}

		Tanjiro.display();
		Nezuko.display();
	}
}