package twonumber;

/**
 * �������� �ǿ� ������������ʾ�����Ǹ������������У����Ǹ��Ե�λ���ǰ��� ���� �ķ�ʽ�洢�ģ� �������ǵ�ÿ���ڵ�ֻ�ܴ洢 һλ ���֡�
 * ��������ǽ��������������������᷵��һ���µ���������ʾ���ǵĺ͡� �����Լ���������� 0 ֮�⣬���������������� 0 ��ͷ ��
 * 
 * @author ���ͺ�
 * 
 */
public class AddTwoNumbers
{
	// ���룺(2 -> 4->3) + (5 -> 6 -> 4)
	// �����7 -> 0 -> 8 ԭ��342 + 465 = 807
	private static ListNode addTwoNumber(ListNode node1, ListNode node2)
	{
		// ͷnode
		ListNode dummyHead = new ListNode(0);
		ListNode p = node1, q = node2, curNode = dummyHead;
		int carry = 0;
		while (p != null || q != null)
		{
			int x = p != null ? p.val : 0;
			int y = q != null ? q.val : 0;
			int sum = x + y + carry;
			carry = sum / 10;// 0,����0~9;1������10~19
			curNode.next = new ListNode(sum % 10);
			curNode = curNode.next;
			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}
		// �ر�ע�⣬���һλ���ܻ�Ҫ��һ
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
	// ʱ�临�Ӷȣ�O(max(m,n)) m��node1�ĳ��ȣ�n��node2�ĳ���
	// �ռ临�Ӷȣ�O(max(m,n)) m��node1�ĳ��ȣ�n��node2�ĳ���, ���б������һ��ͷNode
}
