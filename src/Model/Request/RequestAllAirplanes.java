/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Request;

import Model.DataAccess.IRequest;
import Model.DataAccess.RequestAirplanesOperation;
import Model.DataAccess.IResponse;
import Model.Logon.IRole;
import Model.RepositoryInterface.IBInfrastructure;

public class RequestAllAirplanes extends RequestSimple implements IRequest {

    public RequestAllAirplanes(IRole r) {
        super(r);
    }

    @Override
    public IResponse exec(IBInfrastructure infrastructure)
    {
        return infrastructure.buildGetAllAirplanes().get();
    }
    
    @Override
    public boolean can()
    {
        return true;
    }
}
