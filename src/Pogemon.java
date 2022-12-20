import java.util.*;

public class Pogemon {
    static Random random = new Random();
    Scanner input = new Scanner(System.in);

    public int HP,MP,ranInt,level;

    static int choice,ai;

    static String stunVal="no";
    public String name, normalAttack, criticalAttack, stunnedAttack;




    //USER Attack
    public void Attack(){
        if(stunVal.equals("yes")){
            System.out.println(name + " cannot move due to stunned");
            return;
        }
        System.out.println("Choose "+name+ " skills"+"\n[1]"+normalAttack+"\n[2]"+criticalAttack+"\n[3]"+stunnedAttack+"\nOther"+"\n[4]Use Pokeball"+"\n[5]Use Health Potion");
        choice = input.nextInt();
        switch (choice){
            case 1 -> setNormalAttack();
            case 2 -> setCriticalAttack();
            case 3 -> setStunnedAttack();
            case 4 -> Main.myTwo.Catch();
            case 5 -> Main.myOne.Potion();
        }
    }

    public void setRecievedDamageEnemy() {
        if(stunVal.equals("yes")){
            stunVal = "no";
            return;
        }
        switch (choice){
            case 1 -> setNormalDamage();
            case 2 -> setCriticalDamage();
            case 3 -> setStunnedDamage();
        }
    }
    //__________________________________________________________________

    //AI Attack
    public void setEnemy(){
        if(stunVal.equals("yes")){
            System.out.println(name + " cannot move due to stunned");
            return;
        }
        ai = random.nextInt(1,4);
        switch (ai){
            case 1 -> setNormalAttack();
            case 2 -> setCriticalAttack();
            case 3 -> setStunnedAttack();
        }
    }

    public void setRecievedDamage(){
        if(stunVal.equals("yes")){
            stunVal = "no";
            Main.userAttack();
            System.out.println("Enemy Cannot Move due to Stunned");
            return;
        }
        switch (ai){
            case 1 -> setNormalDamage();
            case 2 -> setCriticalDamage();
            case 3 -> setStunnedDamage();
        }
    }
    //__________________________________________________________________



    //Attack
    public void setNormalAttack(){System.out.println(name + " use "+ normalAttack);}
    public void setCriticalAttack(){
        System.out.println(name + " use "+ criticalAttack);
    }
    public void setStunnedAttack(){
        System.out.println(name + " use "+ stunnedAttack);
    }



    //Damage
    public void setNormalDamage(){
        System.out.println(name + " has received a damage of 1");
        HP -= 1;
    }

    public void setCriticalDamage(){
        if(random.nextInt(1,10)<6){
            System.out.println(name + " has received a damage of 1");
            HP -= 1;
        }else {
            ranInt = random.nextInt(2,4);
            System.out.println(name + " has received a critical damage of "+ranInt);
            HP -= ranInt;
        }
    }

    public void setStunnedDamage(){
        if(random.nextInt(1,11)<6){
            System.out.println(name + " is feeling dizzy ");

        }else {
            System.out.println(name + " is stunned");
            stunVal = "yes";
        }
    }


    public void Run(){
        choice = random.nextInt(1,10);
        if(choice <=6){
            System.out.println("You have failed to runaway from "+name);
            Main.AIAttack();
            Main.Health();
            Main.Attack();
        }else {
            System.out.println("You have successfully to runaway from "+name);
        }
    }

    public void Catch(){
        if(HP>5){
            System.out.println("You have failed to catch "+name);
            Main.AIAttack();
            Main.Health();
            Main.Attack();
        }else {
            System.out.println("You have successfully catch "+name);
            HP = 0;
            Main.main();
        }
    }

    //Health__________________________________________________________________
    public void setHealth(){
        if (HP<=0) {
            System.out.println(name+"\nHP:\t"+(HP=0)+"\nMP:\t"+MP+"\n"+name+" has been defeated\n");
        }
        else System.out.println("\n"+name+"\nHP:"+HP+"\nMP: "+MP);
    }


    public  void Rest(){
        if (HP>=20) {
            System.out.println("\n"+name + " is already in full health");
        } else {
            HP = 20;
            System.out.println("\n"+name + " has restored its health and mana" + "\nHP: " + HP + "\nMP:" + MP);
        }
    }

    public void HPReset(){
        if(HP<=0){
            HP += 15;
        }
    }

    public void Potion(){
        HP += 10;
        System.out.println(name + " has restored its health HP:"+ HP);
    }

}


