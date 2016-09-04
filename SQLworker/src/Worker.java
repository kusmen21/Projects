
public class Worker
{
    public static void main(String[] args)
    {
        try
        {
            SQLManager sqlManager = new SQLManager();
            sqlManager.start();
            sqlManager.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
