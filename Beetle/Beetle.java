//Name Blake Schollmeyer
//Username: bas76530
//700No: 700517653
//Assignment Number: a2
//Folder Name: Beetle
//Due:1/25/16

public class Beetle{
	private String bugName = "";
	private int feelers = 0;
	private int eyes = 0;
	private boolean head = false;
	private boolean body = false;
	private int legs = 0;
	private boolean tail = false;
	private int rollNumber = 0;
	private String rollRecord = "";

	public Beetle(){
	}

	public boolean addBody(){
		if(body){
			return false;
		}else{
			this.body = true;
			return true;
		}
	}

	public boolean addEye(){
		if(head && (eyes < 2)){
			eyes++;
			return true;
		}else{
			return false;
		}
	}

	public boolean addHead(){
		if(body && !head){
			head = true;
			return true;
		}else{
			return false;
		}
	}

	public boolean addFeeler(){
		if(head && (feelers < 2)){
			feelers++;
			return true;
		}else{
			return false;
		}
	}

	public boolean addLeg(){
		if(body && (legs < 6)){
			legs++;
			return true;
		}else{
			return false;
		}
	}

	public boolean addTail(){
		if(body && !tail){
			tail = true;
			return true;
		}else{
			return false;
		}
	}

	public void addRollNumber(){
		this.rollNumber++;
	}

	public int getRollNumber(){
		return this.rollNumber;
	}

	public void setRollRecord(int x){
		this.rollRecord += (x + "");
	}

	public String getRollRecord(){
		return this.rollRecord;
	}

	public String toString(){
			if(body) {
				String result = "";
				if(feelers > 0){
					result += "\\";
					if(feelers == 2){
						result += " /";
					}
					result += "\n";
				}
				if(head){
					if(eyes > 0){
						result += "o";
					} else{
						result += " ";
					}
					result += "0";
					if(eyes == 2){ result += "o";}
					result += "\n";
				}
				if(legs > 0){
					result += "-";
				}else{
					result += " ";
				}
				result += "#";
				if(legs > 1){
					result += "-";
				}
				result += "\n";
				if(legs > 2){
					result += "-";
				}else {
					result += " ";
				}
				result += "#";
				if(legs > 3){
					result += "-";
				}
				result += "\n";
				if(legs > 4){
					result += "-";
				} else{
					result += " ";
				}result += "#";
				if(legs > 5){
					result += "-";
				}
				if(tail){
					result += "\n v";
				}
				return result;
			} else{
				return "(no parts yet)";
			}

	}

	public boolean isComplete(){
		return body && (eyes ==2) && (feelers == 2) && head && (legs == 6) && tail;
	}

}