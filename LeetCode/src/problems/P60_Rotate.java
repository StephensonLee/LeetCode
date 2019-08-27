package problems;

public class P60_Rotate {
	public static ListNode rotateRight(ListNode head, int k) {
		if (head==null) return null;
		ListNode id =head;
		int len=1;
		while (id.next!=null) {
			id=id.next;
			len++;
		}
		k=k%len;
		if (k==0) {return head;}
		id.next=head;
		for (int i=0;i<len-k;i++) {
			id=id.next;
		}
		ListNode result =id.next;
		id.next=null;
		return result;
	}

	public static void main(String[] args) {
		ListNode head =new ListNode(1);
		ListNode id =head;
		for (int i=2;i<=5;i++) {
			id.next=new ListNode(i);
			id=id.next;
		}
		ListNode ans = rotateRight(head,2);
		while (ans!=null) {
			System.out.println(ans.val);
			ans=ans.next;
		}

	}
}


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}