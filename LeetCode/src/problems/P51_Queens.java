package problems;
import java.util.*;;

public class P51_Queens {
	public static List<List<String>> solveNQueens(int n) {
		List<List<Integer>> solve =  solve(n);
		List<List<String>> results =new ArrayList<List<String>>();
		char [] a= new char[n];
		for (int i=0;i<n;i++) {
			a[i]='.';
		}
		for (int i=0;i<solve.size();i++) {
			List<Integer> cur = solve.get(i);
			List<String> curs = new ArrayList<String>(); 
			for (int j=0;j<cur.size();j++) {
				a[cur.get(j)]='Q';
				curs.add(String.valueOf(a));
				a[cur.get(j)]='.';
			}
			results.add(curs);
		}
		return results;
	}
	public static List<List<Integer>> solve(int n) {
        List<List<Integer>> results= new ArrayList<List<Integer>>();
        if (n==0) {return results;}
        else {
        	for(int i=0;i<n;i++) {
            	List<Integer> cur = new ArrayList<Integer>(0);
            	cur.add(i);
            	results.add(cur);
        	}
            for (int i=1;i<n;i++) {
            	int len =results.size();
            	for(int j=0;j<len;j++) {
                	for (int k=0;k<n;k++) {
                    	List<Integer> cur = new ArrayList<Integer>(results.get(j));
                		boolean check =true;
                		for (int l=0;l<cur.size();l++) {
                			if (cur.get(l)==k||cur.size()+k==l+cur.get(l)||cur.size()-k==l-cur.get(l)) {
                				check=false;
                				break;
                				}
                		}
                		if (check==false) continue;
                		cur.add(k);
                		results.add(cur);
                	}
                }
            	for(int j=0;j<len;j++) {
            		results.remove(0);
            	}
            }
        }
        return results;
	}

	public static void main(String[] args) {
		int i =4;
		System.out.println(solve(i));
		System.out.println(solveNQueens(i));
		
	}
}
