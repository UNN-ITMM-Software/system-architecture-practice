/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import Presentation.AirplaneManagement.BAirplaneManagement;
import Presentation.AirplaneManagement.IAirplaneManagement;
import Model.AplicationObject.IAirplane;
import Model.DataAccess.IDataManagement;
import Model.DataAccess.IObserver;
import java.util.Iterator;
import Model.Logon.BAuthentication;
import Model.Logon.IRole;

public class ViewAirplaneText implements IView, IObserver{

    IRole r = BAuthentication.getRole(); 
    IAirplaneManagement am;
    
    public ViewAirplaneText()
    {
        am = BAirplaneManagement.build(r);
    }
    
    @Override
    public void refresh(IDataManagement dm) 
    {
        Iterator<IAirplane> itr = am.all();
        int i = 1;
        System.out.println("Самолеты компании:");
        while(itr.hasNext())
        {
            System.out.println(i + ". (" + itr.next().getID() + ")");
            i++;
        }
        System.out.println();
    }

    @Override
    public void init(IRole r) {
        this.r = r;
    }
    
}
