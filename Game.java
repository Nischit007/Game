import java.util.Scanner;

class HealthDetail {
    private int player1Health = 100;
    private int player2Health = 100;
    private boolean armour;

    HealthDetail(String weapon) {
        if (!isPlayer1Dead()) {
            if (weapon.equals("weapon1")) {
                this.player1Health -= 30;
            } else if (weapon.equals("weapon2")) {
                this.player1Health -= 50;
            }
        }
    }
    
    HealthDetail(String weapon, boolean armour) {
        if (!isPlayer2Dead()) {
            if (weapon.equals("weapon1")) {
                if (armour) {
                    this.player2Health -= 20;
                } else {
                    this.player2Health -= 30;
                }
            } else if (weapon.equals("weapon2")) {
                if (armour) {
                    this.player2Health -= 40;
                } else {
                    this.player2Health -= 50;
                }
            }
        }
    }

    public boolean isPlayer1Dead() {
        if (this.player1Health <= 0) {
            System.out.println("Player 2 Won!! Better Luck Next Time");
            return true;
        }
        return false;
    }

    public boolean isPlayer2Dead() {
        if (this.player2Health <= 0) {
            System.out.println("Player 1 Won!! Better Luck Next Time");
            return true;
        }
        return false;
    }
}

class Player1 {
    String player1Name;

    Player1(String player1Name) {
        this.player1Name = player1Name;
    }

    void gotDamage(String weapon) {
        HealthDetail h = new HealthDetail(weapon);
    }
}

class Player2 {
    String player2Name;
    boolean armour;

    Player2(String player2Name) {
        this.player2Name = player2Name;
    }

    void isArmorActivated() {
        this.armour = true;
    }

    void gotDamage(String weapon) {
        HealthDetail h = new HealthDetail(weapon, this.armour);
    }
}

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Player 1 name:");
        String player1Name = sc.nextLine();
        Player1 p1 = new Player1(player1Name);

        System.out.println("Enter weapon for Player 1 (weapon1 or weapon2):");
        String weaponP1 = sc.nextLine();
        p1.gotDamage(weaponP1);

        System.out.println("Enter Player 2 name:");
        String player2Name = sc.nextLine();
        Player2 p2 = new Player2(player2Name);

        System.out.println("Does Player 2 have armor? (true/false):");
        boolean armourP2 = sc.nextBoolean();
        p2.isArmorActivated();

        System.out.println("Enter weapon for Player 2 (weapon1 or weapon2):");
        String weaponP2 = sc.next();
        p2.gotDamage(weaponP2);

        sc.close();
    }
}
