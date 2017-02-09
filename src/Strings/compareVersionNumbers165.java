package Strings;

public class compareVersionNumbers165 {
	public static void main(String args[]) {
		String str1=new String("1");
		String str2=new String("1.0");
		System.out.println(new compareVersionNumbers165().compareVersion(str1, str2));
	}
	
	public int compareVersion(String version1, String version2) {
		//return 1 if version1 is greater , -1 if version 2 and 0 if both are same
		if(version1==null||version2==null){return 0;}
		version1=version1.replaceAll(" ", "");
		version2=version2.replaceAll(" ", "");
		if(version1.equals(version2)){return 0;}
		String strs1[]=version1.split(new String("\\."));
		if(strs1==null||strs1.length==0)
		{
			strs1[0]=version1;
		}
		String strs2[]=version2.split(new String("\\."));
		if(strs2==null||strs2.length==0)
		{
			strs2[0]=version2;
		}
		
		int a=0,b=0;
		while(a<strs1.length&&b<strs2.length)
		{
			int x=Integer.parseInt(strs1[a]);
			int y=Integer.parseInt(strs2[b]);
			if(x>y){return 1;}
			if(x<y){return -1;}
			if(x==y){a++;b++;}
		}
		if(a==strs1.length&&b!=strs2.length)
		{
			boolean zero=true;
			while(b<strs2.length)
			{
				if(Integer.parseInt(strs2[b])!=0){zero=false;break;}
				b++;
			}
			if(zero){return 0;}
			else {return -1;}
		}
		else if(b==strs2.length&&a!=strs1.length)
		{
			boolean zero=true;
			while(a<strs1.length)
			{
				if(Integer.parseInt(strs1[a])!=0){zero=false;break;}
				a++;
			}
			if(zero){return 0;}
			else{return 1;}
		}
		return 0;
	}
}
