/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Infrastructure;

import AplicationObject.EResponseState;
import AplicationObject.IAirplane;
import DataAccess.IResponse;
import DataAccess.Request.RequestAddAirplane;
import DataAccess.Response.ResponseSimple;
import DataAccess.subModel.IAddAirplane;
import java.util.Map;
import java.util.UUID;
import javax.swing.JOptionPane;
import logon.RoleVerification;

/**
 *
 * @author Evgeniy
 */
public class AddAirplainToStorage implements IAddAirplane{
    
    @Override
    public IResponse add(RequestAddAirplane r)
    {
        Map<UUID, IAirplane> airplanes = 
                BInfrastructure.buildGetAirplaneStorage().getAirplaneStorage();
        if(!RoleVerification.isManager(r.getRole()))
        {
            JOptionPane.showMessageDialog( null,
                    "Редактировать информацию о самолетах "
                    + "могут только менежеры", 
                    "Нет прав доступа", 
                    JOptionPane.ERROR_MESSAGE);
            return new ResponseSimple(EResponseState.FALSE, false);
        }
        
        IAirplane airplane = r.get();
        
        if(airplanes.containsKey(airplane.getID()))
        {
            JOptionPane.showMessageDialog( null,
                    "Самолет в базе данных уже существует", 
                    "Ошибка редактирования", 
                    JOptionPane.WARNING_MESSAGE);
            return new ResponseSimple(EResponseState.FALSE, false);
        }
        
        airplanes.put(airplane.getID(), airplane);
        
        return new ResponseSimple(EResponseState.OK, false);
    }
}
