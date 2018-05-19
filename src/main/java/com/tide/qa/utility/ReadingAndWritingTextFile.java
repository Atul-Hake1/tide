package com.tide.qa.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadingAndWritingTextFile {
	// Program for reading and writing text file

	FileReader filename;
	BufferedReader inputFile;
	String userCounter;
	int ucount;
	FileWriter writefile;
	BufferedWriter outputFile;
	String emailID;

	public int getCount() {
		try {
			try {
				filename = new FileReader(
						".\\src\\main\\resources\\count.txt");
				inputFile = new BufferedReader(filename);
				userCounter = inputFile.readLine();
				ucount = Integer.parseInt(userCounter);
			} catch (FileNotFoundException e) {
				System.out
				.println("File :- \'count.txt\' isn't found at location.");
			} finally {
				inputFile.close();
				filename.close();
			}
		} catch (IOException e) {
			System.out.println("Exception while reading a file "
					+ e.getMessage());
		}
		return ucount;
	}

	public String getSignUpEmail() {
		try {
			try {
				filename = new FileReader(
						".\\src\\main\\resources\\SignUpMail.txt");
				inputFile = new BufferedReader(filename);
				userCounter = inputFile.readLine();
				emailID = userCounter;
			} catch (FileNotFoundException e) {
				System.out
				.println("File :- \'SignUpMail.txt\' isn't found at location.");
			} finally {
				inputFile.close();
				filename.close();
			}
		} catch (IOException e) {
			System.out.println("Exception while reading a file "
					+ e.getMessage());
		}
		return emailID;
	}
	public String getPeopleEmail() {
		try {
			try {
				filename = new FileReader(
						".\\src\\main\\resources\\PeopleMail.txt");
				inputFile = new BufferedReader(filename);
				userCounter = inputFile.readLine();
				emailID = userCounter;
			} catch (FileNotFoundException e) {
				System.out
				.println("File :- \'PeopleMail.txt\' isn't found at location.");
			} finally {
				inputFile.close();
				filename.close();
			}
		} catch (IOException e) {
			System.out.println("Exception while reading a file "
					+ e.getMessage());
		}
		return emailID;
	}
	public int getCount(String filePath) {
		try {
			try {
				filename = new FileReader(filePath);
				inputFile = new BufferedReader(filename);
				userCounter = inputFile.readLine();
				ucount = Integer.parseInt(userCounter);
			} catch (FileNotFoundException e) {
				System.out
				.println("File :- \'count.txt\' isn't found at location.");
			} finally {
				inputFile.close();
				filename.close();
			}
		} catch (IOException e) {
			System.out.println("Exception while reading a file "
					+ e.getMessage());
		}
		return ucount;
	}

	public void putCount(String updateCount) {
		try {
			try {
				writefile = new FileWriter(
						".\\src\\main\\resources\\count.txt");
				outputFile = new BufferedWriter(writefile);
				outputFile.write(updateCount);
			} catch (FileNotFoundException e) {
				System.out
				.println("File :- \'count.txt\' isn't found at location.");
			} finally {
				outputFile.close();
				writefile.close();
			}
		} catch (IOException ex) {
			System.out.println("Exception while writing a file");
		}
	}
	public void putSignUpMail(String updateCount) {
		try {
			try {
				writefile = new FileWriter(
						".\\src\\main\\resources\\SignUpMail.txt");
				outputFile = new BufferedWriter(writefile);
				outputFile.write(updateCount);
			} catch (FileNotFoundException e) {
				System.out
				.println("File :- \'SignUpMail.txt\' isn't found at location.");
			} finally {
				outputFile.close();
				writefile.close();
			}
		} catch (IOException ex) {
			System.out.println("Exception while writing a file");
		}
	}
	
	public void putPeople(String updateCount) {
		try {
			try {
				writefile = new FileWriter(
						".\\src\\main\\resources\\PeopleMail.txt");
				outputFile = new BufferedWriter(writefile);
				outputFile.write(updateCount);
			} catch (FileNotFoundException e) {
				System.out
				.println("File :- \'PeopleMail.txt\' isn't found at location.");
			} finally {
				outputFile.close();
				writefile.close();
			}
		} catch (IOException ex) {
			System.out.println("Exception while writing a file");
		}
	}
	public void putCount(String filePath, String updateCount) {
		try {
			try {
				writefile = new FileWriter(filePath);
				outputFile = new BufferedWriter(writefile);
				outputFile.write(updateCount);
			} catch (FileNotFoundException e) {
				System.out
				.println("File :- \'count.txt\' isn't found at location.");
			} finally {
				outputFile.close();
				writefile.close();
			}
		} catch (IOException ex) {
			System.out.println("Exception while writing a file");
		}
	}

	private boolean flag=false;

	public boolean getEmailFlag()
	{
		try {
			try {
				filename = new FileReader(".\\src\\test\\resources\\emailFlag.txt");
				inputFile = new BufferedReader(filename);

				userCounter = inputFile.readLine();
				flag=Boolean.parseBoolean(userCounter);
				System.out.println(flag);
			} catch (FileNotFoundException e) {
				System.out.println("File :- \'emailFlag.txt\' isn't found at location.");
			} finally {
				inputFile.close();
				filename.close();
			}
		} catch (IOException e) {
			System.out.println("Exception while reading a file " +e.getMessage());
		}

		return flag;
	}


	public void setEmailFlag(boolean flagValue)
	{
		try {
			try{
				writefile=new FileWriter(".\\src\\test\\resources\\emailFlag.txt");
				outputFile=new BufferedWriter(writefile);
				outputFile.write(new Boolean(flagValue).toString());
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File :- \'emailFlag.txt\' isn't found at location.");
			}
			finally
			{
				outputFile.close();
				writefile.close();
			}
		}catch(IOException ex)
		{
			System.out.println("Exception while writing a file");
		}
	}

	public void writeToTextLog(String filePath, String updateCount,String mode)
	{
		try {
			try {
				if(mode.trim().equalsIgnoreCase("append"))
				{
					writefile = new FileWriter(filePath,true);	
					outputFile = new BufferedWriter(writefile);
					outputFile.write(updateCount);
					outputFile.newLine();

				}else if(mode.trim().equalsIgnoreCase("appendNoNewLine"))
				{
					writefile = new FileWriter(filePath,true);
					outputFile = new BufferedWriter(writefile);
					outputFile.write(updateCount);

				}else if(mode.trim().equalsIgnoreCase("newNoNewLine"))
				{
					writefile = new FileWriter(filePath);
					outputFile = new BufferedWriter(writefile);
					outputFile.write(updateCount);
				}else
				{
					writefile = new FileWriter(filePath);
					outputFile = new BufferedWriter(writefile);
					outputFile.write(updateCount);
					outputFile.newLine();
				}
				//outputFile = new BufferedWriter(writefile);
				//outputFile.write(updateCount);
				//outputFile.newLine();
			} catch (FileNotFoundException e) {
				Report.LogInfo("Exception", "Exception in writeToTextLog "+e.getMessage(), "FAIL");
			} finally {
				outputFile.close();
				writefile.close();
			}
		} catch (IOException ex) {
			System.out.println("Exception while writing a file");
		}
	}	
	public String readEntireFile(String filename) throws IOException {
		FileReader in = new FileReader(filename);
		StringBuilder contents = new StringBuilder();
		char[] buffer = new char[4096];
		int read = 0;
		do {
			contents.append(buffer, 0, read);
			read = in.read(buffer);
		} while (read >= 0);
		return contents.toString();
	}


}
