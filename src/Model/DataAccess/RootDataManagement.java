/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.DataAccess;

import Model.AplicationObject.EResponseState;
import Model.Request.RequestRefresh;
import Model.Response.ResponseSimple;
import java.util.ArrayList;
import java.util.Iterator;

class RootDataManagement implements IRootDataManagement{

    ArrayList<IHandler> handlers = new ArrayList<>();
    ArrayList<IObserver> views = new ArrayList<>();
    
    @Override
    public IResponse exec(IRequest r) {
        if(r.getClass().equals(RequestRefresh.class))
        {
            refresh();
            return new ResponseSimple(EResponseState.OK);
        }
        IResponse response = null;
        Iterator<IHandler> itrH = handlers.iterator();
        boolean isValid = true; 
        while(itrH.hasNext()){
            IHandler handler = itrH.next();
            if(handler.can(r))
            {
                response = handler.exec(r);
                isValid = isValid && response.isValid();
            }
        }
        if(!isValid)
        {
            refresh();
        }
        if(response != null){
            
            return response;
        }
        
        return new ResponseSimple(EResponseState.UNSUPPORTED);
    }

    @Override
    public void subscription(IObserver v) {
        views.add(v);
        v.refresh(this);
    }
    
    void refresh(){
        Iterator<IObserver> itr = views.iterator();
        while(itr.hasNext())
        {
            itr.next().refresh(this);
        }
    }

    @Override
    public void addHandler(IHandler h) {
        handlers.add(h);
    }
    
}
