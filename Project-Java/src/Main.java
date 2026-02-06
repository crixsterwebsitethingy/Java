import java.awt.*;
import java.util.Scanner;

public class Main {
    static void print(String string){
        System.out.println(string);
    }
    static int position = 0;
    static int speed = 0;
    static int fuel_percent = 100;
    static boolean isInGear = false;
    static String accelerate(){
        if (fuel_percent == 0) {
            print("No fuel!");
            return("No Fuel");
        }
        else if (fuel_percent > 0 && isInGear){
            speed += Math.random() * 4 + 1;
            System.out.println(speed);
            return("Accelerating");
        }
    return("HELLO IM A STUPID FUNCTION!");
    }
    static String brake(){
        if (speed == 0){
            return("Stopped");
        }
        if (speed < 1){
            return(null);
        }
        speed -= Math.random() * 1 + 1;
        print("Braking, current speed: " + speed);
        return("Brake");
    }
    static String changeGear(int gear){
        if (gear == 0){
            isInGear = false;
            print("Neutral");
        }
        else if (gear==1){
            isInGear = true;
            print("Drive");
        }
        return("H");
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        /*JFrame frame = new JFrame("Project");
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);*/
        while (true) {
            String option = "";
            print("'W' to drive; 'S' to brake; '1' for Drive, '0' for Neutral");
            option = scanner.next();
            if (option.equals("W")){
                accelerate();
            }
            else if (option.equals("S")){
                brake();
            }
            else if (option.equals("1")){
                changeGear(1);
            }
            else if (option.equals("0")){
                changeGear(0);
            }
            if (!isInGear && speed != 0){
                speed -= 1;
            }
            position += speed;
            System.out.println("Position: " + position);
            if (counter == 2){
                fuel_percent -= 1;
            }
            counter++;
        }

    }
}