/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Request;

import Model.AplicationObject.IAirplane;
import Model.DataAccess.IRequest;
import Model.DataAccess.IResponse;
import Model.Logon.IRole;
import Model.RepositoryInterface.IBInfrastructure;

public class RequestAddAirplane extends RequestSimple implements IRequest{

    IAirplane airplane;
    
    public RequestAddAirplane(IRole r, IAirplane airplane)
    {
        super(r);
        this.airplane = airplane;
    }
    
    public IAirplane get()
    {
        return airplane;
    }
    
    @Override
    public IResponse exec(IBInfrastructure infrastructure) 
    {
        return infrastructure.buildAddAirplane().add(this);
    }
    
    @Override
    public boolean can()
    {
        return true;
    }
}
