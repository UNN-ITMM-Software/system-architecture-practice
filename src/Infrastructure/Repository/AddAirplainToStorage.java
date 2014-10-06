/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Infrastructure.Repository;

import Model.AplicationObject.EResponseState;
import Model.AplicationObject.IAirplane;
import Model.DataAccess.IResponse;
import Model.Response.ResponseSimple;
import Model.RepositoryInterface.IAddAirplane;
import Model.Request.RequestAddAirplane;
import java.util.Map;
import java.util.UUID;
import javax.swing.JOptionPane;
import Model.Logon.RoleVerification;

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
