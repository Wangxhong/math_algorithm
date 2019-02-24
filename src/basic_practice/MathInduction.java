package basic_practice;

/*
 * 归纳法
 */
public class MathInduction
{
	static class Results
	{
		public long wheatNum;// 当前麦粒数
		public long wheatTotalNum;// 当前麦粒总数
	}

	// 证明归纳法的过程
	public static boolean prove(int k, Results result)
	{
		if (k == 1)
		{
			if (Math.pow(2, 1) - 1 == 1)
			{
				result.wheatNum = 1;
				result.wheatTotalNum = 1;
				return true;
			}
			return false;
		}
		else
		{
			boolean proveofPreviousOne = prove(k - 1, result);
			result.wheatNum *= 2;
			result.wheatTotalNum += result.wheatNum;
			boolean proveOfCurrentOne = false;
			if (Math.pow(2, k) - 1 == result.wheatTotalNum)
			{
				proveOfCurrentOne = true;
			}
			if (proveofPreviousOne && proveOfCurrentOne)
				return true;
		}
		return false;
	}

	public static void main(String[] args)
	{
		int grids = 63;
		Results result = new Results();
		prove(grids, result);
	}

}
