/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Filters;

/**
 *
 * @author Evgeniy
 */
public class BFilters {
    static IFilters filter = new Filters();
    public static IFilters build(){
        return filter;
    }
}
