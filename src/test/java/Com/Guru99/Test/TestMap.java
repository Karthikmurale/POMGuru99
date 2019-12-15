package Com.Guru99.Test;

import java.util.HashMap;

public class TestMap {

	public static void main(String[] args) {
		
		TestMap test  = new TestMap();
		test.enterTextbox();
		
		

	}
	
	public map<String,String> enterTextbox(Object[]... args )
	{
		HashMap<String,String> map = new HashMap<String,String>();
		if(!map.isEmpty())
		{
			String str = args[0].toString();
			if(str.contains("#")){
				String[] spt = str.split("#");
				for(String maplp: spt)
				if(maplp.contains("=")){
					String[] str1 = maplp.split("=");
					map.put(str1[0], str1[1]);
					
				}
				
			}
			else{
				System.out.println("Format is wrong");
			}
		}
		else{
			System.out.println("Input declared is Empty");
		}
	}

}
