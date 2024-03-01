import java.util.*;

public class ConfusedPlayerManager {
    static class Player {
        int id, offensive, defensive, offensiveRank, defensiveRank, overallRank;

        Player(int id, int off, int def) {
            this.id = id;
            this.offensive = off;
            this.defensive = def;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPlayers;
        numPlayers = scanner.nextInt();
        Player[] players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player(i + 1, scanner.nextInt(), 0);
        }
        for (int i = 0; i < numPlayers; i++) {
            players[i].defensive = scanner.nextInt();
        }
        int numCommands;
        numCommands = scanner.nextInt();
        scanner.nextLine();
        while (numCommands-- > 0) {
            String[] inputCommand = scanner.nextLine().split(" ");
            switch (inputCommand[0]) {
                case "display":
                    switch (inputCommand[1]) {
                        case "skills":
                            System.out.print("Offensive Skills: ");
                            for (int i = 0; i < numPlayers; i++) {
                                System.out.print(players[i].offensive + " ");
                            }
                            System.out.println();
                            System.out.print("Defensive Skills: ");
                            for (int i = 0; i < numPlayers; i++) {
                                System.out.print(players[i].defensive + " ");
                            }
                            System.out.println();
                            break;
                        default:
                            Arrays.sort(players, Comparator.comparingInt((Player p) -> p.offensive).reversed());
                            for (int i = 0, rank = 1; i < numPlayers; i++) {
                                if (i > 0 && players[i].offensive < players[i - 1].offensive) rank = i + 1;
                                players[i].offensiveRank = rank;
                            }
                            Arrays.sort(players, Comparator.comparingInt((Player p) -> p.defensive).reversed());
                            for (int i = 0, rank = 1; i < numPlayers; i++) {
                                if (i > 0 && players[i].defensive < players[i - 1].defensive) rank = i + 1;
                                players[i].defensiveRank = rank;
                            }
                            Arrays.sort(players, Comparator.comparingInt((Player p) -> p.offensiveRank + p.defensiveRank));
                            for (int i = 0, rank = 1; i < numPlayers; i++) {
                                if (i > 0 && players[i].offensiveRank + players[i].defensiveRank > players[i - 1].offensiveRank + players[i - 1].defensiveRank)
                                    rank = i + 1;
                                players[i].overallRank = rank;
                            }
                            Arrays.sort(players, Comparator.comparingInt((Player p) -> p.id));
                            System.out.print("Offensive Ranks: ");
                            for (int i = 0; i < numPlayers; i++) {
                                System.out.print(players[i].offensiveRank + " ");
                            }
                            System.out.println();
                            System.out.print("Defensive Ranks: ");
                            for (int i = 0; i < numPlayers; i++) {
                                System.out.print(players[i].defensiveRank + " ");
                            }
                            System.out.println();
                            System.out.print("Overall Ranks: ");
                            for (int i = 0; i < numPlayers; i++) {
                                System.out.print(players[i].overallRank + " ");
                            }
                            System.out.println();
                            break;
                    }
                    break;
                default:
                    int playerIndex = Integer.parseInt(inputCommand[2]) - 1;
                    int points = Integer.parseInt(inputCommand[3]);
                    switch (inputCommand[1]) {
                        case "offensive":
                            players[playerIndex].offensive += points;
                            players[playerIndex].defensive -= points / 2;
                            break;
                        default:
                            players[playerIndex].defensive += points;
                            players[playerIndex].offensive -= points / 2;
                            break;
                    }
                    System.out.println("Training " + inputCommand[1] + " skill of player " + (playerIndex + 1) + " by " + points + " points");
                    break;
            }
        }
    }
}
