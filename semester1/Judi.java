public class Judi {
    public static void main(String[] args) {
        int money = 0;
        int goal = 2000;
        int bet = 10;
        long count = 0;
        while (money < goal) {
            int play = (int) Math.round(Math.random());
            count++;
            if (play==1) {
                money += bet;
                // bet = 10;
                // System.out.println(bet);
            } else {
                money -= bet;
                // bet *= 2;
                // System.out.println("-"+bet);
            }
            // System.out.println("--------------------------------------------------------");
            // System.out.println(money);
        }
        System.out.println("Games betted : "+count);
    }
}
