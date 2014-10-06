/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.RequestSecurity;

import Model.DataAccess.IRequest;
import Model.Logon.IRole;
import Model.Logon.RoleVerification;
import Model.Request.RequestAddAirplane;
import Model.Request.RequestAddFlight;
import Model.Request.RequestAllAirplanes;
import Model.Request.RequestAllFlights;
import Model.Request.RequestCancelFlight;
import Model.Request.RequestRefresh;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Evgeniy
 */
class CanExecute implements ICanExecute{

    ArrayList<Class > guest = new ArrayList();
    ArrayList<Class > user = new ArrayList();
    ArrayList<Class > manager = new ArrayList();
    
    public CanExecute()
    {
        guest.add(RequestAllAirplanes.class);
        guest.add(RequestAllFlights.class);
        guest.add(RequestRefresh.class);
        user.addAll(guest);
        manager.addAll(user);
        manager.add(RequestAddAirplane.class);
        manager.add(RequestAddFlight.class);
        manager.add(RequestCancelFlight.class);
    }
    
    @Override
    public boolean can(IRequest req) {
        IRole role = req.getRole();
        boolean f = false;
        
        if(RoleVerification.isManager(role))
        {
            f =  manager.contains(req.getClass());
            if(f) return true;
        }
        
        if(RoleVerification.isUser(role))
        {
            f = user.contains(req.getClass());
            if(!f)
            {
                JOptionPane.showMessageDialog( null,
                    "Нет прав доступа", 
                    "Нет прав доступа", 
                    JOptionPane.ERROR_MESSAGE);
            }
            return f;
        }
        
        f = guest.contains(req.getClass());
        if(f) return true;
        
        JOptionPane.showMessageDialog( null,
                    "Запрос в системе не определен", 
                    "Нет прав доступа", 
                    JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
}
