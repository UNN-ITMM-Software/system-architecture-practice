/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.RepositoryInterface;

public interface IBInfrastructure {
    IAddAirplane buildAddAirplane();
    IAddFlights buildAddFlights();
    ICancelFlights buildCancelFlights();
    IGetAllAirplanes buildGetAllAirplanes();
    IGetAllFlights buildGetAllFlights();
    IAirplaneStorage buildGetAirplaneStorage();
}
