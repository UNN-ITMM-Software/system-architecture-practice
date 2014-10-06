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
import DataAccess.Request.RequestAddAirplane;
import DataAccess.Request.RequestAllAirplanes;
import DataAccess.Response.ResponseSimple;
import Infrastructure.BInfrastructure;

/**
 *
 * @author Evgeniy
 */
class SubModelAirplaneStorage implements IHandler{
    
    @Override
    public IResponse exec(IRequest r) {
        if(r.getClass().equals(RequestAddAirplane.class))
        {
            RequestAddAirplane add = (RequestAddAirplane)r;
            return BInfrastructure.buildAddAirplane().add(add);
        }
        if(r.getClass().equals(RequestAllAirplanes.class))
        {
            return BInfrastructure.buildGetAllAirplanes().get();
        }
        return new ResponseSimple(EResponseState.UNSUPPORTED);
    }

    @Override
    public boolean can(IRequest r) {
        if(r.getClass().equals(RequestAddAirplane.class)) return true;
        if(r.getClass().equals(RequestAllAirplanes.class)) return true;
        return false;
    }

    
}
