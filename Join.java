import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Join {

	public static void main(String[] args) throws Exception {
		System.out.println("Enter your location\n");
		
		String name = System.console().readLine();
		locationData l=new locationData();
		l.splitData();
		if(name=="NYC"){
			System.out.println("Enter your location\n");
			System.out.println("Select query\n");
			
			String queryno = System.console().readLine();
			int qry=Integer.parseInt(queryno);
			if(qry==1){	
			int outputBlock=1;
			
		HashMap<String,String> Result=new HashMap<String,String>();
			for (String o:locationData.NYCdepositorBlocks.keySet()){
				for(String i:locationData.HOUcustomerBlocks.keySet()){
					locationData.NYCdepositorBlocks.get(o);
					for(String s:locationData.NYCdepositorBlocks.get(o).keySet())
							{
						for(String p:locationData.HOUcustomerBlocks.get(i).keySet()){
							if(s.equals(p)){
								//String temp=locationData.HOUcustomerBlock1.keySet();
								if(Result.size()<5){
									Result.put(s,locationData.HOUcustomerBlocks.get(i).get(s));
								}
								else if(Result.size()==5){
									outputBlock++;
									System.out.println("Output block is full...result is written in file"+outputBlock);
									
											FileWriter fw = new FileWriter("C:/Users/Vinod Chokkula/dbproj/JoinImplementation/output file");
											BufferedWriter bw = new BufferedWriter(fw);
									bw.write(Result.toString());
									Result.clear();
									Result.put(s,locationData.HOUcustomerBlocks.get(i).get(s));
								}
								
							}
						}
						System.out.println(Result.size());
							}
				}
				System.out.println(Result);
				
			}
			}

			if(qry==2){
				
			}
	}
	}
}
