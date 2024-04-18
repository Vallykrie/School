import java.util.Scanner;

class Character {
    protected int health;

    public Character() {
        this.health = 100;
    }

    public void attack(Character target, int damage) {
        System.out.println(getClass().getSimpleName() + " attacks with " + damage + " damage.");
        target.getDamage(damage);
    }

    public void getDamage(int damage) {
        this.health -= damage;
        System.out.println(getClass().getSimpleName() + " receives " + damage + " damage.");
    }

    public void heal(int medic) {
        System.out.println(getClass().getSimpleName() + " heals with " + medic + " health points.");
        health = Math.min(100, health + medic);
        System.out.println(getClass().getSimpleName() + "'s health is now " + health);
    }

    public boolean isAlive() {
        return health > 0;
    }
}

class Enemy extends Character {
}

class Player extends Character {
}

public class test1 {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        Player player = new Player();
        Enemy enemy = new Enemy();
        boolean playerTurn = true;

        while (than.hasNextLine()) {
            int action, value;
            if (playerTurn) {
                action = than.nextInt();
                value = than.nextInt();
                if (than.hasNextLine()) {
                    than.nextLine();

                }
                if (action == 1) {
                    player.attack(enemy, value);
                } else if (action == 2) {
                    if (player.health + value > 100) {
                        System.out.println("Player's health is already at maximum.");
                    } else {
                        player.heal(value);
                    }
                }
            } else {
                int enemyAction = than.nextInt();
                int enemyValue = than.nextInt();
                if (than.hasNextLine()) {
                    than.nextLine();

                }
                if (enemyAction == 1) {
                    enemy.attack(player, enemyValue);
                } else if (enemyAction == 2) {
                    if (enemy.health + enemyValue > 100) {
                        System.out.println("Enemy's health is already at maximum.");
                    } else {
                        enemy.heal(enemyValue);
                    }
                }
            }
            playerTurn = !playerTurn;
        }

        if (player.isAlive()) {
            System.out.println("PLAYER WINS");
        } else {
            System.out.println("ENEMY WINS");
        }
    }
}
