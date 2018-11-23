class Main
{
	public static void main(String[] args)
	{
		System.out.println(new IdClass().print(1));
	}
}

class IdClass
{
	int[] id;
	boolean a;

	public int print(int num)
	{
		int ab;

		id[0] = id[3];
		ab = 3*ab;
		ab = this.print(2);

		return num;
	}
}

class NumClass extends IdClass
{
	int a;
}