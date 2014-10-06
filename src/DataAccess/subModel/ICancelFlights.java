/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess.subModel;

import DataAccess.IResponse;
import DataAccess.Request.RequestCancelFlight;

/**
 *
 * @author Evgeniy
 */
public interface ICancelFlights {
    IResponse cancel(RequestCancelFlight r);
}
