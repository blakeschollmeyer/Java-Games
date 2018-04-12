
import java.util.InputMismatchException;
import java.util.Scanner;


public class QueueDemo {

    public static void main(String[] args) {
        QueueDemo newQueue =  new QueueDemo();
        newQueue.play();
    }


    public void play(){
            DoubleArrayQueue doubleArrayQueue = new DoubleArrayQueue();
            while(true){
                displayQueue(doubleArrayQueue);
                System.out.println("---------------------------------------------");
            }
    }

    public void displayQueue(DoubleArrayQueue doubleArrayQueue){
        Scanner input = new Scanner(System.in);
        String choice = "";
        boolean flag = true;

            System.out.println("\nQueue Size = " + doubleArrayQueue.size());
            System.out.print("Queue Elements: " + doubleArrayQueue.toString());

            //Ask user for a choice of action, add, remove, quit
            flag = false;
            while(flag == false){
                flag = true;
                try{
                    System.out.print("\nYour command(add, remove, or quit)? ");
                    choice = input.next();
                    if((choice.equals("add")== false) && (choice.equals("remove")== false) && (choice.equals("quit")== false)){
                        throw new InputMismatchException("");
                    }
                }catch(InputMismatchException e){
                    System.out.println("\n---------------------------------------------\n:"
                            + "Incorrect Input Error\n "
                            + "---------------------------------------------");
                    flag = false;
                }
            }//end while loop

            //Perform selected command by the user
            switch(choice){
                case "add":
                    flag = false;
                    while(flag == false){
                        flag = true;
                        System.out.print("Element to add: " );
                        try{
                            doubleArrayQueue.add(Double.parseDouble(input.next()));
                        }catch(Exception x){
                            System.out.println("\n---------------------------------------------\n:"
                            + "Incorrect Input Error\n "
                            + "---------------------------------------------");
                            flag = false;
                        }
                    }//end while loop
                    break;
                case "remove":
                    doubleArrayQueue.remove();
                    break;
                case "quit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Correct input was not recieved");
                    break;
            }

    }
}
