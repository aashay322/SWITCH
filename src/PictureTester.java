import java.awt.Color;

 
public class PictureTester
    {   
     public static void recognizeColor()
     {
        Picture maps = new Picture("autopic.jpg");
        maps.explore();
        Color value; 
        int i,j,red, green,blue;
        for(i = 10; i < 200; i++)
        {
            for(j = 10; j < 200; j++)
            {
                value = maps.getPixel(i,j).getColor();
                red = value.getRed(); 
                blue = value.getBlue(); 
                green = value.getGreen();
                System.out.println(" Row= " + j + " Col= " + i + "  " + red + "," + green + "," + blue);
            }
        }
        
    }
    
    public static void colorArray()
    {
       Picture maps = new Picture ("autopic.jpg"); 
       maps.explore(); 
       Color value; 
       int i,j,red, green, blue; 
       double Lat = 49.489544; 
       double Long = -125.24354; 
       String tester = "";
       int x = 1; 
       for(i = 198; i < 366; i++)            
       {
           for(j = 85; j < 666; j++)
           {
             value = maps.getPixel(j,i).getColor();
             red = value.getRed(); 
             green = value.getGreen(); 
             blue = value.getBlue(); 
             Lat = -0.069284*(i-16) + 48.381;
             Long = 0.08774*(j-6) - 124.7172;
             tester = checkForFire(red, green, blue, i, j, Lat , Long); 
              
             if(tester.equals("Large fire probability at row: " + i + " col: " + j  + "at Latitude=" + Lat + " and at Longitude= " + Long))
             {
                 System.out.println(tester);
                 if (x == 1)
                 {
                    SWITCHEmail myEmail = new SWITCHEmail();
                    x++;
                    try{ 
                        myEmail.main();
                    } catch (Exception ex){ 
                        System.out.println("Sry looks there was an error.");
                    }
                    return;
                 }
                
             }
                
           }
       }
    }
    
    public static String checkForFire (int red, int green, int blue, int i, int j, double Lat, double Long) 
    {
        String returnValue = "";
        if(red >=145 && red <= 155 && green >= 85 && green <= 95 && blue >= 65 && blue <= 75) 
        {
            returnValue = "Large fire probability at row: " + i + " col: " + j  + "at Latitude=" + Lat + " and at Longitude= " + Long;
            
        }
        return returnValue; 
    }
     
    public static void main()
    {
        colorArray(); 
    }
   }