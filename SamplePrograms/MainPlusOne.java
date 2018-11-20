class Main
{
	public static void main(String[] args)
	{
		a[1] = 3;
		System.out.println(new ClassOne().methodOne(1));
		System.out.println(1+2*3+4-5);
		System.out.println(!true);
		System.out.println(a[3]);
	}
}

class ClassOne
{
	public int methodOne(int a)
	{
		int[] a;
		a = new int[3];

		i = a.length;
		while(1 < i)
			a = a+1;
		return a;
	}
}

class ClassTwo
{
	int a;
	int b;
	ClassOne co;

	public int[] methodTwo(boolean b)
	{
		int[] a;
		a = new int[5];
		b = new ClassOne();
		a = 1;
		return a&&b&&c;
	}

	public boolean methodThree(int c)
	{
		if(a)
			x = 1;
		else
			x = 2;
		
		return true;
	}
}