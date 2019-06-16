/*
          >*<  
          /o\
         /_\_\
        /_/_2_\
       /_o_\1\_\
      /_/_/_/2/_\
     /C\_\_\H\_\_\
    /_/S/G/_/_/O/_\
   /_\_\A\_\L\o\_\_\
  /_/0/_/_/_N_/_/E/_\
 /_\_\_\_\G\I\_\_\_\_\
/_/o/_/E/@/N/_/O/_/N/_\
         [___]


*/
import java.io.*;
import java.util.*;
class gang
{
    public static void main(String[] args) throws Exception
    {
        new gang().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("gang.java"));
        file.nextLine();
        for(int i=0;i<13;i++)System.out.println(file.nextLine());
    }
}