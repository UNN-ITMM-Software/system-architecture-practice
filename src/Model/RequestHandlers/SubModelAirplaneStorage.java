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
import Model.Request.RequestAddAirplane;
import Model.Request.RequestAllAirplanes;
import java.util.HashMap;
import java.util.Map;

class SubModelAirplaneStorage implements IHandler{
    
    Map<Class, IRrepository> canExec= new HashMap<>();
    
    public SubModelAirplaneStorage()
    {
        canExec.put(RequestAddAirplane.class, 
                BInfrastructure.buildAddAirplane());
        canExec.put(RequestAllAirplanes.class, 
                BInfrastructure.buildGetAllAirplanes());
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
