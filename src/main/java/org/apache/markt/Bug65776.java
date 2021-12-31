package org.apache.markt;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Bug65776 {

    // From "sysctl net.inet.tcp.msl" on macOS.
    private static final long MSL = 15_000;
    private static final long TIME_WAIT = MSL * 2;
    
	public static void main(String[] args) throws Exception {
        InetAddress remoteAddress = InetAddress.getByName("localhost");
        int remotePort = 8080;

        Socket socket = new Socket(remoteAddress, remotePort, null, 0);

        int localPort = socket.getLocalPort();
        System.out.println("Local port: " + localPort);

        socket.close();

        System.out.println(String.format("Sleep for 2 * MSL (%d ms)...", Long.valueOf(localPort)));
        TimeUnit.MILLISECONDS.sleep(TIME_WAIT);

        boolean succeeded = false;
        while (!succeeded) {
            try {
                connect(remoteAddress, remotePort, localPort);
                succeeded = true;
            }
            catch (Exception ex) {
                System.out.println("Sleep for a second...");
                TimeUnit.SECONDS.sleep(1);
            }
        }
	}
	
    private static void connect(InetAddress remoteAddress, int remotePort, int localPort) throws IOException {
		Socket s = new Socket(remoteAddress, remotePort, null, localPort);
        s.close();
    }
}
