/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Infrastructure.Repository;

import Infrastructure.IInfrastructureHandler.IGetAllAirplanes;
import Model.AplicationObject.EResponseState;
import Model.AplicationObject.IAirplane;
import Model.DataAccess.IRequest;
import Model.DataAccess.IResponse;
import Model.Request.RequestAddAirplane;
import Model.Request.RequestAllAirplanes;
import Model.Response.ResponseSetAirport;
import Model.Response.ResponseSimple;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public class GetAllAirplanes implements IGetAllAirplanes{
    @Override
    public IResponse get()
    {
        Map<UUID, IAirplane> airplanes = 
                BInfrastructure.buildGetAirplaneStorage().getAirplaneStorage();
        Collection<IAirplane> collection = airplanes.values();
        return new ResponseSetAirport(EResponseState.OK, collection);
    }
    
    @Override
    public IResponse exec(IRequest r) {
        IResponse res;
        try{
            RequestAllAirplanes local_r = (RequestAllAirplanes)r;
            res = get();
        }catch (ClassCastException e){
            res = new ResponseSimple(EResponseState.UNSUPPORTED);
        }
        return res;
    }
}
