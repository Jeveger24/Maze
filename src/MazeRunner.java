import java.util.*;

public class MazeRunner {
    public static Maze myMap = new Maze();

    public static void main(String[] args) {
        intro();
        userMove();

    }

    public static void intro() {
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position: ");
        myMap.printMap();
        System.out.println("The \"x\" character represents your current position and the \".\" represent an unknown space.");

    }

    public static void userMove() {
        Scanner input = new Scanner(System.in);
        String direction = "";
        int move = 0;
        System.out.print("Where would you like to move? (R, L, U, D) ");
        direction = input.nextLine();

        while (myMap.didIWin() == false){
            if (direction.equals("R") && myMap.canIMoveRight()) {
                navigatePit(direction);
                System.out.println("You have chosen to move 1 step to the right.");
                myMap.moveRight();
            } else if (direction.equals("L") && myMap.canIMoveLeft()) {
                navigatePit(direction);
                System.out.println("You have chosen to move 1 step to the left.");
                myMap.moveLeft();
            } else if (direction.equals("U") && myMap.canIMoveUp()) {
                navigatePit(direction);
                System.out.println("You have chosen to move up by 1.");
                myMap.moveUp();
            } else if (direction.equals("D") && myMap.canIMoveDown()) {
                navigatePit(direction);
                System.out.println("You have chosen to move down by 1.");
                myMap.moveDown();
            } else {
                System.out.println("Sorry, you've hit a wall.");
                System.out.print("Where would you like to move? (R, L, U, D) ");
                direction = input.nextLine();
            }
            myMap.printMap();
            move += 1;
            movesMessage(move);
        };
    }

    public static void movesMessage(int moves) {
        switch (moves) {
            case 50:
                System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes.");
                break;
            case 75:
                System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
                break;
            case 90:
                System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
                break;
            case 100:
                System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
                break;
            case 101:
                System.out.println("Sorry, but you didn't escape in time- you lose!");
                System.exit(0);
                break;
            default:
                System.out.println("Total moves: " + moves);
        }
    }

    public static void navigatePit(String userDirection) {
        Scanner input = new Scanner(System.in);
        if (myMap.isThereAPit(userDirection) == true) {
            System.out.print("Watch out! There's a pit ahead, jump it? ");
            String jump = input.nextLine();
            if (jump.equalsIgnoreCase("y") || jump.equalsIgnoreCase("yes") ) {
                myMap.jumpOverPit(userDirection);
            } else {
                System.out.println("Where would you like to move then? (R, L, U, D) ");
            }
        }
    }
}

