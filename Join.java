import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Join {

	public static void main(String[] args) throws Exception {
		System.out.println("Enter your location\n");
		
		Scanner sc=new Scanner(System.in);
			locationData l=new locationData();
			l.splitData();
			
		HashMap<String,String> Result=new HashMap<String,String>();
			for (String o:locationData.NYCdepositorBlocks.keySet()){
				for(String i:locationData.HOUcustomerBlocks.keySet()){
					locationData.NYCdepositorBlocks.get(o);
					for(String s:locationData.NYCdepositorBlocks.get(o).keySet())
							{
						for(String p:locationData.HOUcustomerBlocks.get(i).keySet()){
							if(s.equals(p)){
								//String temp=locationData.HOUcustomerBlock1.keySet();
								Result.put(s,locationData.HOUcustomerBlocks.get(i).get(s));
							}
						}
						System.out.println(Result.size());
							}
				}
				
			}
			
			
		sc.close();

	}

}
