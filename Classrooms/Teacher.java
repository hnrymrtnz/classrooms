// Project 2
// Henry Martinez
// 10/03/2022

import java.util.*;

public class Teacher extends Person implements Displayable
{
   private String subject;
   
   public Teacher()
   {
      firstName = "";
      lastName = "";
      subject = ""; 
   }
   
   public Teacher(String first, String last, String sub)
   {
      this.firstName = first;
      this.lastName = last;
      this.subject = sub;
   }
   
   public String getSubject()
   {
      return subject;
   }
   
   public void setSubject(String sub)
   {
      this.subject = sub;
   }
   
   
   @Override 
   public String display()
   {
      return getFullName() + " teaches " + this.subject;
   } 
}