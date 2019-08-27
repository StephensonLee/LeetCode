package problems;
//import java.util.*;

public class P83_Duplicates {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode res = head;
		if (head == null) {
			return head;
		}
		int cur = head.val;
		while (head.next != null) {
			if (head.next.val == cur) {
				head.next = head.next.next;
			} else {
				cur = head.next.val;
			}
			head = head.next;
		}
		return head;
	}
	
	public static void main(String args[]) {
		
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
