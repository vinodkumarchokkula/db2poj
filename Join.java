import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Join {

	public static void main(String[] args) throws Exception {
		
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter your location\n");
        String inp = br.readLine();
		String name = System.console().readLine();*/
		locationData l=new locationData();
		l.splitData();
		
			/*System.out.println("Enter your location\n");
			System.out.println("Select query\n");*/
		/*	
			String queryno = System.console().readLine();
			int qry=Integer.parseInt(queryno);*/
			/*if(qry==1){	*/
			int outputBlock=1;
			
		HashMap<String,String> Result1=new HashMap<String,String>();
			for (String o:locationData.NYCdepositorBlocks.keySet()){
				for(String i:locationData.HOUcustomerBlocks.keySet()){
					locationData.NYCdepositorBlocks.get(o);
					for(String s:locationData.NYCdepositorBlocks.get(o).values())
							{
						for(String p:locationData.HOUcustomerBlocks.get(i).keySet()){
							
							if(s .equals(p)){
								//String temp=locationData.HOUcustomerBlock1.keySet();
								if(Result1.size()<5){
									Result1.put(s,locationData.HOUcustomerBlocks.get(i).get(s));
									
								}
								else if(Result1.size()==5){
									outputBlock++;
									System.out.println("Output block is full...result is written in file"+outputBlock);
									
									PrintWriter writer = new PrintWriter("C:/Users/Vinod Chokkula/dbproj/JoinImplementation/output file", "UTF-8");
								    writer.println(Result1.toString());
								    writer.close();
									/*FileWriter fw = new FileWriter("C:/Users/Vinod Chokkula/dbproj/JoinImplementation/output file");
									BufferedWriter bw = new BufferedWriter(fw);
									bw.write(Result1.toString());*/
									Result1.clear();
									Result1.put(s,locationData.HOUcustomerBlocks.get(i).get(s));
								}
								
							}
						}
						
							}
				}
				///System.out.println(Result1);
			}
			
			HashMap<String,String> Result2=new HashMap<String,String>();
			for (String o:locationData.NYCdepositorBlocks.keySet()){
				for(String i:locationData.NYCaccountBlocks.keySet()){
					for(String s:locationData.NYCdepositorBlocks.get(o).keySet())
					{
						for(String p:locationData.NYCaccountBlocks.get(i).keySet()){
					/*System.out.println("S#P"+s+p);*/
					if(s .equals(p)){
						String temp=locationData.NYCaccountBlocks.get(i).get(p);
						String cname=locationData.NYCdepositorBlocks.get(o).get(s);
						/*System.out.println(temp);*/
						String T[]=temp.split(":");
						Result2.put(cname,T[1]);
						System.out.println("result2"+Result2);
						/*if(Result2.size()<5){
							Result2.put(s,p);
						}
						else if(Result1.size()==5){
							re
						}*/
						}
					}
					
				}
				}
				}
				
			HashMap<String,String> Result3=new HashMap<String,String>();
			ArrayList<String> Join3list= new ArrayList<String>();
			for(String o:locationData.SFOAccountBlocks.keySet()){
				for(String i:locationData.NYCdepositorBlocks.keySet()){
					for(String s:locationData.SFOAccountBlocks.get(o).keySet())
					{
						for(String p:locationData.NYCdepositorBlocks.get(i).keySet()){
					
					if(s.equalsIgnoreCase(p)){
						Join3list.add(locationData.NYCdepositorBlocks.get(i).get(p));
					}
						}
					}
						}
				
			}
			for (String q:Join3list){
				for(String i:locationData.HOUcustomerBlocks.keySet()){
					
						for(String p:locationData.HOUcustomerBlocks.get(i).keySet()){
								if(q.equalsIgnoreCase(p)){
								Result3.put(p,locationData.HOUcustomerBlocks.get(i).get(p));	
								}
								
								}
						System.out.println("Hou"+Result3);
			}
			}
			
			
			
			
			
				}
				
			}
				
			
			


