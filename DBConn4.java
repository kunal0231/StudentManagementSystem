package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

public class DBConn4 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		try(sc)
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","kunal");
			PreparedStatement ps1 = con.prepareStatement("insert into student39 values (?,?,?,?,?,?,?)");
			PreparedStatement ps2 = con.prepareStatement("select * from student39 where sroll=? and sname=?");
			PreparedStatement ps3 = con.prepareStatement("select * from student39 where spercentage>60");
			PreparedStatement ps4 = con.prepareStatement("update student39 set mailid=?,sphoneno=? where sroll=?");
			PreparedStatement ps5 = con.prepareStatement("delete from student39 where spercentage between 30 and 60");
			PreparedStatement ps6 = con.prepareStatement(" select count(*) from student39 where spercentage>80");
			PreparedStatement ps7 = con.prepareStatement("select * from student39");
			System.out.println("**************Welcome to Student register & Login process**************");
			
			while(true)
			{
				
				System.out.println("\t1.Register\n\t2.Login\n\t3.Exit");
				System.out.println("Enter your choice: ");
				int choice= sc.nextInt();
			switch(choice)
			{
			case 1:
			{
				System.out.println("Welcome to registration process");
				System.out.print("Enter your roll number: ");
				int rollno = sc.nextInt();
				System.out.print("Enter your name: ");
				String sname = sc.nextLine();
				sname = sc.nextLine();
				System.out.print("Enter your percentage: ");
				float percentage = sc.nextFloat();
				System.out.print("Enter your first name: ");
				String fname = sc.nextLine();
				fname = sc.nextLine();
				System.out.print("Enter your last name: ");
				String lname = sc.nextLine();
				System.out.print("Enter your mail id: ");
				String mail = sc.nextLine();
				System.out.print("Enter your phone number: ");
				long phoneNo = sc.nextLong();
				
				
				
				ps1.setInt(1, rollno);
				ps1.setString(2, sname);
				ps1.setFloat(3, percentage);
				ps1.setString(4, fname);
				ps1.setString(5, lname);
				ps1.setString(6, mail);
				ps1.setLong(7, phoneNo);
				int k = ps1.executeUpdate();
				if(k>0)
				{
					System.out.println("Student Registered Successfully");
					System.out.println("--------------------------------------------------");

				}				
			}
				break;
			case 2:
			{
				System.out.print("Enter your roll no:");
				int roll = sc.nextInt();
				System.out.print("Enter your name: ");
				String name = sc.nextLine();
				name = sc.nextLine();
				ps2.setInt(1, roll);
				ps2.setString(2, name);
				ResultSet rs = ps2.executeQuery();
				if(rs.next())
				{
					System.out.println("**************Login Successfull**************");
					System.out.println(rs.getInt(1)+"\t"
							+rs.getString(2)+"\t"
							+rs.getFloat(3)+"\t"
							+rs.getString(4)+"\t"
							+rs.getString(5)+"\t"
							+rs.getString(6)+"\t"
							+rs.getLong(7)
							);
					
					System.out.println("--------------------------------------------------");
					boolean flag = true;
				while(flag)
					{
					System.out.println("\t1.Show Students whose percentage > 60%"
							+ "\n\t2.Update MailId and Phone number based on roll no"
							+ "\n\t3.Delete student whose percentage between 30% to 60%"
							+ "\n\t4.Find how many student got more than 80%"
							+"\n\t5.View All Student"
							+"\n\t6.Logout");
					int ch = sc.nextInt();
					switch(ch)
					{
					case 1:
					{
						ResultSet rs1 = ps3.executeQuery();
						while(rs1.next())
						{
							System.out.println(rs1.getInt(1)+"\t"
									+rs1.getString(2)+"\t"
									+rs1.getFloat(3)+"\t"
									+rs1.getString(4)+"\t"
									+rs1.getString(5)+"\t"
									+rs1.getString(6)+"\t"
									+rs1.getLong(7));
						}
					}
					System.out.println("--------------------------------------------------");

						break;
					case 2: 
					{
						System.out.print("Enter the roll number of Student whom you want to update: ");
						int r = sc.nextInt();
						System.out.print("Enter new mail id to update: ");
						String mail = sc.nextLine();
						mail = sc.nextLine();
						System.out.print("Enter new phone number to update: ");
						long phone = sc.nextLong();
						ps4.setString(1, mail);
						ps4.setLong(2, phone);
						ps4.setInt(3, r);
						int k1 = ps4.executeUpdate();
						if(k1>0)
						{
							System.out.println("Phone and email updated successfully....");
							
						
						}
						else
						{
							System.err.println("Invalid Roll No.....");
						}
					}
					System.out.println("--------------------------------------------------");

						break;
					case 3:
					{
						int k2 = ps5.executeUpdate();
						if(k2>0)
						{
							System.out.println("Student deleted from table whose percentage in between 30 to 60");
						}
						else
						{
							System.err.println("No student found whose percentage in between 30 to 60");
						}
						
					}
					System.out.println("--------------------------------------------------");

						break;
					case 4:
					{
						ResultSet rs3 = ps6.executeQuery();
						while(rs3.next())
						{
							System.out.println(rs3.getString(1));//
						}
					}
					System.out.println("--------------------------------------------------");

						break;
					case 5:
					{
						ResultSet rs4 = ps7.executeQuery();
						while(rs4.next())
						{
							System.out.println(rs4.getInt(1)+"\t"
									+rs4.getString(2)+"\t"
									+rs4.getFloat(3)+"\t"
									+rs4.getString(4)+"\t"
									+rs4.getString(5)+"\t"
									+rs4.getString(6)+"\t"
									+rs4.getLong(7)
									);
						}
					}
					System.out.println("--------------------------------------------------");

					break;
					case 6:
					{
						System.out.println("Logout Successfully");
						flag=false;
						System.out.println("--------------------------------------------------");

						break;
					}
//					
					default: System.err.println("Invalid Input");
					System.out.println("--------------------------------------------------");

					}
					
				}
				}
				else
				{
					System.err.println("Invalid roll or Name");
				}
			}
				break;
			case 3:
				System.out.println("Thankyou for using student portal");
				con.close();
				System.out.println("--------------------------------------------------");

				System.exit(0);
			default: System.err.println("Invalid Input");
			}
	}
		}
		catch(SQLIntegrityConstraintViolationException e)
		{
			System.err.println("Student is already exist");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
