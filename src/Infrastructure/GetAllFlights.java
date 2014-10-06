/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Infrastructure;

import AplicationObject.EResponseState;
import AplicationObject.IAirplane;
import AplicationObject.IAirport;
import AplicationObject.IFlight;
import DataAccess.BDataManagement;
import DataAccess.IDataManagement;
import DataAccess.IResponse;
import DataAccess.Request.RequestAllAirplanes;
import DataAccess.Request.RequestAllFlights;
import DataAccess.Response.ResponseSetAirport;
import DataAccess.Response.ResponseSetFlights;
import DataAccess.subModel.IGetAllFlights;
import GettingAirportAccess.BAirportAccess;
import GettingAirportAccess.IAirportAccess;
import ManagementFlightsAtCompany.BFlights;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Evgeniy
 */
public class GetAllFlights implements IGetAllFlights{

    @Override
    public IResponse get(RequestAllFlights r)
    {
        Map<UUID, IFlight> flights = new HashMap<>();
        Connection c = DatabaseConnection.getConnection();
        IAirportAccess aa= BAirportAccess.build();

        Statement stmt = null;
        try {
            stmt = c.createStatement();

            String sql = "SELECT * FROM FLIGHTS";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                UUID id = UUID.fromString(rs.getString("ID_FLIGHTS"));
                IAirport from = aa.getAccess(null,
                        UUID.fromString(rs.getString("A_FROM")));
                IAirport to = aa.getAccess(null,
                        UUID.fromString(rs.getString("A_TO")));
                UUID id_airplane = UUID.fromString(rs.getString("AIRPLANE"));
                IDataManagement dm = BDataManagement.build();
                ResponseSetAirport res =
                        (ResponseSetAirport)dm.exec(
                                new RequestAllAirplanes(r.getRole()));
                Iterator<IAirplane> itr = res.iterator();
                IAirplane airplane = null, tmp;
                while(itr.hasNext()){
                    tmp = itr.next();
                    if(tmp.getID().equals(id_airplane)){
                        airplane = tmp;
                    }
                }
                IFlight fl = BFlights.build(id, to, from, airplane,
                        new Date(rs.getLong("TIME_START")),
                        new Date(rs.getLong("TIME_FINISH")));
                flights.put(id, fl);
            }
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(AddFlightsToStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ResponseSetFlights(EResponseState.OK, flights.values());
    }
}
