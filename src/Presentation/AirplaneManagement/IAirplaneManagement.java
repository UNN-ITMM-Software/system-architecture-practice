/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation.AirplaneManagement;

import Model.AplicationObject.IAirplane;
import java.util.Iterator;
import java.util.UUID;

public interface IAirplaneManagement {
    IAirplane buy();
    int count();
    IAirplane find(UUID id);
    Iterator<IAirplane> all();
}
