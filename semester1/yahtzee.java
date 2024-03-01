public class yahtzee {
    public static void main(String[] args) {
        int dice1 = (int) (Math.random()*6)+1;
        int dice2 = (int) (Math.random()*6)+1;
        int dice3 = (int) (Math.random()*6)+1;
        int dice4 = (int) (Math.random()*6)+1;
        int dice5 = (int) (Math.random()*6)+1;
        int count = 1;
        while (!(dice1 == dice2 && dice1 == dice3 && dice1 == dice4 && dice1 == dice5)) {
            dice1 = (int) (Math.random()*6)+1;
            dice2 = (int) (Math.random()*6)+1;
            dice3 = (int) (Math.random()*6)+1;
            dice4 = (int) (Math.random()*6)+1;
            dice5 = (int) (Math.random()*6)+1;
            count += 1;
        }
        System.out.println(count);
    }
    
}
