package test;

import java.util.Scanner;
import java.util.Vector;



public class test {

	public static void main(String[] args) 
	{
		
		
		
		
		
	
	}
	
	
	public void lzw_comp()
	{
		Scanner in=new Scanner(System.in);
		Vector <String> d= new Vector<String>();
		Vector<Integer> y = new Vector<Integer>();
		for(int i=0;i<128;i++) 
		{
			d.add((char)i+"");
		}
		
		String p="",c="",s="";
		int q=0;
		System.out.print("Enter your String:");
		s=in.nextLine();
		in.close();
		for(int i=0;i<s.length();i++)
		{
			char z=s.charAt(i);
			c=String.valueOf(z);
			if(d.contains(p+c))
			{
				p=p+c;
			}
			else if(!d.contains(p+c))
			{
				q=d.indexOf(p);
				y.add(q);
				d.add(p+c);
				p=c;	
			}
			if (d.contains(p) && i == s.length()-1)
	        {
	            System.out.println("P " + p);
	            q=d.indexOf(p);
	            y.add(q);
	        }
			
		}
		System.out.print("Y= "+y);
	}
	
	
}

