package com.Walkthrough.Concepts;

public class SampleProg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SampleProg.arraycheck();
	}

	public static void arraycheck()
	{
		int count = 0;
		int a[] = {2,1,2,3,6,7,44,3,2};
		
		for(int i=0;i<a.length;i++)
		{
			count = 0;
			for(int j=0;j<a.length;j++)
			{
				if(a[i]==a[j])
				{
					count = count + 1;
					if(count>1)
					{
					System.out.println("The Duplicate element is "+a[i]);
					break;
					}
				}
			}
			if(count!=2)
			{
				System.out.println("The Non Duplicate element is "+a[i]);
			}
		}
		
	}
}
