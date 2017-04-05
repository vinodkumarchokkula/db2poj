import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Join {

	public static void main(String[] args) throws Exception {

		
		locationData l = new locationData();
		l.splitData();
		int count = 1;
		

		if (count == 1) {
			int outputBlock = 1, outindex = 2, bcount = 1;
			HashMap<String, String> Result = new HashMap<String, String>();
			HashMap<Integer, HashMap<String, String>> BufferMap = new HashMap<Integer, HashMap<String, String>>();
			int outcount = 2;
			boolean resetBool = false;
			BufferMap.put(1, locationData.NYCdepositorBlocks.get("1"));
			// outcount++;
			BufferMap.put(2, locationData.NYCdepositorBlocks.get("2"));
			BufferMap.put(3, locationData.HOUcustomerBlocks.get("1"));
			// incount++;
			BufferMap.put(4, locationData.HOUcustomerBlocks.get("2"));
			// System.out.println(incount);
			String inner;
			String outer;
			bcount++;
			// PrintWriter writer = new PrintWriter("C:/Users/Vinod
			// Chokkula/dbproj/JoinImplementation/output file", "UTF-8");
			PrintWriter writer = new PrintWriter("C:/Users/Vinod Chokkula/dbproj/JoinImplementation/outputfile",
					"UTF-8");
			// FileWriter fw = new FileWriter("C:/Users/Vinod
			// Chokkula/dbproj/JoinImplementation/outputfile");
			System.out.println("Query is submitted at NYC");
			System.out.println("allocating 2 blocks of data to outer block and 2 blocks of data for inner block");
			int boolCount = 1;
			for (int w = 1; w <= outindex; w = w + 2) {
				int inindex = 2, incount = 2;
				int wdup = 1;
				bcount++;
				// System.out.println("outindex"+outindex);
				System.out.println("set/reset outer blocks in buffer");
				for (int q = 1; q <= inindex; q++) {
					// System.out.println("Q---"+q+" I "+inindex);
					inner = String.valueOf(q);
					outer = String.valueOf(w);
					// qdup=q;

					for (String s : locationData.NYCdepositorBlocks.get(outer).values()) {

						for (String p : locationData.HOUcustomerBlocks.get(inner).keySet()) {
							// System.out.println("Outer"+outer+"||"+inner);

							if (p.equalsIgnoreCase(s)) {

								if (Result.size() != 5) {

									Result.put(s, locationData.HOUcustomerBlocks.get(inner).get(p));
									// System.out.println("Size"+Result.size());
									System.out.println(Result.get(s));
								} else {
									BufferMap.put(5, Result);
									System.out.println("output buffer is full, writing in to file");
									bcount++;
									Result.clear();
								}
							}
						}

					}

					wdup = w + 1;
					if (locationData.HOUcustomerBlocks.size() > wdup) {
						outer = String.valueOf(wdup);
						for (String s : locationData.NYCdepositorBlocks.get(outer).values()) {

							for (String p : locationData.HOUcustomerBlocks.get(inner).keySet()) {
								// System.out.println("Outer"+outer+"||"+inner);

								if (p.equalsIgnoreCase(s)) {

									if (Result.size() != 5) {

										Result.put(s, locationData.HOUcustomerBlocks.get(inner).get(p));
										// System.out.println("Size"+Result.size());
										System.out.println(Result.get(s));
									} else {
										BufferMap.put(5, Result);
										System.out.println("output buffer is full, writing in to file");
										bcount++;
										Result.clear();
									}
								}
							}

						}
					}

					if (q % 2 == 0) {
						// System.out.println("change inner"+outer+inner);
						incount++;
						if (incount <= locationData.HOUcustomerBlocks.size()) {
							String ipc = String.valueOf(incount);
							// System.out.println("after"+incount+ipc);
							if (locationData.HOUcustomerBlocks.containsKey(ipc)) {
								inindex++;
								// System.out.println("in
								// changing"+inindex+ipc);
								BufferMap.put(3, locationData.HOUcustomerBlocks.get(ipc));

								incount++;

							}

							String ipc2 = String.valueOf(incount);
							if (locationData.HOUcustomerBlocks.containsKey(ipc2)) {
								inindex++;
								BufferMap.put(4, locationData.HOUcustomerBlocks.get(ipc2));
							}
							// System.out.println(ipc2);
							System.out.println("Fetching two customer blocks of data from Houston");
							bcount++;
							resetBool = true;
							// boolCount++;
						}
						// System.out.println(locationData.HOUcustomerBlocks.size());

					}
				}

				outcount++;
				// System.out.println("in this");
				String opc = String.valueOf(outcount);
				if (locationData.NYCdepositorBlocks.containsKey(opc)) {
					outindex++;
					BufferMap.put(1, locationData.NYCdepositorBlocks.get(opc));
				}
				outcount++;
				String opc2 = String.valueOf(outcount);
				if (locationData.NYCdepositorBlocks.containsKey(opc2)) {
					outindex++;
					BufferMap.put(2, locationData.NYCdepositorBlocks.get(opc2));
				}

			}
			bcount++;
			System.out.println("Total number of block transfers " + bcount);
			count++;
			System.out.println("=======================================================");
		}

		// Query 1 part 2

		if (count == 2) {
			System.out.println("Interchanging inner and outer blocks");
			int outputBlock = 1, outindex = 2, bcount = 1;
			HashMap<String, String> Result = new HashMap<String, String>();
			HashMap<Integer, HashMap<String, String>> BufferMap = new HashMap<Integer, HashMap<String, String>>();
			int outcount = 1;
			boolean resetBool = false;
			BufferMap.put(1, locationData.HOUcustomerBlocks.get("1"));
			// outcount++;
			BufferMap.put(2, locationData.HOUcustomerBlocks.get("2"));
			BufferMap.put(3, locationData.NYCdepositorBlocks.get("1"));
			// incount++;
			BufferMap.put(4, locationData.NYCdepositorBlocks.get("2"));
			// System.out.println(incount);
			String inner;
			String outer;
			bcount++;
			bcount++;
			// PrintWriter writer = new PrintWriter("C:/Users/Vinod
			// Chokkula/dbproj/JoinImplementation/output file", "UTF-8");
			PrintWriter writer = new PrintWriter("C:/Users/Vinod Chokkula/dbproj/JoinImplementation/outputfile",
					"UTF-8");
			// FileWriter fw = new FileWriter("C:/Users/Vinod
			// Chokkula/dbproj/JoinImplementation/outputfile");
			System.out.println("Query is submitted at NYC");
			System.out.println("allocating 2 blocks of data to outer block and 2 blocks of data for inner block");
			int boolCount = 1;
			for (int w = 1; w <= outindex; w = w + 2) {
				int inindex = 2, incount = 2;
				int wdup = 1;
				bcount++;
				// System.out.println("outindex"+outindex);
				System.out.println("set/reset outer blocks in buffer");
				for (int q = 1; q <= inindex; q++) {
					// System.out.println("Q---"+q+" I "+w);
					inner = String.valueOf(q);
					outer = String.valueOf(w);
					// qdup=q;

					for (String s : locationData.HOUcustomerBlocks.get(outer).keySet()) {

						for (String p : locationData.NYCdepositorBlocks.get(inner).values()) {
							// System.out.println("Outer"+outer+"||"+inner);

							if (p.equalsIgnoreCase(s)) {

								if (Result.size() != 5) {

									Result.put(s, locationData.HOUcustomerBlocks.get(outer).get(s));
									// System.out.println("Size"+Result.size());
									System.out.println(Result.get(s));
								} else {
									BufferMap.put(5, Result);
									System.out.println("output buffer is full, writing in to file");
									Result.clear();
									bcount++;
								}
							}
						}

					}

					wdup = w + 1;
					if (locationData.HOUcustomerBlocks.size() >= wdup) {
						outer = String.valueOf(wdup);
						// System.out.println("Outer**"+wdup);
						for (String s : locationData.HOUcustomerBlocks.get(outer).keySet()) {

							for (String p : locationData.NYCdepositorBlocks.get(inner).values()) {
								// System.out.println("Outer"+outer+"||"+inner);

								if (p.equalsIgnoreCase(s)) {
									if (Result.size() != 5) {

										Result.put(s, locationData.HOUcustomerBlocks.get(outer).get(s));
										// System.out.println("Size"+Result.size());
										System.out.println(Result.get(s));
									} else {
										BufferMap.put(5, Result);
										System.out.println("output buffer is full, writing in to file");
										Result.clear();
										bcount++;
									}
								}

							}
						}
					}

					if (q % 2 == 0) {
						// System.out.println("change inner"+outer+inner);
						incount++;
						if (incount <= locationData.NYCdepositorBlocks.size()) {
							String ipc = String.valueOf(incount);
							// System.out.println("after"+incount+ipc);
							if (locationData.NYCdepositorBlocks.containsKey(ipc)) {
								inindex++;
								// System.out.println("in
								// changing"+inindex+ipc);
								BufferMap.put(3, locationData.NYCdepositorBlocks.get(ipc));

								incount++;

							}

							String ipc2 = String.valueOf(incount);
							if (locationData.NYCdepositorBlocks.containsKey(ipc2)) {
								inindex++;
								BufferMap.put(4, locationData.NYCdepositorBlocks.get(ipc2));
								bcount++;
							}
							// System.out.println(ipc2);
							System.out.println("Fetching two customer blocks of data from Houston");

							resetBool = true;
							// boolCount++;
						}
						
						// System.out.println("cccc"+bcount);

					}
				}

				if (locationData.HOUcustomerBlocks.size() != wdup) {
					outcount++;
					// System.out.println("in this");
					String opc = String.valueOf(outcount);
					// System.out.println("opc"+opc);
					if (locationData.HOUcustomerBlocks.containsKey(opc)) {
						outindex++;
						BufferMap.put(1, locationData.HOUcustomerBlocks.get(opc));
					}
					outcount++;
					String opc2 = String.valueOf(outcount);
					// System.out.println("opc2"+opc2);
					if (locationData.HOUcustomerBlocks.containsKey(opc2)) {
						// System.out.println("&&"+locationData.HOUcustomerBlocks.get(opc2));
						outindex++;
						BufferMap.put(2, locationData.HOUcustomerBlocks.get(opc2));
					}

				}

			}

			System.out.println("Total number of block transfers is " + bcount);
			System.out.println("========================================================");
			count++;

		}

		if (count == 3) {
			HashMap<String, String> Result2 = new HashMap<String, String>();
			Set<String> tempset = new HashSet<String>();
			int bcount = 0;
			tempset.add("1");
			tempset.add("2");
			tempset.add("3");
			System.out.println("Executing Query 2");
			System.out.println("Fetching 3 blocks of Depositor blocks from NYC");
			System.out.println("Fetching 1 block of Account table from SFO");
			bcount++;
			for (String o : tempset) {
				for (String i : locationData.SFOAccountBlocks.keySet()) {
					for (String s : locationData.NYCdepositorBlocks.get(o).keySet()) {
						for (String p : locationData.SFOAccountBlocks.get(i).keySet()) {
							// System.out.println("S#P"+s+p);
							if (s.equals(p)) {
								String temp = locationData.SFOAccountBlocks.get(i).get(p);
								String cname = locationData.NYCdepositorBlocks.get(o).get(s);
								System.out.println(temp);
								String T[] = temp.split(":");
								Result2.put(cname, T[1]);
								if (Result2.size() > 5) {
									System.out.println("Output Buffer full writing into file");
								}
							}
						}

					}
				}
			}
			bcount++;
			tempset.clear();
			tempset.add("4");
			System.out.println("Fetching remaining block of Depositor blocks from NYC");
			System.out.println("Fetching block of Account table from SFO");
			for (String o : tempset) {
				for (String i : locationData.SFOAccountBlocks.keySet()) {
					for (String s : locationData.NYCdepositorBlocks.get(o).keySet()) {
						for (String p : locationData.SFOAccountBlocks.get(i).keySet()) {
							// System.out.println("S#P"+s+p);
							if (s.equals(p)) {
								String temp = locationData.SFOAccountBlocks.get(i).get(p);
								String cname = locationData.NYCdepositorBlocks.get(o).get(s);
								System.out.println(temp);
								String T[] = temp.split(":");
								Result2.put(cname, T[1]);
								System.out.println("result2 " + Result2.size());
								//
								bcount++;
								if (Result2.size() > 5) {
									System.out.println("Output Buffer full writing into file");
								}
							}
						}

					}
				}

				System.out.println("size of result of query 2 is " + Result2.size());
				System.out.println("writing output into file");
				System.out.println("Total number of block transfers " + bcount);
				System.out.println("========================================================");
			}
			count++;
		}
		if (count == 4) {
			System.out.println("Executing Query 3");
			int bcount = 0;
			HashMap<String, String> Result3 = new HashMap<String, String>();
			ArrayList<String> Join3list = new ArrayList<String>();
			System.out.println("Bring Account block from SFO in to buffer");
			System.out.println("Fetching Three blocks of NYC Depositor table in to buffer");
			Set<String> tempset = new HashSet<String>();
			tempset.add("1");
			tempset.add("2");
			tempset.add("3");
			bcount++;
			bcount++;
			for (String o : locationData.SFOAccountBlocks.keySet()) {
				for (String i : tempset) {
					for (String s : locationData.SFOAccountBlocks.get(o).keySet()) {
						for (String p : locationData.NYCdepositorBlocks.get(i).keySet()) {
							// System.out.println("i"+i+s+p);
							if (s.equalsIgnoreCase(p) && s.equalsIgnoreCase("A10334")) {
								Join3list.add(locationData.NYCdepositorBlocks.get(i).get(p));
							}
						}
					}
				}
			}
			tempset.clear();
			System.out.println("Fetching remaining block of NYC Depositor table into buffer");
			tempset.add("4");
			bcount++;
			for (String o : locationData.SFOAccountBlocks.keySet()) {
				for (String i : tempset) {
					for (String s : locationData.SFOAccountBlocks.get(o).keySet()) {
						for (String p : locationData.NYCdepositorBlocks.get(i).keySet()) {

							if (s.equalsIgnoreCase(p) && s.equalsIgnoreCase("A10334")) {
								Join3list.add(locationData.NYCdepositorBlocks.get(i).get(p));
							}
						}
					}
				}

			}
			tempset.clear();
			tempset.add("1");
			tempset.add("2");
			tempset.add("3");
			bcount++;
			System.out.println("Fetching 3 blocks of data from HOU customer");
			for (String q : Join3list) {
				for (String i : tempset) {

					for (String p : locationData.HOUcustomerBlocks.get(i).keySet()) {
						// System.out.println(i+q+p);
						if (q.equalsIgnoreCase(p)) {
							Result3.put(p, locationData.HOUcustomerBlocks.get(i).get(p));

							System.out.println(
									"The cusomer Street and city information of customer with account number A10334 are");
							System.out.println(Result3.get(p));
						}

					}
					// System.out.println("Hou"+Result3);
				}
				if (Result3.isEmpty()) {
					tempset.clear();
					tempset.add("4");
					tempset.add("5");
					tempset.add("6");
					bcount++;
					System.out.println("Fetching next three bocks of data from HOU customer");
					for (String i : tempset) {

						for (String p : locationData.HOUcustomerBlocks.get(i).keySet()) {
							if (q.equalsIgnoreCase(p)) {
								Result3.put(p, locationData.HOUcustomerBlocks.get(i).get(p));
								System.out.println(
										"The cusomer Street and city information of customer with account number A10334 are");
								System.out.println(Result3.get(p));
							}

						}
						// System.out.println("Hou"+Result3);
					}
				}
				if (Result3.isEmpty()) {
					tempset.clear();
					tempset.add("7");
					tempset.add("8");
					bcount++;
					System.out.println("Fetching next three bocks of data from HOU customer");
					for (String i : tempset) {

						for (String p : locationData.HOUcustomerBlocks.get(i).keySet()) {
							if (q.equalsIgnoreCase(p)) {
								Result3.put(p, locationData.HOUcustomerBlocks.get(i).get(p));
								System.out.println("The cusomer Street and city information of customer with account number A10334 are");
								System.out.println(Result3.get(p));
							}

						}
						// System.out.println("Hou"+Result3);
					}
				}
			}
			System.out.println("total number of block transfers for join " + bcount);
			System.out.println("================================================================");
		}
		{
			HashMap<String, String> Result4 = new HashMap<String, String>();
			Set<String> tempset1 = new HashSet<String>();
			int bcount = 0;
			HashMap<Integer, HashMap<String, String>> BufferMap = new HashMap<Integer, HashMap<String, String>>();
			System.out.println("Executing Query 4");
			System.out.println("Fetching 2 blocks of Account blocks from OMA");
			System.out.println("Fetching block of branch table from NYC");
			bcount++;
			bcount++;
			for (String o : locationData.OMAaccountBlocks.keySet()) {
				for (String i : locationData.Nycbranchblock.keySet()) {
					for (String s : locationData.OMAaccountBlocks.get(o).keySet()) {
						// String p=locationData.Nycbranchblock.get(s);
						// System.out.println("S#P"+s+p);
						String[] temp = locationData.OMAaccountBlocks.get(o).get(s).split(":");
						// System.out.println("t"+temp.toString()+i);
						String[] temp1 = locationData.Nycbranchblock.get(i).split(",");
						// System.out.println(locationData.Nycbranchblock.get(i));

						int assets = Integer.parseInt(temp1[1]);
						if (i.equalsIgnoreCase(temp[0]) && assets < 15000) {
							if (Result4.size() != 5) {
								Result4.put(i + " " + temp[1], temp[1]);
								System.out.println(i + " " + temp[1]);

							} else {
								BufferMap.put(5, Result4);
								// System.out.println(Result4.keySet());
								System.out.println("output buffer is full, writing in to file");
								bcount++;
								Result4.clear();
								Result4.put(i + " " + temp[1], temp[1]);
							}

						}

					}

				}
			}
			System.out.println("number of block transfers "+bcount);
		}

	}

}
