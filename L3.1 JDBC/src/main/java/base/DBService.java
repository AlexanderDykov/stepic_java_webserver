package base;

import dbService.DBException;

/**
 * Created by DUX on 01.05.2016.
 */
public interface DBService {
    void create() throws DBException;
    UserProfile getUser(String login) throws DBException;
    long addUser(UserProfile userProfile) throws DBException;
    void cleanUp() throws DBException;
    void printConnectInfo();
}
