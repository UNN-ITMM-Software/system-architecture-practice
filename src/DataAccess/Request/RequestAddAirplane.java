/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess.Request;

import AplicationObject.IAirplane;
import DataAccess.IRequest;
import logon.IRole;

/**
 *
 * @author Evgeniy
 */
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
    
}
