package twonumber;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的， 并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 您可以假设除了数字 0 之外，这两个数都不会以 0 开头 。
 * 
 * @author 王贤宏
 * 
 */
public class AddTwoNumbers
{
	// 输入：(2 -> 4->3) + (5 -> 6 -> 4)
	// 输出：7 -> 0 -> 8 原因：342 + 465 = 807
	private static ListNode addTwoNumber(ListNode node1, ListNode node2)
	{
		// 头node
		ListNode dummyHead = new ListNode(0);
		ListNode p = node1, q = node2, curNode = dummyHead;
		int carry = 0;
		while (p != null || q != null)
		{
			int x = p != null ? p.val : 0;
			int y = q != null ? q.val : 0;
			int sum = x + y + carry;
			carry = sum / 10;// 0,即是0~9;1，即是10~19
			curNode.next = new ListNode(sum % 10);
			curNode = curNode.next;
			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}
		// 特别注意，最后一位可能还要进一
		if (carry > 0)
		{
			curNode.next = new ListNode(carry);
		}
		return dummyHead;
	}

	public static class ListNode
	{
		int val;
		ListNode next;

		ListNode(int x)
		{
			val = x;
		}
	}

	public static void main(String[] args)
	{
		ListNode node1 = new ListNode(5);
		ListNode node2 = new ListNode(6);

		ListNode m = node1;
		ListNode n = node2;
		for (int i = 1; i < 4; i++)
		{
			m.next = new ListNode(i + (i % 3));
			m = m.next;
		}
		for (int i = 1; i < 4; i++)
		{
			n.next = new ListNode(3 * i);
			n = n.next;
		}
		ListNode node = addTwoNumber(node1, node2);

		System.out.print("curNode: " + node);
	}
	// 时间复杂度：O(max(m,n)) m是node1的长度，n是node2的长度
	// 空间复杂度：O(max(m,n)) m是node1的长度，n是node2的长度, 新列表会多加了一个头Node
}
