/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.RequestHandlers;

import Model.AplicationObject.EResponseState;
import Model.Response.ResponseSimple;
import Infrastructure.Repository.BInfrastructure;
import Model.DataAccess.IHandler;
import Model.DataAccess.IRequest;
import Model.DataAccess.IResponse;
import Model.RepositoryInterface.IBInfrastructure;
import Model.Request.RequestAddFlight;
import Model.Request.RequestAllFlights;
import Model.Request.RequestCancelFlight;

class SubModelFlightsStorage  implements IHandler{
    IBInfrastructure infrastructure;
    
    public SubModelFlightsStorage(IBInfrastructure infrastructure)
    {
        this.infrastructure = infrastructure;
    }    
    
    @Override
    public IResponse exec(IRequest r) {
        /*
        if(r.getClass().equals(RequestAddFlight.class))
        {
            RequestAddFlight add = (RequestAddFlight)r;
            return add.exec(infrastructure);
        }   
        if(r.getClass().equals(RequestAllFlights.class))
        {
            RequestAllFlights get = (RequestAllFlights)r;
            return get.exec(infrastructure);
        }
        if(r.getClass().equals(RequestCancelFlight.class))
        {
            RequestCancelFlight cancel = (RequestCancelFlight)r;
            return cancel.exec(infrastructure);
        }
        return new ResponseSimple(EResponseState.UNSUPPORTED); */
        return r.exec(infrastructure);
    }

    @Override
    public boolean can(IRequest r) {
        if(r.getClass().equals(RequestAddFlight.class)) return true;
        if(r.getClass().equals(RequestAllFlights.class)) return true;
        if(r.getClass().equals(RequestCancelFlight.class)) return true;
        return false;
        //return r.can();
    }
}
