import java.util.*;

public class Main {
    //Tired of Ideas

    static Scanner userInput = new Scanner(System.in);
    static String choice="";
    static int intChoice;
    static Random random = new Random();

    static Pogemon myOne = new Pogemon();
    static Pogemon myTwo = new Pogemon();

    public static void main(String[] args) {


        //proto 1 attributes
        myOne.name = "Snorlax";
        myOne.criticalAttack = "Super Smash";
        myOne.normalAttack = "Stump";
        myOne.stunnedAttack = "Sleep";
        myOne.HP = 20;
        myOne.MP = 15;
        myOne.level = 8;

        //proto 2 attributes
        myTwo.name = "Squirtle";
        myTwo.criticalAttack = "Splash Spray";
        myTwo.normalAttack = "Tail";
        myTwo.stunnedAttack = "Twirl";
        myTwo.HP = 15;
        myTwo.MP = 15;


        main();


    }
    public static void main(){
        while (!choice.equals("3")) {
            System.out.println();
            System.out.println("[1]Move\n[2]Rest\n[3]Quit\nChoose your Option: ");
            choice = userInput.next();
            switch (choice) {
                case "1" -> Move();
                case "2" -> myOne.Rest();
                case "3" -> System.out.println("Thank You For playing Pogemon");
                default -> System.out.println("No Error Trapping");
            }
        }
    }
    public static void Move() {
        System.out.println();
        if ((intChoice=random.nextInt(1, 10)) <6) {
            System.out.println("You have move " + intChoice + " blocks");
        }else{
            System.out.println("You have encountered a wild " + myTwo.name);
                System.out.println("[1] Attack\n[2] Run\n[3] Catch\nChoose your option: ");
                choice = userInput.next();
                switch (choice) {
                    case "1" -> Attack();
                    case "2" -> myTwo.Run();
                    case "3" -> myTwo.Catch();
                    default -> {
                        System.out.println("No Error Trapping");
                        Move();
                    }
                }
            }
    }




    //Attack
    public static void Attack(){
        while (true) {
            userAttack();
            AIAttack();
            Health();
            if (myTwo.HP<=0||myOne.HP<=0){
                myOne.level += 2;
                if(myOne.level == 10){
                    myOne.name = "Super Snorlax";
                    System.out.println("Your Pogemon has evolve to "+myOne.name);
                }
                break;
        }
        Restore();
        }
    }




    public static void userAttack() {
        myOne.Attack();
        myTwo.setRecievedDamageEnemy();
    }
    public static void AIAttack() {
        myTwo.setEnemy();
        myOne.setRecievedDamage();
    }

    public static void Health(){
        myOne.setHealth();
        myTwo.setHealth();
    }
    public static void Restore(){
        myOne.HPReset();
        myTwo.HPReset();
    }

}


