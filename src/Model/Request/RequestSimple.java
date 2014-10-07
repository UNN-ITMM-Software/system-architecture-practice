/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Request;

import Model.AplicationObject.EResponseState;
import Model.DataAccess.IRequest;
import Model.DataAccess.IResponse;
import Model.Logon.IRole;
import Model.RepositoryInterface.IBInfrastructure;
import Model.Response.ResponseSimple;

public class RequestSimple implements IRequest{
    IRole r;
    
    public RequestSimple(IRole r)
    {
        this.r = r;
    }
    
    @Override
    public IRole getRole() {
        return r;
    }
    
    @Override
    public IResponse exec(IBInfrastructure infrastructure)
    {
        return new ResponseSimple(EResponseState.UNSUPPORTED);
    }

    @Override
    public boolean can() {
        return false;
    }
}
