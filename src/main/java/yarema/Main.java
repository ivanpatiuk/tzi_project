package yarema;

import yarema.internetDistributors.Provider;
import yarema.service.NetworkService;

import java.awt.*;

import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {
//        NetworkService networkService = new NetworkService();
//        Provider provider = networkService.initNetwork();
//        NetworkService.testPrintNetwork(provider);
        System.out.println(hello(2, 0));
    }

    public static int hello(int a, int b) {
        Color color1 = new Color(a);
        Color color2 = new Color(b);
        return (color1.getRed() - color2.getRed()) * (color1.getRed() - color2.getRed()) +
                (color1.getGreen() - color2.getGreen()) * (color1.getGreen() - color2.getGreen()) +
                (color1.getBlue() - color2.getBlue()) * (color1.getBlue() - color2.getBlue());
    }
}
