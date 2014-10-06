/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess.Request;

import DataAccess.IRequest;
import logon.IRole;

/**
 *
 * @author Evgeniy
 */
public class RequestAllAirplanes extends RequestSimple implements IRequest{

    public RequestAllAirplanes(IRole r) {
        super(r);
    }

}
