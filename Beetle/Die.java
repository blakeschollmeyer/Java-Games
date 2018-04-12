//Name Blake Schollmeyer
//Username: bas76530
//700No: 700517653
//Assignment Number: a2
//Folder Name: Beetle
//Due:1/25/16

public class Die{
	private int topFace;

	public Die(){
		this.topFace = 1;
	}

	public int getTopFace(){
		return this.topFace;
	}

	public void roll(){
		topFace = (int)((Math.random() * 6) + 1);
	}

	public void setTopFace(int topFace){
		this.topFace = topFace;
	}
}