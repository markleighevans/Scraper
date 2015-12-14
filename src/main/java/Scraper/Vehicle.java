package Scraper;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by mark on 14/12/15.
 */
public class Vehicle {
    private String VRM;
    private String Make;
    private String Model;
    private String Colour;
    private String FirstReg;
    private String MOTDate;
    private String TaxDate;
    private String  Weight;


    public String GetVRM()
    {
        return this.VRM;
    }
    public void SetVRM(String VRM)
    {
        this.VRM = VRM;
    }
    public String GetMake()
    {
        return this.Make;
    }
    public void SetMake(String Make)
    {
        this.Make = Make;
    }
public static void PopulateFromHTML (String VRM) throws IOException
    {

try {
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF);
        String url = "https://www.vehicleenquiry.service.gov.uk";
        final WebClient webClient = new WebClient(BrowserVersion.CHROME);
        final HtmlPage InputPage = webClient.getPage(url);
        String HtmlContent = "";
        HtmlInput VRMInput = InputPage.getElementByName("ctl00$MainContent$txtSearchVrm");
        VRMInput.setValueAttribute("WF10EDK");

        HtmlInput MakeInput = InputPage.getElementByName("ctl00$MainContent$MakeTextBox");
        MakeInput.setValueAttribute("VOLKSWAGEN");

        HtmlSubmitInput submitBtn = InputPage.getElementByName("ctl00$MainContent$butSearch");
        final HtmlPage ResultsPage = submitBtn.click();

        System.out.println(ResultsPage.getTitleText());
        List<DomNode> DivAll = (List<DomNode>) ResultsPage.getByXPath("/html/body/form/div[7]/div/div/ul");
        int Iterator = 0;
        while (Iterator < DivAll.size()) {
            HtmlContent = DivAll.get(Iterator).asText();
            Iterator++;
        }

        List<DomNode> DivVEDMOT = (List<DomNode>) ResultsPage.getByXPath("/html/body/form/div[7]/div/div/div[2]");
        Iterator = 0;
        while (Iterator < DivVEDMOT.size()) {
            System.out.println(DivVEDMOT.get(Iterator).asText());
            Iterator++;
        }
        System.out.println(HtmlContent.toString());}
catch (IOException ioe)
{
    System.out.println("Exception!");
}

    }
}
