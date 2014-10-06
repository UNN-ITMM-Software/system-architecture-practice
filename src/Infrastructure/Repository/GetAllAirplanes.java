/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Infrastructure.Repository;

import Model.AplicationObject.EResponseState;
import Model.AplicationObject.IAirplane;
import Model.DataAccess.IResponse;
import Model.Response.ResponseSetAirport;
import Model.RepositoryInterface.IGetAllAirplanes;
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
}
