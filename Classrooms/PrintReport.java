// Project 2
// Henry Martinez
// 10/03/2022

import java.util.*;

public class PrintReport
{
	Scanner in = new Scanner(System.in);
   
	char answer;
   
	ArrayList<Displayable> list = new ArrayList<Displayable>();
   
	public PrintReport()
	{
		System.out.println("First you must create a classroom.");
      
		do 
      {
			Displayable c = enterClassroom();
			list.add(c);
         
			System.out.print("Enter another classroom (Y or N)? ");
			answer = in.next().toUpperCase().charAt(0); 
         in.nextLine();
         
		} while (answer != 'N');
		
		report(list);	
	}
   
	public Displayable enterClassroom()
	{
		ArrayList<Displayable> studentList = new ArrayList<Displayable>();
      
		System.out.print("Enter Room Number: ");
      
      int room = in.nextInt();
      
      while (room < 100)
      {
         System.out.println("Enter a room number that is greater than or equal to 100.");
         System.out.print("Enter Room Number: ");
         room = in.nextInt();
      }
      
      in.nextLine();
      
		System.out.println("Now you must enter a teacher for the classroom.");
		Displayable teacher = enterTeacher();
      
		System.out.println("Now you must add students for the classroom.");
      
		do 
      {
			// create and add students until user enters N as an answer
         Displayable student = enterStudent();
         studentList.add(student);
         
         System.out.print("Enter another student (Y or N)? ");
			answer = in.next().toUpperCase().charAt(0); 
         in.nextLine();
         
		} while (answer != 'N');
	
      Displayable classroom = new Classroom(room, teacher, studentList);
		return classroom;
	}
	
	public Displayable enterTeacher()
	{
      String firstName;
      String lastName;
      String subject;
      
		System.out.print("Please enter the teacher's first name: ");
      firstName = in.nextLine();
      
      System.out.print("Please enter the teacher's last name: ");
      lastName = in.nextLine();
      
      System.out.print("Please enter the teacher's subject: ");
      subject = in.nextLine();
      
      Teacher teacher = new Teacher(firstName, lastName, subject);
      return teacher;
   }
	
	public Displayable enterStudent()
	{
      String firstName;
      String lastName;
		int studentId;
      int finalGrade;
      
      System.out.print("Please enter the student's first name: ");
      firstName = in.nextLine();
      
      System.out.print("Please enter the student's last name: ");
      lastName = in.nextLine();
      
      System.out.print("Please enter the student's ID: ");
      studentId = in.nextInt();
      while (studentId <= 0)
      {
         System.out.println("Enter a student ID that is greater than 0.");
         System.out.print("Please enter the student's ID: ");
         studentId = in.nextInt();
      }
      
      System.out.print("Please enter the student's final grade: ");
      finalGrade = in.nextInt();
      while ((finalGrade < 0) || (finalGrade > 100))
      {
         System.out.println("Enter a final grade that is between 0 and 100.");
         System.out.print("Please enter the student's final grade: ");
         finalGrade = in.nextInt();
      } 
      
      Student student = new Student(firstName, lastName, studentId, finalGrade);
      return student;
	}
	
	void report(ArrayList<Displayable> list)
	{
		for (Displayable i : list)
      {
         System.out.println(((Classroom) i).display());
      }	
   }
}