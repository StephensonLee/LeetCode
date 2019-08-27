package problems;

public class P67_Add {
	public static String addBinary(String a, String b) {
		int carry=0;
		int i=a.length()-1;
		int j=b.length()-1;
		StringBuilder ans=new StringBuilder();
		while(i >= 0 || j >= 0){
	           int sum = carry;
	           if(j >= 0)sum += b.charAt(j--) - '0'; 
	           if(i >= 0)sum += a.charAt(i--) - '0';
	           ans.append(sum % 2);
	           carry = sum / 2;
	        }
	        if(carry != 0){
	        	ans.append(carry);
	        }
	        return ans.reverse().toString();
	}

	public static void main(String[] args) {
		String a="1";
		String b="111";
		System.out.println(addBinary(a,b));
	}

}
