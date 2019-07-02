package check;

public class CheckFraction {
	
	public static void main(String[] args){
		
		double fraction = 1.3e-157;
		if (Math.sqrt(Math.pow((64*fraction), 2)) == 64*fraction) {
			System.out.println("Left and right side are equal");
		} else {
			System.out.println("Left and right side are not equaul");
		}
	}

}
