/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Infrastructure.Repository;

import Infrastructure.IInfrastructureHandler.IAddAirplane;
import Model.AplicationObject.EResponseState;
import Model.AplicationObject.IAirplane;
import Model.DataAccess.IResponse;
import Model.Response.ResponseSimple;
import Model.DataAccess.IRequest;
import Model.Request.RequestAddAirplane;
import java.util.Map;
import java.util.UUID;
import javax.swing.JOptionPane;

public class AddAirplainToStorage implements IAddAirplane{
    
    @Override
    public IResponse add(RequestAddAirplane r)
    {
        Map<UUID, IAirplane> airplanes = 
                BInfrastructure.buildGetAirplaneStorage().getAirplaneStorage();
        
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

    @Override
    public IResponse exec(IRequest r) {
        IResponse res;
        try{
            RequestAddAirplane local_r = (RequestAddAirplane)r;
            res = add(local_r);
        }catch (ClassCastException e){
            res = new ResponseSimple(EResponseState.UNSUPPORTED);
        }
        return res;
    }
}
