package Scraper;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        try
        {
            Vehicle.PopulateFromHTML("WF10EDK");
        }
        catch(IOException IOE)
        {

        }
    }
}
