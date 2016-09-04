import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;

public class SQLManager extends Thread
{
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private boolean isExit = false;
    /**
     * data for connection
     */
    private final String url = "jdbc:mysql://localhost:3306/lessons?useSSL=false";
    private final String user = "root";
    private final String password = "root";

    /**
     * variables for opening and managing connection
     */
    private Connection connection;
    private Statement statement;
    //private ResultSet resultSet;

    public SQLManager()
    {
        try
        {
            //// opening database connection to MySQL server
            connection = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            statement = connection.createStatement();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        try {
            while (!isExit) {
                try
                {
                    readingStrings();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                close();
            }
        }catch (Exception ignored){}
    }

    private void readingStrings() throws IOException, SQLException  /** oshibka zdes **/
    {
        StringBuilder text = new StringBuilder();
        while(true)
        {
            String temp = reader.readLine();
            if (temp.matches(".*[;]$"))
            {
                text.append(temp);
                break;
            }
            else
            {
                text.append(temp).append(" ");
            }
        }

        if (text.toString().matches(".*close$"))
        {
            isExit = true;
        }
        else if (text.toString().matches("(^((SELECT)|(SHOW)|(DESC)|(select)|(show)|(desc))).*"))
        {
            executeQuery(text.toString());
        }
        else
        {
            execute(text.toString());
        }
    }

    private void execute(String command) throws SQLException
    {
        statement.execute(command);
    }

    private void executeQuery(String command) throws SQLException
    {
        ResultSet rs = statement.executeQuery(command);

        ResultSetMetaData data = rs.getMetaData();
        int columnsCount = data.getColumnCount();

        for (int i = 1; i <= columnsCount; i++)
        {
            System.out.print(data.getColumnName(i) + " | ");
        }
        System.out.println("\n" + "-------------------------------------------");

        while(rs.next())
        {
            for (int columnNumber = 1; columnNumber <= columnsCount; columnNumber++)
            {
                System.out.print(rs.getString(columnNumber) + " | ");
            }
            System.out.println();
        }
    }

    private void close() throws IOException, SQLException
    {
        reader.close();
        connection.close();
    }
}
