/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AirplaneManagement;

import AplicationObject.IAirplane;
import java.util.UUID;

/**
 *
 * @author Evgeniy
 */
class Airplane implements IAirplane{
    UUID id = UUID.randomUUID();
    
    @Override
    public UUID getID() {
        return id;
    }

    @Override
    public String toString() {
        return id.toString();
    }

    
}
