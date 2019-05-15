package code.arrays;
//HR at the class name is Hacker Rank problem.
public class JumpingOnCloudsHR {

	public static void main(String[] args) {
		int[] clouds = {0,0,0,0,1,0};
		int[] clouds1 = {0,0,1,0,0,1,0};
		System.out.println(jumpingOnClouds(clouds));
		System.out.println(jumpingOnClouds(clouds1));
		
	}
	
	static int jumpingOnClouds(int[] c) {
		//0 0 1 0 0 1 0
        int minSteps = 0;
        for(int i =0;i<c.length;){
        	if(i==c.length-1)
        		break;
        	if(i <c.length-2 && c[i+2]==0 ) {
        		minSteps++;
        		i=i+2;
        	}
        	else if(i <c.length-1 && c[i+1]==0) {
        		minSteps++;
        		i=i+1;
        	}
        }
    return minSteps;
    }
}
