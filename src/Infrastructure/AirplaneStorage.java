/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Infrastructure;

import DataAccess.subModel.IAirplaneStorage;
import AplicationObject.IAirplane;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author Evgeniy
 */
class AirplaneStorage implements IAirplaneStorage{
     Map<UUID, IAirplane> airplanes = new HashMap<>();

     @Override
     public Map<UUID, IAirplane> getAirplaneStorage(){
         return airplanes;
     }
}
