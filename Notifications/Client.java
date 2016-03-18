import java.net.*;
import java.io.*;

public class Client extends Thread
{
    Socket sock;

    volatile PrintWriter writer;
    volatile BufferedReader reader;
    volatile boolean running = false;

    public Client(String host, Integer port)
    {
        super();
        try{
          Socket sock = new Socket(host, port);

          writer = new PrintWriter( sock.getOutputStream() );

          reader = new BufferedReader(
                         new InputStreamReader( sock.getInputStream() ) );
        } catch ( IOException e ){
            e.toString();
        }
    }

    public void terminate()
    {
        
    }

    @Override
    public void start()
    {
        
    }

    @Override
    public void run()
    {
        
    }

    public void send( String msg )
    {
       
    }

    public static void main(String args[])
    {
        Client c = new Client("kendy.up.ac.za", 25);
        c.start();

        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String msg;

            while(c.running)
            {
              c.send(msg);
            } 

            c.terminate();
        }
        catch(Exception e)
        {
            e.toString();
        }
    }
}
