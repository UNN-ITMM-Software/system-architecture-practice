/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AirplaneManagement;

import AplicationObject.IAirplane;
import java.util.Iterator;
import java.util.UUID;

/**
 *
 * @author Evgeniy
 */
public interface IAirplaneManagement {
    IAirplane buy();
    int count();
    IAirplane find(UUID id);
    Iterator<IAirplane> all();
}
