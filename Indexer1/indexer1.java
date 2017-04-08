import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class indexer1
{
	public static void main(String[] args) throws FileNotFoundException,IOException
	{
		HashMap<String, Integer> filenames = new HashMap<>();
		HashMap<String, ArrayList<Integer> > dictionary = new HashMap<>();
		ArrayList<String> stopwords =new ArrayList<String>();
		File folder = new File("/home/aditya/shubhankar/eng");
		File[] listOfFiles = folder.listFiles();
		FileWriter fw = new FileWriter(new File("doc.txt"));
		for (int i = 0; i < listOfFiles.length; i++)
		{
			if (listOfFiles[i].isFile())
			{
				fw.flush();
				fw.write("/home/aditya/shubhankar/eng/"+listOfFiles[i].getName());
				fw.write("\n");
			}

		}
		FileReader fr = new FileReader(new File("doc.txt"));
		Scanner sc = new Scanner(fr);
		Integer counter=0;
		
		FileReader f1= new FileReader(new File("stopwords.txt"));
		Scanner scan= new Scanner(f1);
		while(scan.hasNext())
		{
			String abc= scan.next();
			stopwords.add(abc);
		}

		while (sc.hasNext())
		{
			String s = sc.next();
			filenames.put(s,++counter);
			FileReader fr1= new FileReader(new File(s));
			Scanner sc1=new Scanner(fr1);

			while (sc1.hasNext())
			{
				String s1=sc1.next();
				int flag1=1;

				for(int i=0;i<s1.length();i++)
				{
						if(s1.contains("0") || s1.contains("1")|| s1.contains("2") || s1.contains("3")|| s1.contains("4") || s1.contains("5")|| s1.contains("6") || s1.contains("7") ||s1.contains("8") || s1.contains("9"))
						{
								flag1=0;
						}
						if(s1.startsWith(".") || s1.startsWith(",") || s1.startsWith("<") || s1.startsWith("-")|| s1.startsWith("-")|| s1.startsWith("-") || s1.startsWith("'")|| s1.startsWith("|") || s1.startsWith("||"))
						{
							s1=s1.substring(1,s1.length());
						}
						if(s1.endsWith(".") || s1.endsWith(",") || s1.endsWith(">") || s1.endsWith("-")|| s1.endsWith("}")|| s1.endsWith(")") || s1.endsWith("'") || s1.endsWith("|") || s1.endsWith("||") || s1.endsWith("="))
						{
							s1=s1.substring(s1.length()-1);
						}

				}

				if(!stopwords.contains(s1) && flag1==1)
				{
					PorterStemmer stemmer= new PorterStemmer();
					s1.toLowerCase();
					stemmer.stem(s1);

					if(dictionary.containsKey(s1))
					{
						ArrayList<Integer> flag = dictionar63333333+y.get(s1);
						if(!flag.contains(counter))
						{
							flag.add(counter);
							dictionary.put(s1,flag);
						}
					}
					else
					{
						ArrayList<Integer> flag = new ArrayList<Integer> ();
						flag.add(counter);
						dictionary.put(s1,flag);
					}

			}

		}
	}

					System.out.println(dictionary);
	}
}
