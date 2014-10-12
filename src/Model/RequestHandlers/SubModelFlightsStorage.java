/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.RequestHandlers;

import Model.AplicationObject.EResponseState;
import Model.Response.ResponseSimple;
import Infrastructure.Repository.BInfrastructure;
import Model.DataAccess.IRrepository;
import Model.DataAccess.IHandler;
import Model.DataAccess.IRequest;
import Model.DataAccess.IResponse;
import Model.Request.RequestAddFlight;
import Model.Request.RequestAllFlights;
import Model.Request.RequestCancelFlight;
import java.util.HashMap;
import java.util.Map;

class SubModelFlightsStorage  implements IHandler{

    Map<Class, IRrepository> canExec= new HashMap<>();
    
    public SubModelFlightsStorage()
    {
        canExec.put(RequestAddFlight.class, 
                BInfrastructure.buildAddFlights());
        canExec.put(RequestAllFlights.class, 
                BInfrastructure.buildGetAllFlights());
        canExec.put(RequestCancelFlight.class, 
                BInfrastructure.buildCancelFlights());
    }
    
    @Override
    public IResponse exec(IRequest r) {
        IRrepository h = canExec.get(r.getClass());
        if(h == null)
            return new ResponseSimple(EResponseState.UNSUPPORTED);
        
        return h.exec(r);
    }

    @Override
    public boolean can(IRequest r) {
        return canExec.containsKey(r.getClass());
    }
}
