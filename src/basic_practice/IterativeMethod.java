package basic_practice;

/**
 * ��ѧ�е�����
 * 
 * @author ���ͺ�
 * 
 */
public class IterativeMethod
{

	public static void main(String[] args)
	{
		double arg0 = getSqureRoot(10, 0.001, 20);
		System.out.print("target:" + arg0);
	}

	// n��������deltaThreshold�Ǿ�����ֵ��maxCyc���ѭ������
	// ��ȡ��������ֵ
	public static double getSqureRoot(int n, double deltaThreshold, int maxCyc)
	{
		double left = 1.0, right = n;
		for (int i = 0; i < maxCyc; i++)
		{
			double middle = left + (right - left) / 2;
			double squre = middle * middle;
			double delta = Math.abs(squre / n - 1);
			if (delta <= deltaThreshold)
			{
				return middle;
			}
			if (squre > n)
			{
				right = middle;
			}
			else
			{
				left = middle;
			}
		}
		return -1;
	}

	// ����ĳ�������Ƿ��ڴʵ������
	public static boolean search(String[] dictionary, String word)
	{
		if (dictionary == null || dictionary.length == 0)
		{
			return false;
		}
		int min = 0;
		int max = dictionary.length - 1;
		while (max >= min)
		{
			int middle = min + (max - min) >> 1;
			if (word.compareTo(dictionary[middle]) > 0)
			{
				min = middle + 1;
			}
			else if (word.compareTo(dictionary[middle]) < 0)
			{
				max = middle - 1;
			}
			else
			{
				return true;
			}
		}
		return false;
	}
}
