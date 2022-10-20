// Project 2
// Henry Martinez
// 10/03/2022

import java.util.*;

public class Student extends Person implements Displayable
{
   private int studentId;
   private int finalGrade;
   
   public Student()
   {
      firstName = "";
      lastName = "";
      studentId = 0;
      finalGrade = 0;
   }
   
   public Student(String first, String last, int id, int grade)
   {
      this.firstName = first;
      this.lastName = last;
      this.studentId = id;
      this.finalGrade = grade;
   }
   
   public int getStudentId()
   {
      return studentId;
   }
   
   public void setStudentId(int id)
   {
      this.studentId = id;
   }
   
   public int getFinalGrade()
   {
      return finalGrade;
   }
   
   public void setFinalGrade(int grade)
   {
      this.finalGrade = grade;
   }
   
   @Override 
   public String display()
   {
      return "Student ID: " + getStudentId() + ", " + getFullName() + ", Final Grade: " + getFinalGrade();
   }
}