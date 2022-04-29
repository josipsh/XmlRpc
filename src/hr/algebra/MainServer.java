package hr.algebra;

import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.ServletWebServer;
import org.apache.xmlrpc.webserver.WebServer;

public class MainServer {
    public static void main(String[] args) {
        try {

            System.out.println("Server starting..");
            WebServer server = new WebServer(8080);

            PropertyHandlerMapping property = new PropertyHandlerMapping();
            property.addHandler("DHMZ", DhmzService.class);

            server.getXmlRpcServer().setHandlerMapping(property);

            XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) server.getXmlRpcServer().getConfig();
            serverConfig.setEnabledForExtensions(true);

            server.start();

            System.out.println("Server started succesfuly");
        } catch (Exception ex) {
            System.out.println("Error occurred! Error: \n");
            System.out.println(ex.getMessage());
        }
    }
}
