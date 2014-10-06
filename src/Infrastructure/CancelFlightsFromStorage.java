/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Infrastructure;

import AplicationObject.EResponseState;
import AplicationObject.IFlight;
import DataAccess.IResponse;
import DataAccess.Request.RequestCancelFlight;
import DataAccess.Response.ResponseSimple;
import DataAccess.subModel.ICancelFlights;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logon.RoleVerification;

/**
 *
 * @author Evgeniy
 */
public class CancelFlightsFromStorage implements ICancelFlights{
    @Override
    public IResponse cancel(RequestCancelFlight r)
    {
        if(!RoleVerification.isManager(r.getRole()))
        {
            JOptionPane.showMessageDialog( null,
                    "Редактировать информацию о полетах "
                    + "могут только менежеры",
                    "Нет прав доступа",
                    JOptionPane.ERROR_MESSAGE);
            return new ResponseSimple(EResponseState.FALSE, false);
        }

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
}
