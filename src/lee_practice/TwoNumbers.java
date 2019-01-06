package twonumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumbers
{
	// 两数相加等于目标值，并将它们的下标以数组形式返回
	// 时间复杂度O(n),空间复杂度O(n)
	private static int[] twoSunm(int[] array, int target)
	{
		int[] a = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++)
		{
			int value = target - array[i];
			if (map.containsKey(value))
			{
				a[0] = i;
				a[1] = map.get(value);
				return a;
			}
			map.put(array[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String[] args)
	{
		int[] array = new int[] { 1, 4, 7, 5, 3 };
		int[] arg0 = twoSunm(array, 10);
		System.out.print(Arrays.toString(arg0));
	}
}
