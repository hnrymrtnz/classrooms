// Project 2
// Henry Martinez
// 10/03/2022

import java.util.*;

public class Classroom extends Person implements Displayable
{
   int roomNumber;
   Displayable teacher;
   ArrayList<Displayable> students;
   
   public Classroom(int room, Displayable teacher, ArrayList<Displayable> students)
   {
      this.roomNumber = room;
      this.teacher = teacher;
      this.students = students;
   }
   
   public static String toString(ArrayList<Displayable> students)
   {
      String studentList = "";
      
      for (int i = 0; i < students.size(); i++)
      {
         studentList = studentList + (students.get(i)).display() + "\n";
      } 
      
      return studentList;
   }
   
   @Override 
   public String display()
   {
      return 
         "\nRoom Number: " + roomNumber + "\n" +
         teacher.display() + "\n" +
         toString(students);   
   }
}