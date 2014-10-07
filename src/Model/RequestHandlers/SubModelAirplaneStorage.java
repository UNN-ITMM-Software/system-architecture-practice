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
import Model.Request.RequestAddAirplane;
import Model.Request.RequestAllAirplanes;
import Model.Request.RequestSimple;

class SubModelAirplaneStorage implements IHandler{
    IBInfrastructure infrastructure;
    
    public SubModelAirplaneStorage(IBInfrastructure infrastructure)
    {
        this.infrastructure = infrastructure;
    }
    
    @Override
    public IResponse exec(IRequest r) {
        /*if(r.getClass().equals(RequestAddAirplane.class))
        {
            RequestAddAirplane add = (RequestAddAirplane)r;
            return add.exec(infrastructure);
        }
        if(r.getClass().equals(RequestAllAirplanes.class))
        {
            return ((RequestAllAirplanes) r).exec(infrastructure);
        }
        return new ResponseSimple(EResponseState.UNSUPPORTED);*/
        return r.exec(infrastructure);
    }

    @Override
    public boolean can(IRequest r) {
        if(r.getClass().equals(RequestAddAirplane.class)) return true;
        if(r.getClass().equals(RequestAllAirplanes.class)) return true;
        return false;
    }

    
}
