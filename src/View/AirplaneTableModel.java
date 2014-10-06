/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import Presentation.AirplaneManagement.BAirplaneManagement;
import Presentation.AirplaneManagement.IAirplaneManagement;
import Model.AplicationObject.IAirplane;
import Model.DataAccess.BDataManagement;
import Model.DataAccess.IDataManagement;
import java.util.Iterator;
import javax.swing.table.AbstractTableModel;
import Model.Logon.BAuthentication;
import Model.Logon.IRole;

public class AirplaneTableModel extends AbstractTableModel{

    IRole manegerRole = BAuthentication.getRole("manager", "123");
    IDataManagement dt = BDataManagement.build();
    
    
    @Override
    public int getRowCount() {
        IAirplaneManagement am = BAirplaneManagement.build(manegerRole);
        return am.count();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0){
            return new Integer(rowIndex+1);
        }
        IAirplaneManagement am = BAirplaneManagement.build(manegerRole);
        Iterator<IAirplane> itr = am.all();
        for(int i = 0; i < rowIndex; i++)
        {
            itr.next();
        }
        return itr.next();
    }
    
}
