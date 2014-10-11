/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Infrastructure.Repository;

import Infrastructure.IInfrastructureHandler.ICancelFlights;
import Model.AplicationObject.EResponseState;
import Model.AplicationObject.IFlight;
import Model.DataAccess.IRequest;
import Model.DataAccess.IResponse;
import Model.Request.RequestAddFlight;
import Model.Response.ResponseSimple;
import Model.Request.RequestCancelFlight;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CancelFlightsFromStorage implements ICancelFlights{
    @Override
    public IResponse cancel(RequestCancelFlight r)
    {
        IFlight flights = r.get();
        
        Connection c = DatabaseConnection.getConnection();
        
        Statement stmt = null;
        try {
            stmt = c.createStatement();
        
            String sql = "DELETE FROM FLIGHTS WHERE ID_FLIGHTS ="
                    + "'"+flights.flightsID().toString()+"'"; 
            stmt.executeUpdate(sql);
            stmt.close();
            return new ResponseSimple(EResponseState.OK, false);
        } catch (SQLException ex) {
            Logger.getLogger(AddFlightsToStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ResponseSimple(EResponseState.FALSE, false);
    }
    
    @Override
    public IResponse exec(IRequest r) {
        IResponse res;
        try{
            RequestCancelFlight local_r = (RequestCancelFlight)r;
            res = cancel(local_r);
        }catch (ClassCastException e){
            res = new ResponseSimple(EResponseState.UNSUPPORTED);
        }
        return res;
    }
}
