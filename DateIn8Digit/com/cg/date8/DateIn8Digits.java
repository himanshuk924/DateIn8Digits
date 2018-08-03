package com.cg.date8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateIn8Digits {

	public static void main(String[] args) throws IOException {
		
		//Initialize date format for parsing
		SimpleDateFormat simpledateformat= new SimpleDateFormat("ddMMyyyy"); 
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the date in ddmmyyyy");
		
		String dateStr=br.readLine();
		simpledateformat.setLenient(false);
		
		Date date=null;
		try
		{
			 date=simpledateformat.parse(dateStr);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Wrong Input");
		}
		
		//Checking is date entered is before current time
		if(date.before(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant())))
		{
			System.out.println("The day,month or year are outside acceptable limits");
			System.exit(1);
		}
		
		//Defining new date format 
		simpledateformat=new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Date in dd/mm/yyyy format- "+simpledateformat.format(date));
		
		//Defining new date format
		simpledateformat=new SimpleDateFormat("dd MMMMM, yyyy");
		System.out.println("Date in dd month, yyyy format- "+simpledateformat.format(date));
		

	}

}

