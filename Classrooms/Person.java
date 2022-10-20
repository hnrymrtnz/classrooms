// Project 2
// Henry Martinez
// 10/03/2022

import java.util.*;

public abstract class Person
{
   String firstName;
   String lastName;
   
   public String getFirstName()
   {
      return firstName;
   }
   
   public String getLastName()
   {
      return lastName;
   }
   
   public void setFirstName(String name)
   {
      this.firstName = name;
   }
   
   public void setLastName(String name)
   {
      this.lastName = name;
   }
   
   public String getFullName()
   {
      return firstName + " " + lastName;
   }
}