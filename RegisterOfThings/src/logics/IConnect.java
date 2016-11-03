package logics;

import java.sql.Connection;

/**
 * Created by Andrey_pers on 03.11.2016.
 */
public interface IConnect {
    public Connection ConnectBD();
    public boolean IsConnection();
    public void connectClose();
}
