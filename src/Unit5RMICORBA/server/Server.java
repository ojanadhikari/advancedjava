package Unit5RMICORBA.server;

import Unit5RMICORBA.obj.Hello;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String args[]) {
        try {
            HelloImpl obj = new HelloImpl();

            Registry registry = LocateRegistry.createRegistry(8080);
            registry.bind("Hello", obj);
            System.out.println("Server ready");
        } catch (Exception e) {
            System.out.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
