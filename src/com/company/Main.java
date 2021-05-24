package com.company;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public void connectStatus() {
        System.out.println("Подключение к интернету: " + netIsAvailable());
        System.out.println("Наличие фаервола:" + checkFirewall());
    }

    private boolean netIsAvailable() {
        try {
            final URL url = new URL("http://www.google.com");
            final URLConnection conn = url.openConnection();
            conn.connect();
            conn.getInputStream().close();
            return true;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            return false;
        }
    }

    private boolean checkFirewall() {
        return new File("C:\\Program Files\\Windows Defender").exists();
    }


}
