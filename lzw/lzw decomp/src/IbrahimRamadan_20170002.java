import java.util.*;
import java.io.*;

public class IbrahimRamadan_20170002 {
	
	
	public static String DecompLZW (String lzw) {
		ArrayList <String> dictionary= new ArrayList<String>();
		String ret="";
		for(int i=0;i<128;i++) {
			dictionary.add((char)i+"");
		}
		String temp="";
		ArrayList <Integer> Tags= new ArrayList<Integer>();
		int k=1,t=0;
		for (int i=0;i<lzw.length();i++) {
			
			while (lzw.charAt(i)<='9'&&lzw.charAt(i)>='0') {
				
				temp=temp+lzw.charAt(i);
				if (i<lzw.length()-1)
					i++;
				else {
					break;
				}
				
				}
			 k=1;
			 t=0;
			for (int j=temp.length()-1;j>=0;j--) {
				t=t+((temp.charAt(j)-'0')*k);
				k=k*10;
				
			}
			Tags.add(t);
			 temp="";
		}
		k= 127;
		
		for (int i=0;i<Tags.size();i++) {
			if (i>0 && Tags.get(i)<k) {
				temp=dictionary.get(Tags.get(i-1))+dictionary.get(Tags.get(i)).charAt(0);
				dictionary.add(temp);
				k++;
				temp="";
			}
			else if (i>0 && Tags.get(i)>k) {
				temp=dictionary.get(Tags.get(i-1))+dictionary.get(Tags.get(i-1)).charAt(0);
				dictionary.add(temp);
				k++;
				temp="";
			}
				ret=ret+dictionary.get(Tags.get(i));
			
		}
		return ret;
			
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	String a=DecompLZW("65,66,65,128,128,129,131,134,130,129,66,138,139,138");
	System.out.print(a);
	}

}
