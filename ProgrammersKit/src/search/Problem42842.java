package search;

import java.util.Arrays;

public class Problem42842 {

	public static void main(String[] args) {
		int brown = 10;
		int yellow = 2;
		
		int[] answer = solution(brown, yellow);
		
		System.out.println(Arrays.toString(answer));
	}

	private static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
        int area = brown + yellow;
        int v = 3;
        int h = 0;
        
        while(area % v != 0){
            v++;
        }
        
        h = area / v;
        
        while(true){
            if((h-2) * (v-2) == yellow)
                break;
            else{
                h--;
                while(area % h != 0){
                    h--;
                }
                v = area / h;
            }
        }
        
        answer[0] = h;
        answer[1] = v;
        
        return answer;
	}
	
}
