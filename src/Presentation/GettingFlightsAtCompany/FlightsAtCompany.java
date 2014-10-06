/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation.GettingFlightsAtCompany;

import Model.AplicationObject.IFlight;
import Model.DataAccess.BDataManagement;
import Model.DataAccess.IDataManagement;
import Model.Filters.BFilters;
import Model.Filters.IFilters;
import Model.Request.RequestAllFlights;
import Model.Response.ResponseSetFlights;
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
        IFilters filter = BFilters.build();
        return filter.flightsSinceDate(all(), from);        
    }

    @Override
    public boolean validate(IFlight flight) {
        IFilters filter = BFilters.build();
        return filter.validateFlights(all(), flight);        
    }
    
}
