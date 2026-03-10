import java.util.Scanner;
import java.util.Random;

public class TeachingWereWolfGame {

    static class Player{
        private int id;
        private String role;
        private boolean alive;

        public Player(int id, String role, boolean alive) {
            this.id = id;
            this.role = role;
            this.alive = alive;
        }

        public int getId(){
            return id;
        }

        public String getRole(){
            return role;
        }

        public boolean isAlive(){
            return alive;
        }

        public void kill(){
            alive = false;
        }

        public String getPublicInfo(){
            if(isAlive()){
                return "Player " + id + " is alive";
            } else {
                return "Player " + id + " is dead";
            }
        }

        public static int findAliveWerewolf(Player[] players){
            for (int i = 0; i < players.length; i++){
                if(players[i].isAlive() && players[i].getRole().equals("Werewolf")){
                    return i;
                }
            }
            return -1;
        }

        public static void printAlivePlayers(Player[] players){
            for (Player player : players) {
                if (player.isAlive()) {
                    System.out.println(player.getPublicInfo());
                }
            }
        }

        static Scanner sc = new Scanner(System.in);
        static Random rand = new Random();
        public void main(String[] args) {

            System.out.println("Wolf Game!");
            System.out.println("Welcome to the game, Enter the number of players!");

            int numPlayers = sc.nextInt();
            sc.nextLine();

            while(numPlayers < 4 || numPlayers > 10){
                System.out.println("Number of players must be between 4 and 10");
                numPlayers = sc.nextInt();
                sc.nextLine();
            }

            Player[] players = new Player[numPlayers];
            int WolfIndex = rand.nextInt(numPlayers);

            for (int i = 0 ; i < numPlayers; i++){
                if(i == WolfIndex){
                    players[i] = new Player(i+1, role = "Wolf");
                } else {
                    players[i] = new Player(i+1, role = "Villager");
                }
            }

            System.out.println();
            System.out.println("Each player take");

            for (int i = 0; i < numPlayers; i++){
                System.out.println();
                System.out.println("Player " + players[i].getId() + " take");
                sc.nextLine();
                System.out.println("Your role is " + players[i].getRole());
                System.out.println("Memorize your role");
                sc.nextLine();
                for (int Line = 0; Line < 30; Line++){
                    System.out.println();
                }
            }

            boolean gameOver = false;
            int turn = 0;

            while(!gameOver){
                System.out.println("Turn " + turn);
                System.out.println();

                System.out.println("Night falls. WereWolf are awake");
                int aliveWerewolf = findAliveWerewolf(players);
                if (aliveWerewolf != -1){
                    System.out.println("WereWolf is your turn.");
                    System.out.println("Alive players: ");
                    printAlivePlayers(players);
                }

                while(true){
                    System.out.println("Choose a player to kill?");
                    if(sc.hasNextInt()){
                        targetId = sc.nextInt();
                        System.out.println();
                        if (isVaildTarget(targetId, players[aliveWerewolf])){
                            break;
                        } else {
                            System.out.println("Invalid target");
                            sc.nextLine();
                        }
                        players[targetId-1].kill();
                        System.out.println("Night Results: Player " + targetId + " has been killed");
                    } else {
                        System.out.println("No werewolf alive. skipping night phase");
                    }

                    if(checkkillvillagerwin(players)){
                        System.out.println("Game Over!");
                        System.out.println("WereWolf win!");
                        gameOver = true;
                    } else if (checkkillwerewolfwin(players)){
                        System.out.println("Game Over!");
                        System.out.println("Villager win!");
                        gameOver = true;
                    }
                }

                if (gameOver){
                    break;
                }

                int voteId = -1;


                }
            }
        }
    }
}

