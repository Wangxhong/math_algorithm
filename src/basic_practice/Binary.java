package basic_pratice;

import java.util.Stack;

/**
 * 二进制用法
 * 
 * @author 王贤宏
 * 
 */
public class Binary
{// 负数该怎么处理
	public static String ConvertIntToBinary(int decimal)
	{
		if (decimal < 0)
		{
			int reverseNum = ((decimal * -1) ^ Integer.MAX_VALUE) + 1;
			return ConvertIntToBinary(reverseNum);
		}
		StringBuilder builder = new StringBuilder();
		while (decimal > 0)
		{
			if ((decimal & 1) != 0)
			{
				builder.insert(0, 1);
			}
			decimal = decimal >> 1;
		}
		return builder.toString();
	}

	public static String method_(int num)
	{
		String str = "";
		for (int i = num; i > 0; i = i / 2)
		{
			str = (i % 2) + "";
		}
		return str;
	}

	public static void method_2(int num)
	{
		Stack<Integer> stack = new Stack<>();
		while (num > 0)
		{
			stack.push(num % 2);
			num = num / 2;
		}
		for (int d : stack)
		{
			System.out.print("d:" + d);
		}

	}

	
	public static void main(String[] args)
	{
		
		// String binary = ConvertIntToBinary(-5);
		// System.out.println(binary);
		method_2(56);
	}

}
