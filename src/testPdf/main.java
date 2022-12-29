package testPdf;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.nio.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class main {

	public static void main(String[] args) {
		Stack<String> stack= new Stack<String>(); 
		Stack<String> search= new Stack<String>(); 
		Scanner sr = new Scanner(System.in);
		int count=0;

		boolean loop = true;
		while (loop) {

			System.out.println("Enter 1 to generate 100 pdf file ");
			System.out.println("Enter 2 to serach for words in pdf files ");
			System.out.println("Enter 0 to exit ");
			int input = sr.nextInt();
			if(input==2) {

				for(int i=0;i<4;i++) {
					System.out.println("Enter a word to search in the files ");
					String searchWord=sr.next();
					search.push(searchWord);
			
				}
				
				int count2=0;
				while(count2!=100) {
					int countSearch=0;
				
					for(String searchWord: search) {
						try {
							BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Lenovo\\Desktop\\project\\test"+count2+".pdf")); //Creation of BufferedReader object
							String s;
			     
							while((s=br.readLine())!=null)   //Reading Content from the file
							{
								
								if (s.equals(searchWord))   //Search for the given word
								{
									countSearch++;
								}
							
								
							}							
						
			      
							if(countSearch==1)  //Check for count not equal to zero
							{
								File source = new File("C:\\Users\\Lenovo\\Desktop\\project\\test"+count2+".pdf");
								File dest = new File("C:\\Users\\Lenovo\\Desktop\\project\\1match\\test"+count2+".pdf");
								//copy file in folder
								Files.copy(source.toPath(), dest.toPath());
							}
							
							if(countSearch==2)  //Check for count not equal to zero
							{
								File source = new File("C:\\Users\\Lenovo\\Desktop\\project\\test"+count2+".pdf");
								File dest = new File("C:\\Users\\Lenovo\\Desktop\\project\\2match\\test"+count2+".pdf");
								//copy file in folder
								Files.copy(source.toPath(), dest.toPath());
							}
							
							if(countSearch==3)  //Check for count not equal to zero
							{
								File source = new File("C:\\Users\\Lenovo\\Desktop\\project\\test"+count2+".pdf");
								File dest = new File("C:\\Users\\Lenovo\\Desktop\\project\\3match\\test"+count2+".pdf");
								//copy file in folder
								Files.copy(source.toPath(), dest.toPath());
							}
							
							if(countSearch==4)  //Check for count not equal to zero
							{
								File source = new File("C:\\Users\\Lenovo\\Desktop\\project\\test"+count2+".pdf");
								File dest = new File("C:\\Users\\Lenovo\\Desktop\\project\\4match\\test"+count2+".pdf");
								//copy file in folder
								Files.copy(source.toPath(), dest.toPath());
							}

			      
			      
							br.close();
							count2++;

						}
						catch (IOException except)
						{
							except.printStackTrace();
						}
					}
			}
			}
			
			if(input==1) {
				try {
					BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\Lenovo\\Desktop\\project\\sample.txt")); //Creation of BufferedReader object
					Scanner scan = new Scanner(read);
					while(scan.hasNextLine()) {
						stack.push(scan.nextLine());
					}
				}
				catch (IOException except)
				{
					except.printStackTrace();
				}

				for(String s: stack) {
					try {
						Document document = new Document();
						PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Lenovo\\Desktop\\project\\test"+count+".pdf"));
				
						document.open();
						document.add(new Paragraph(s));
						document.close();
						count++;
					}
					catch(Exception e) {
						System.out.println(e);
					}
				}
		
		System.out.println(count+" file created");

	}
			else {
				System.out.println("exit");
			}
		}
	}
	}



