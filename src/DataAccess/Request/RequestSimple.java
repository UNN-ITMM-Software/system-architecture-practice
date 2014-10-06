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
}
