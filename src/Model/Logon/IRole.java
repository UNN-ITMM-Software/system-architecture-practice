/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Logon;

import java.util.UUID;

public interface IRole {
    UUID getStatusID();
    String getLogin();
    String getName();
}
