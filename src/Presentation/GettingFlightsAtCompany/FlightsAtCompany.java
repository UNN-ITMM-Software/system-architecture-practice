/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation.GettingFlightsAtCompany;

import Model.AplicationObject.IFlight;
import Model.DataAccess.BDataManagement;
import Model.DataAccess.IDataManagement;
import Model.Request.RequestAllFlights;
import Model.Response.ResponseSetFlights;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import Model.Logon.IRole;

class FlightsAtCompany implements IFlightsAtCompany{

    IRole r; 
    IDataManagement dm;
    
    public FlightsAtCompany(IRole r)
    {
        this.r = r;
        dm = BDataManagement.build();
    }
    
    @Override
    public Iterator<IFlight> all() {
        Iterator<IFlight> itr;
        
        ResponseSetFlights res= (ResponseSetFlights)
                dm.exec(new RequestAllFlights(r));
        
        itr = res.iterator();
        return itr;
    }
    
    @Override
    public Iterator<IFlight> since(Date from)
    {
        ArrayList<IFlight> al = new ArrayList<>();
        Iterator<IFlight> itr;
        IFlight fl;
        itr = all();
        while(itr.hasNext())
        {
            fl = itr.next();
            if(fl.departureTime().after(from)){
                al.add(fl);
            }
        }
        return al.iterator();
    }

    @Override
    public boolean validate(IFlight flights) {
        Iterator<IFlight> itr;
        itr = all();
        while(itr.hasNext())
        {
            if(itr.next().flightsID().equals(flights.flightsID())) return true;
        }
        return false;
    }
    
}
