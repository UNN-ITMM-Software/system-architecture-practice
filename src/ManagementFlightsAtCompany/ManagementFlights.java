/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagementFlightsAtCompany;

import AplicationObject.EResponseState;
import AplicationObject.IAirplane;
import AplicationObject.IAirport;
import AplicationObject.IFlight;
import DataAccess.BDataManagement;
import DataAccess.IDataManagement;
import DataAccess.IResponse;
import DataAccess.Request.RequestAddFlight;
import DataAccess.Request.RequestCancelFlight;
import java.util.Date;
import java.util.UUID;
import logon.BAuthentication;
import logon.IRole;

/**
 *
 * @author Evgeniy
 */
class ManagementFlights implements IManagementFlights{

    IRole r = BAuthentication.getRole();
    IDataManagement dm;
    
    public ManagementFlights(IRole r)
    {
        if(r != null)
        {
            this.r = r;
        }
        dm = BDataManagement.build();
    }
    
    @Override
    public IFlight addFlight(IAirport start, IAirport finish, 
                       IAirplane airplane,
                       Date departureTime, Date arrivalTime) 
    {
        UUID id = UUID.randomUUID();
        IFlight fl = new Flight(id, start, finish, airplane,
                departureTime, arrivalTime);
        RequestAddFlight addF = new RequestAddFlight(r, fl);
        
        IResponse res = dm.exec(addF);    
        
        if(res.state() == EResponseState.OK)
        {
            return fl;
        }
        return null;
    }

    @Override
    public boolean cancelFlight(IFlight flights) 
    {
        RequestCancelFlight cancelR = new RequestCancelFlight(r, flights);
        IResponse res = dm.exec(cancelR);
        
        if(res.state() == EResponseState.OK)
        {
            return true;
        }
        return false;
    }
    
}
