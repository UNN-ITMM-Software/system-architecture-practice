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
import Model.Request.RequestAddAirplane;
import Model.Request.RequestAllAirplanes;

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
