/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Infrastructure.Repository;

import Model.AplicationObject.EResponseState;
import Model.AplicationObject.IFlight;
import Model.DataAccess.IResponse;
import Model.Response.ResponseSimple;
import Model.RepositoryInterface.IAddFlights;
import Model.Request.RequestAddFlight;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddFlightsToStorage implements IAddFlights{
    
    @Override
    public IResponse add(RequestAddFlight r)
    {
        IFlight flights = r.get();
        
        Connection c = DatabaseConnection.getConnection();
        
        Statement stmt = null;
        try {
            stmt = c.createStatement();
        
            String sql = "INSERT INTO FLIGHTS (ID_FLIGHTS, AIRPLANE, "
                    + " A_FROM, A_TO, TIME_START, TIME_FINISH)"
                    + " VALUES ("
                    + "'"+flights.flightsID().toString()+"',"
                    + "'"+flights.airplane().getID().toString()+"',"
                    + "'"+flights.startAirport().getID().toString()+"',"
                    + "'"+flights.finishAirport().getID().toString()+"',"
                    + "'"+flights.departureTime().getTime()+"',"
                    + "'"+flights.arrivalTime().getTime()+"'"
                    + ")"; 
            stmt.executeUpdate(sql);
            stmt.close();
            return new ResponseSimple(EResponseState.OK, false);
        } catch (SQLException ex) {
            Logger.getLogger(AddFlightsToStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ResponseSimple(EResponseState.FALSE, false);
    }
}
