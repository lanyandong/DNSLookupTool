
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class DNSLookupIO {

    public static void main(String[] args) {

        System.out.println("Please enter the host:");
        Scanner sc = new Scanner(System.in);

        String hostname = sc.nextLine();

        try {
            InetAddress host = InetAddress.getByName(hostname);
            displayHost(host);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private static void displayHost(InetAddress host) {
        System.out.println("The host: " + host.getHostName() + " has address: " + host.getHostAddress());
    }
}
