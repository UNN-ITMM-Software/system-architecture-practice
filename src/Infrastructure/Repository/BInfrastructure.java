/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Infrastructure.Repository;

import Model.RepositoryInterface.IAirplaneStorage;
import Model.RepositoryInterface.IAddAirplane;
import Model.RepositoryInterface.IAddFlights;
import Model.RepositoryInterface.IBInfrastructure;
import Model.RepositoryInterface.ICancelFlights;
import Model.RepositoryInterface.IGetAllAirplanes;
import Model.RepositoryInterface.IGetAllFlights;

public class BInfrastructure implements IBInfrastructure {
    IAddAirplane oAddAirplane = null;
    IAddFlights oAddFlights = null;
    ICancelFlights oCancelFlights = null;
    IGetAllAirplanes oGetAllAirplanes = null;
    IGetAllFlights oGetAllFlights = null;
    IAirplaneStorage oAirplaneStorage = null;
            
    @Override
    public IAddAirplane buildAddAirplane(){
        if(oAddAirplane == null)
        {
            oAddAirplane = new AddAirplainToStorage(this);
        } 
        return oAddAirplane;
    }
    
    @Override
    public IAddFlights buildAddFlights(){
        if(oAddFlights == null)
        {
            oAddFlights = new AddFlightsToStorage();
        } 
        return oAddFlights;
    }
    
    @Override
    public ICancelFlights buildCancelFlights(){
        if(oCancelFlights == null)
        {
            oCancelFlights = new CancelFlightsFromStorage();
        } 
        return oCancelFlights;
    }
    
    @Override
    public IGetAllAirplanes buildGetAllAirplanes(){
        if(oGetAllAirplanes == null)
        {
            oGetAllAirplanes = new GetAllAirplanes(this);
        } 
        return oGetAllAirplanes;
    }
    
    @Override
    public IGetAllFlights buildGetAllFlights(){
        if(oGetAllFlights == null)
        {
            oGetAllFlights = new GetAllFlights();
        } 
        return oGetAllFlights;
    }
    
    @Override
    public IAirplaneStorage buildGetAirplaneStorage(){
        if(oAirplaneStorage == null)
        {
            oAirplaneStorage = new AirplaneStorage();
        } 
        return oAirplaneStorage;
    }
}
