import java.io.*;
import java.util.*;
public class quick
{
    public static void main(String[]  args) throws Exception
    {
        new quick().run();
    }
    public void run() throws Exception
    {
	    int[] a = {3,1,5,7,9,2,6};
	    mergesort(a,0,a.length-1);
	    System.out.println(Arrays.toString(a));
    }
    void quicksort(int[] a, int min, int max)
    {
	if(min >= max) return;
	int pivot = a[min];
	int minp = min+1;
	for(int i=min+1;i<max;i++)
	{
		if(a[i] < pivot)
		{
			int temp = a[minp];
			a[minp] = a[i];
			a[i] = temp;
			minp++;
		}
	}
	int temp = a[minp-1];
	a[minp-1] = a[min];
	a[min] = temp;
	quicksort(a,min,minp-1);
	quicksort(a,minp,max);
    }

    void mergesort(int[] a,int l,int r)
    {
		if(l == r-1)
		{
			if(a[l] > a[r])
			{
				swap(a,l,r);
			}
		}
		if(l != r-1)
		{
			int m = (l+r)/2;
			mergesort(a, l, m);
			mergesort(a, m, r);
			int p1 = l;
			int p2 = m;
			for(int i=l;i<=r;i++)
			{
				if(a[p1] < a[p2]) swap(a,i,p1++);
				else swap(a,i,p2++);
			}
		}
    }
    void swap(int[] a, int l,int r)
    {
	int temp = a[l];
	a[l] = a[r];
	a[r] = temp;
    }
}
