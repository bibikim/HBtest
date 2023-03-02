import java.util.Arrays;

public class test05 {

    public String solution(String s) {
    	
    	char[] asc = s.toCharArray();
    	Arrays.sort(asc);
    	StringBuilder sb = new StringBuilder(String.valueOf(asc));
        
        
        return sb.reverse().toString();
    }
	
}
