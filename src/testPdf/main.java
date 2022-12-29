package testPdf;

import java.io.*;
import java.util.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class main {

	public static void main(String[] args) {
		Stack<String> stack= new Stack<String>(); 

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
		int count=0;

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
}


