/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Infrastructure.GettingAirportAccess;

import Model.AplicationObject.IAirport;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class ModelAllAirports {
    public static  Map<UUID, IAirport> allAirport = new HashMap<>();
}
