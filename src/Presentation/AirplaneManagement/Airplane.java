/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation.AirplaneManagement;

import Model.AplicationObject.IAirplane;
import java.util.UUID;

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
