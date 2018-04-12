//Name Blake Schollmeyer
//Username: bas76530
//700No: 700517653
//Assignment Number: a2
//Folder Name: Beetle
//Due:1/25/16

public class BeetleGame{
	public static final java .util.Scanner INPUT = new java.util.Scanner(System.in);

	private Beetle bug1;
	private Beetle bug2;
	private Beetle bug3;
	private Beetle bug4;
	private Beetle bug5;


	private Die die;

	public BeetleGame(){
		bug1 = new Beetle();
		bug2 = new Beetle();
		bug3 = new Beetle();
		bug4 = new Beetle();
		bug5 = new Beetle();
		die = new Die();
	}

	public static void main(String[] args){
		String str;
		System.out.println("Welcome to Beetle.");
	do{
		System.out.print("Enter number of Players between (1 to 5): ");
		int nOP = INPUT.nextInt();
		BeetleGame game = new BeetleGame();
		INPUT.nextLine();
		switch(nOP){
			case 1:
				game.play1();
				break;
			case 2:
				game.play2();
				break;
			case 3:
				game.play3();
				break;
			case 4:
				game.play4();
				break;
			case 5:
				game.play5();
		}

		System.out.print("Do you want to play again (y/n)");
		str = INPUT.nextLine();
	}while(str.equals("y") || str.equals("yes"));

	}

	public void play1(){
			int player = 1;
			Beetle bug = bug1;
			while(!(bug.isComplete())){
				System.out.println("\n**********************************************************");
				if(!(takeTurn(player, bug))){
					player = 1;
					bug = bug1;
				}
			}
			System.out.println("\nPlayer " + player + " Wins!");
			System.out.println(bug);
			System.out.println("**********************************************************");

	}

	public void play2(){
		int player = 1;
		Beetle bug = bug1;
		while(!(bug.isComplete())){
			if(!(takeTurn(player, bug))){
				if(player == 1){
					player = 2;
					bug = bug2;
				}else{
					player = 1;
					bug = bug1;
				}
				System.out.println("\n**********************************************************");
			}
		}
		System.out.println("\nPlayer " + player + " Wins!");
		System.out.println(bug);
		System.out.println("**********************************************************");

	}

	public void play3(){
			int player = 1;
			Beetle bug = bug1;
			while(!(bug.isComplete())){
				if(!(takeTurn(player, bug))){
					if(player == 1){
						player = 2;
						bug = bug2;
					}else if(player == 2){
						player = 3;
						bug = bug3;
					}
					else{
						player = 1;
						bug = bug1;
					}
					System.out.println("\n**********************************************************");
				}
			}
			System.out.println("\nPlayer " + player + " Wins!");
			System.out.println(bug);
			System.out.println("**********************************************************");
			System.out.println("**********************************************************");

	}

		public void play4(){
				int player = 1;
				Beetle bug = bug1;
				while(!(bug.isComplete())){
					if(!(takeTurn(player, bug))){
						if(player == 1){
							player = 2;
							bug = bug2;
						}else if(player == 2){
							player = 3;
							bug = bug3;
						}
						else if(player ==3){
							player = 4;
							bug = bug4;
						}
						else{
							player = 1;
							bug = bug1;
						}
						System.out.println("\n**********************************************************");
					}
				}
				System.out.println("\nPlayer " + player + " Wins!");
				System.out.println(bug);
				System.out.println("**********************************************************");
				System.out.println("**********************************************************");
		}

			public void play5(){
						int player = 1;
						Beetle bug = bug5;
						while(!(bug.isComplete())){
							if(!(takeTurn(player, bug))){
								if(player == 1){
									player = 2;
									bug = bug2;
								}else if(player == 2){
									player = 3;
									bug = bug3;
								}
								else if(player ==3){
									player = 4;
									bug = bug4;
								}
								else if(player == 4){
									player = 5;
									bug = bug5;
								}
								else{
									player = 1;
									bug = bug1;
								}
								System.out.println("\n**********************************************************");
							}
						}
						System.out.println("\nPlayer " + player + " Wins!");
						System.out.println(bug);
						System.out.println("**********************************************************");
						System.out.println("**********************************************************");
		}

		public boolean takeTurn(int player, Beetle bug){
			System.out.println("\nPlayer " + player + ", your beetle:");
			System.out.println(bug.toString());
			System.out.print("hit return to roll: ");
			INPUT.nextLine();
			die.roll();
			bug.setRollRecord(die.getTopFace());
			System.out.print("You rolled a " + die.getTopFace());

			switch(die.getTopFace()){
				case 1:
					System.out.println("\n (body)");
					System.out.println("Roll Number= " + bug.getRollNumber());
					System.out.print("\nRoll History= " + bug.getRollRecord());
					return bug.addBody();
				case 2:
					System.out.println("\n (head)");
					bug.addRollNumber();
					System.out.println("Roll Number= " + bug.getRollNumber());
					System.out.print("\nRoll History= " + bug.getRollRecord());
					return bug.addHead();
				case 3:
					System.out.println("\n (leg)");
					bug.addRollNumber();
					System.out.println("Roll Number= " + bug.getRollNumber());
					System.out.print("\nRoll History= " + bug.getRollRecord());
					return bug.addLeg();
				case 4:
					System.out.println("\n (eye)");
					bug.addRollNumber();
					System.out.println("Roll Number= " + bug.getRollNumber());
					System.out.print("\nRoll History= " + bug.getRollRecord());
					return bug.addEye();
				case 5:
					System.out.println("\n (feeler)");
					bug.addRollNumber();
					System.out.println("Roll Number= " + bug.getRollNumber());
					System.out.print("\nRoll History= " + bug.getRollRecord());
					return bug.addFeeler();
				default:
					System.out.println("\n (tail)");
					bug.addRollNumber();
					System.out.println("Roll Number= " + bug.getRollNumber());
					System.out.print("\nRoll History= " + bug.getRollRecord());
					return bug.addTail();
			}
		}
}