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
public class RoleGuest  implements IRole{

    @Override
    public UUID getStatusID() {
        return RoleStatus.guest;
    }

    @Override
    public String getLogin() {
        return "nan";
    }

    @Override
    public String getName() {
        return "nan";
    }

}
