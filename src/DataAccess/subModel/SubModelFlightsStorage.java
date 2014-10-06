/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess.subModel;

import AplicationObject.EResponseState;
import DataAccess.IHandler;
import DataAccess.IRequest;
import DataAccess.IResponse;
import DataAccess.Request.RequestAddFlight;
import DataAccess.Request.RequestAllFlights;
import DataAccess.Request.RequestCancelFlight;
import DataAccess.Response.ResponseSimple;
import Infrastructure.BInfrastructure;

/**
 *
 * @author Evgeniy
 */
class SubModelFlightsStorage  implements IHandler{

    @Override
    public IResponse exec(IRequest r) {
        if(r.getClass().equals(RequestAddFlight.class))
        {
            RequestAddFlight add = (RequestAddFlight)r;
         return BInfrastructure.buildAddFlights().add(add);
        }
        if(r.getClass().equals(RequestAllFlights.class))
        {
            RequestAllFlights get = (RequestAllFlights)r;
            return BInfrastructure.buildGetAllFlights().get(get);
        }
        if(r.getClass().equals(RequestCancelFlight.class))
        {
            RequestCancelFlight cancel = (RequestCancelFlight)r;
            return BInfrastructure.buildCancelFlights().cancel(cancel);
        }
        return new ResponseSimple(EResponseState.UNSUPPORTED);
    }

    @Override
    public boolean can(IRequest r) {
        if(r.getClass().equals(RequestAddFlight.class)) return true;
        if(r.getClass().equals(RequestAllFlights.class)) return true;
        if(r.getClass().equals(RequestCancelFlight.class)) return true;
        return false;
    }
}
