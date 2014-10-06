/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Response;

import Model.AplicationObject.EResponseState;
import Model.DataAccess.IResponse;

public class ResponseSimple implements IResponse{

    EResponseState st;
    boolean isValid = true;
    
    public ResponseSimple(EResponseState st)
    {
        this.st = st;
    }
    
    public ResponseSimple(EResponseState st, boolean isValid)
    {
        this.st = st;
        this.isValid = isValid;
    }
    
    @Override
    public EResponseState state() {
        return st;
    }

    @Override
    public boolean isValid() {
        return isValid;
    }
    
    
}
