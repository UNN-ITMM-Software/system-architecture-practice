/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AirplaneManagement;

import AplicationObject.EResponseState;
import AplicationObject.IAirplane;
import DataAccess.BDataManagement;
import DataAccess.IDataManagement;
import DataAccess.IResponse;
import DataAccess.Request.RequestAddAirplane;
import DataAccess.Request.RequestAllAirplanes;
import DataAccess.Response.ResponseSetAirport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import logon.BAuthentication;
import logon.IRole;

/**
 *
 * @author Evgeniy
 */
class AirplaneManagement implements IAirplaneManagement{

    IRole r=null;
    IDataManagement dm;

    AirplaneManagement(IRole r)
    {
        dm = BDataManagement.build();
        this.r = r;
    }

    protected IRole getRole(){
        if(r == null)
        {
            r = BAuthentication.getRole("manager", "123");
        }
        return r;
    }

    @Override
    public IAirplane buy() {
        IRole role = getRole();
        IAirplane airplane = BAirplane.build();

        RequestAddAirplane rAddAirplane;
        rAddAirplane= new RequestAddAirplane(role, airplane);
        IResponse res = dm.exec(rAddAirplane);

        if(res.state() == EResponseState.OK)
        {
            return airplane;
        }
        return null;
    }

    @Override
    public IAirplane find(UUID id) {
        IRole role = getRole();
        RequestAllAirplanes rq = new RequestAllAirplanes(role);
        IResponse rr = dm.exec(rq);
        if(rr.state() == EResponseState.OK)
        {
            ResponseSetAirport res = (ResponseSetAirport)rr;
            Iterator<IAirplane> itr = res.iterator();
            while(itr.hasNext())
            {
                IAirplane airplane = itr.next();
                if(airplane.getID().equals(id))
                {
                    return airplane;
                }
            }

        }
        return null;
    }

    @Override
    public Iterator<IAirplane> all() {
        IRole role = getRole();
        RequestAllAirplanes rq = new RequestAllAirplanes(role);
        IResponse rr = dm.exec(rq);
        if(rr.state() == EResponseState.OK)
        {
            ResponseSetAirport res = (ResponseSetAirport)rr;
            Iterator<IAirplane> itr = res.iterator();
            return itr;
        }
        return new ArrayList<IAirplane>().iterator();
    }

    @Override
    public int count() {
        IRole role = getRole();
        RequestAllAirplanes rq = new RequestAllAirplanes(role);
        IResponse rr = dm.exec(rq);
        ResponseSetAirport res = (ResponseSetAirport)rr;
        Iterator<IAirplane> itr = res.iterator();
        int i = 0;
        while(itr.hasNext()){
            itr.next();
            i++;
        }
        return i;
    }

}
