package accountServer;

/**
 * @author a.akbashev
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class AccountServer implements AccountServerI {
    private int usersLimit;

    public AccountServer(int usersLimit) {
        this.usersLimit = usersLimit;
    }
    public AccountServer() {
        this.usersLimit = 10;
    }

    @Override
    public int getUsersLimit() {
        return usersLimit;
    }

    @Override
    public void setUsersLimit(int usersLimit) {
        this.usersLimit = usersLimit;
    }

}
