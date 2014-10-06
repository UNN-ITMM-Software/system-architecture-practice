/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import Model.AplicationObject.IFlight;
import Presentation.GettingFlightsAtCompany.BFlightsAtCompany;
import Presentation.GettingFlightsAtCompany.IFlightsAtCompany;
import Model.DataAccess.IDataManagement;
import Model.DataAccess.IObserver;
import java.util.Iterator;
import Model.Logon.BAuthentication;
import Model.Logon.IRole;

public class ViewAllFlightsText  implements IView, IObserver{

    IRole r = BAuthentication.getRole(); 
    
    IFlightsAtCompany fatc;
    
    public ViewAllFlightsText()
    {
        fatc = BFlightsAtCompany.build(r);
    }
    
    @Override
    public void refresh(IDataManagement dm) 
    {
        Iterator<IFlight> itr;
        itr = fatc.all();
        
        int i = 1;
        System.out.println("Рейсы компании:");
        while(itr.hasNext())
        {
            IFlight fl = itr.next();
            System.out.println(i + ". (" + fl.flightsID() + ")"
                    + " из " + fl.startAirport().toString() 
                    + " в "  + fl.finishAirport().toString() 
                    + "("+fl.arrivalTime().toString()+":"
                    + fl.departureTime() + ")"
            );
            i++;
        }
        System.out.println();
    }

    @Override
    public void init(IRole r) {
        this.r = r;
    }
    
}
