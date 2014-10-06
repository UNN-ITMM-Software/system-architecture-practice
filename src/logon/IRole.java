/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logon;

import java.util.UUID;

/**
 *
 * @author Evgeniy
 */
public interface IRole {
    UUID getStatusID();
    String getLogin();
    String getName();
}
