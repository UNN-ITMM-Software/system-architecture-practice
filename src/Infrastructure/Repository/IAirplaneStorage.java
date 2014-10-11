/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Infrastructure.Repository;

import Model.AplicationObject.IAirplane;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author Evgeniy
 */
public interface IAirplaneStorage {
    Map<UUID, IAirplane> getAirplaneStorage();
}
