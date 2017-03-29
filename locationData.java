import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class locationData {
	
	
	public static HashMap<String,String> NYCdepositorBlock1 =new HashMap<String,String>();
	public static HashMap<String,String> NYCdepositorBlock2 =new HashMap<String,String>();
	public static HashMap<String,String> NYCdepositorBlock3 =new HashMap<String,String>();
	public static HashMap<String,String> NYCdepositorBlock4 =new HashMap<String,String>();
	public static HashMap<String,String> OMAdepositorBlock1 =new HashMap<String,String>();
	
	public static HashMap<String,String> NYClocationMap =new HashMap<String,String>();
	public static HashMap<String,String> NYCaccountMap =new HashMap<String,String>();
	
	//public static HashMap<String,String> HOUcustomerMap =new HashMap<String,String>();
	public static HashMap<String,String> HOUcustomerBlock1 =new HashMap<String,String>();
	public static HashMap<String,String> HOUcustomerBlock2 =new HashMap<String,String>();
	public static HashMap<String,String> HOUcustomerBlock3 =new HashMap<String,String>();
	public static HashMap<String,String> HOUcustomerBlock4 =new HashMap<String,String>();
	public static HashMap<String,String> HOUcustomerBlock5 =new HashMap<String,String>();
	public static HashMap<String,String> HOUcustomerBlock6 =new HashMap<String,String>();
	public static HashMap<String,String> HOUcustomerBlock7 =new HashMap<String,String>();
	public static HashMap<String,String> HOUcustomerBlock8 =new HashMap<String,String>();
	
	public static HashMap<String,String> Nycbranchblock = new HashMap<String,String>();
	public static HashMap<String,String> SFObranchblock = new HashMap<String,String>();
	
	public static HashMap<String,String> NYCaccountblock1 =new HashMap<String,String>();
	public static HashMap<String,String> NYCaccountblock2 =new HashMap<String,String>();
	public static HashMap<String,String> NYCaccountblock3 =new HashMap<String,String>();
	public static HashMap<String,String> NYCaccountblock4 =new HashMap<String,String>();
	public static HashMap<String,String> NYCaccountblock5 =new HashMap<String,String>();
	public static HashMap<String,String> NYCaccountblock6 =new HashMap<String,String>();
	public static HashMap<String,String> SFOAccountblock1 =new HashMap<String,String>();
	public static HashMap<String,String> OMAAccountblock1 =new HashMap<String,String>();
	public static HashMap<String,String> OMAAccountblock2 =new HashMap<String,String>();
	
	

	public static HashMap<String,HashMap<String,String>> SFOAccountBlocks =new HashMap<String,HashMap<String,String>>();
	
	public static HashMap<String,HashMap<String,String>> NYCdepositorBlocks =new HashMap<String,HashMap<String,String>>();
	public static HashMap<String,HashMap<String,String>> HOUcustomerBlocks =new HashMap<String,HashMap<String,String>>();
	public static HashMap<String,HashMap<String,String>> NYCaccountBlocks =new HashMap<String,HashMap<String,String>>();
	public static HashMap<String,HashMap<String,String>> OMAaccountBlocks =new HashMap<String,HashMap<String,String>>();
	public static HashMap<String,HashMap<String,String>> OMADepositorBlocks =new HashMap<String,HashMap<String,String>>();
	
	
	public void splitData() throws FileNotFoundException{
	File depositorfile = new File("C:/Users/Vinod Chokkula/dbproj/JoinImplementation/src/Depositor.csv");
	File locationfile = new File("C:/Users/Vinod Chokkula/dbproj/JoinImplementation/src/Depositor.csv");
	File customerfile = new File("C:/Users/Vinod Chokkula/dbproj/JoinImplementation/src/Customer.csv");
	
	File branchfile= new File("C:/Users/Vinod Chokkula/dbproj/JoinImplementation/src/branch.csv");
	File accountfile = new File("C:/Users/Vinod Chokkula/dbproj/JoinImplementation/src/Account.csv");
	int depcount=0;
	int custcount=0;
	int acccount=0;
	Scanner sc=new Scanner(depositorfile);
	while(sc.hasNextLine()){
	String[] depositorArray=sc.nextLine().split(",");
	
	if(depcount==0 || depcount<15){
		NYCdepositorBlock1.put(depositorArray[1], depositorArray[0]);
		
		depcount++;
		
	}
	else if(depcount>=15 && depcount<30){
		NYCdepositorBlock2.put(depositorArray[1], depositorArray[0]);
		depcount++;
		
	}
	else if(depcount>=30 && depcount<45){
		NYCdepositorBlock3.put(depositorArray[1], depositorArray[0]);
		depcount++;
		
	}
	else{
		NYCdepositorBlock4.put(depositorArray[1], depositorArray[0]);
		depcount++;
		
	}
	if( depositorArray[1].equalsIgnoreCase("A10300") || 
			depositorArray[1].equalsIgnoreCase("A10301") ||
			depositorArray[1].equalsIgnoreCase("A10302") ||
			depositorArray[1].equalsIgnoreCase("A10303") ||
			depositorArray[1].equalsIgnoreCase("A10304") ||
			depositorArray[1].equalsIgnoreCase("A10305") ||
			depositorArray[1].equalsIgnoreCase("A10306") ||
			depositorArray[1].equalsIgnoreCase("A10307") ||
			depositorArray[1].equalsIgnoreCase("A10308") ||
			depositorArray[1].equalsIgnoreCase("A10309") ||
			depositorArray[1].equalsIgnoreCase("A10339") ||
			depositorArray[1].equalsIgnoreCase("A10340") ||
			depositorArray[1].equalsIgnoreCase("A10341") ){
			
		OMAdepositorBlock1.put(depositorArray[1], depositorArray[0]);
		 
	}
	
	
	}
	sc.close();
	NYCdepositorBlocks.put("1", NYCdepositorBlock1);
	NYCdepositorBlocks.put("2", NYCdepositorBlock2);
	NYCdepositorBlocks.put("3", NYCdepositorBlock3);
	NYCdepositorBlocks.put("4", NYCdepositorBlock4);
	OMADepositorBlocks.put("1",OMAdepositorBlock1);
	
	sc=new Scanner(customerfile);
	while(sc.hasNextLine()){
	String[] customerArray=sc.nextLine().split(",");
	String nonKeyValue=customerArray[1]+":"+customerArray[2];
	
	if(custcount==0 || custcount<=7){
		HOUcustomerBlock1.put(customerArray[0], nonKeyValue);
		custcount++;
		}
		else if(custcount>=8 && custcount<=15){
			HOUcustomerBlock2.put(customerArray[0], nonKeyValue);
			custcount++;
		}
		else if(custcount>=16 && custcount<=23){
			HOUcustomerBlock3.put(customerArray[0], nonKeyValue);
			custcount++;
		}
		else if(custcount>=24 && custcount<=31){
			HOUcustomerBlock4.put(customerArray[0], nonKeyValue);
			custcount++;
		}
		else if(custcount>=32 && custcount<=39){
			HOUcustomerBlock5.put(customerArray[0], nonKeyValue);
			custcount++;
		}
		else if(custcount>=40 && custcount<=47){
			HOUcustomerBlock6.put(customerArray[0], nonKeyValue);
			custcount++;
		}
		else if(custcount>=48 && custcount<=55){
			HOUcustomerBlock7.put(customerArray[0], nonKeyValue);
			custcount++;
		}
		else if(custcount>=56 && custcount<=64){
			HOUcustomerBlock8.put(customerArray[0], nonKeyValue);
			custcount++;
		}
		
	HOUcustomerBlocks.put("1", HOUcustomerBlock1);
	HOUcustomerBlocks.put("2", HOUcustomerBlock2);
	HOUcustomerBlocks.put("3", HOUcustomerBlock3);
	HOUcustomerBlocks.put("4", HOUcustomerBlock4);
	HOUcustomerBlocks.put("5", HOUcustomerBlock5);
	HOUcustomerBlocks.put("6", HOUcustomerBlock6);
	HOUcustomerBlocks.put("7", HOUcustomerBlock7);
	HOUcustomerBlocks.put("8", HOUcustomerBlock8);
	
	}
	sc.close();
	
	//branch Block
	 sc=new Scanner(branchfile);
	 while(sc.hasNextLine()){
	 String[] branchArray=sc.nextLine().split(",");
	 String temp=branchArray[1]+','+branchArray[2];
	 Nycbranchblock.put(branchArray[0],temp);
	 }
	 sc.close();

	 //Account Blocks
	 
	 sc=new Scanner(accountfile);
		while(sc.hasNextLine()){
		String[] accountArray=sc.nextLine().split(",");
		String nonKeyValue=accountArray[1]+":"+accountArray[2];
		if(accountArray[1].equalsIgnoreCase("Chinatown")){
			SFOAccountblock1.put(accountArray[0], nonKeyValue);	
		}
		if(accountArray[1].equalsIgnoreCase("Aksarben") || accountArray[1].equals("102 Street")){
			if(OMAAccountblock1.size()!=10){
				OMAAccountblock1.put(accountArray[0], nonKeyValue);
			}
			else if((OMAAccountblock1.size()!=10)){OMAAccountblock2.put(accountArray[0], nonKeyValue);}
		}
		
		if(acccount==0 || acccount<10){
			NYCaccountblock1.put(accountArray[0], nonKeyValue);
			acccount++;
			}
			else if(acccount>=10 && acccount<20){
				NYCaccountblock2.put(accountArray[0], nonKeyValue);
				acccount++;
				
			}
			else if(acccount>=20 && acccount<30){
				NYCaccountblock3.put(accountArray[0], nonKeyValue);
				acccount++;
				
			}
			else if(acccount>=30 && acccount<40){
				NYCaccountblock4.put(accountArray[0], nonKeyValue);
				acccount++;
				
			}
			else if(acccount>=40 && acccount<50){
				NYCaccountblock5.put(accountArray[0], nonKeyValue);
				acccount++;
				
			}
			else if(acccount>=50 && acccount<60){
				NYCaccountblock6.put(accountArray[0], nonKeyValue);
				acccount++;
				
			}
			
			
		NYCaccountBlocks.put("1", NYCaccountblock1);
		NYCaccountBlocks.put("2", NYCaccountblock2);
		NYCaccountBlocks.put("3", NYCaccountblock3);
		NYCaccountBlocks.put("4", NYCaccountblock4);
		NYCaccountBlocks.put("5", NYCaccountblock5);
		NYCaccountBlocks.put("6", NYCaccountblock6);
		
		SFOAccountBlocks.put("1", SFOAccountblock1);
		
		OMAaccountBlocks.put("1", OMAAccountblock1);
		OMAaccountBlocks.put("2", OMAAccountblock2);
		}
		sc.close();
		
		SFObranchblock=Nycbranchblock;
		
		
		System.out.println("SFO Branch :"+SFObranchblock);
		System.out.println("==========================");
		System.out.println("OMA account :"+OMAaccountBlocks);
		System.out.println("==========================");
		System.out.println("SFO ACCOunt :"+SFOAccountBlocks);
		System.out.println("==========================");
		System.out.println("NYC depositor :"+NYCdepositorBlocks);
		System.out.println("==========================");
		System.out.println("HOU customer :"+HOUcustomerBlocks);
		System.out.println("==========================");
		System.out.println("NYC ACCOunt :"+NYCaccountBlocks);
		System.out.println("==========================");
		System.out.println("OMA dep :"+OMADepositorBlocks);
		System.out.println("==========================");
		System.out.println("NYC branch :"+Nycbranchblock);
		System.out.println("==========================");
		
		
		
		
		
	}
	

	
	
}