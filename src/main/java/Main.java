// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import javax.swing.*;
import java.awt.*;

class GUIVar {
    public static int padding = 0;
    public static int width = 300;
    public static int height = 500;
    public static int optPanelWidth = 280;
    public static int optPanelLeft = 5;
    public static Font themeFontLarge = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
    public static Font themeFont = new Font(Font.SANS_SERIF, Font.PLAIN, 16);
    public static Font themeFontSmall = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
}

public class Main {
    static JFrame frame = null;
    static WebDriver driver = null;

    public static void main(String[] args) {
        // Build window and set up window parameters
        frame = new JFrame("NitroType Cheat v3");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(GUIVar.width, GUIVar.height);

        // --- Start Building Main Cheat Panel ---
        JPanel NTH = new JPanel(null);

        // Add section title
        JLabel NTHTitle = new JLabel("NitroType Cheat | Control");
        NTHTitle.setFont(GUIVar.themeFontLarge);
        NTHTitle.setBounds(GUIVar.optPanelLeft, GUIVar.padding, GUIVar.optPanelWidth, 35);
        NTH.add(NTHTitle);

        // Add start cheat button
        JButton startCheatBtn = new JButton("Start Cheat");
        startCheatBtn.setFont(GUIVar.themeFont);
        startCheatBtn.setBounds(GUIVar.optPanelLeft, GUIVar.padding, GUIVar.optPanelWidth, 30);
        NTH.add(startCheatBtn);

        // Add speed slider label
        JLabel speedLabel = new JLabel("Words/Minute:");
        speedLabel.setFont(GUIVar.themeFont);
        speedLabel.setBounds(GUIVar.optPanelLeft, GUIVar.padding + 40, GUIVar.optPanelWidth, 30);
        NTH.add(speedLabel);

        // Add speed slider
        JSlider speedSlider = new JSlider();
        speedSlider.setBounds(GUIVar.optPanelLeft, GUIVar.padding + 70, GUIVar.optPanelWidth, 20);
        NTH.add(speedSlider);
        // --- End Building Main Cheat Panel ---

        // --- Start Building Setup Panel ---
        JPanel SUP = new JPanel(null);

        // Add section title
        JLabel SUPTitle = new JLabel("NitroType Cheat | Setup");
        SUPTitle.setFont(GUIVar.themeFontLarge);
        SUPTitle.setBounds(GUIVar.optPanelLeft, GUIVar.padding, GUIVar.optPanelWidth, 35);
        SUP.add(SUPTitle);

        // Add drop down menu label
        JLabel browserLabel = new JLabel("Select Your Browser:");
        browserLabel.setFont(GUIVar.themeFont);
        browserLabel.setBounds(GUIVar.optPanelLeft, GUIVar.padding + 45, GUIVar.optPanelWidth, 30);
        SUP.add(browserLabel);

        // Add drop down menu to select browser
        String[] browsers = {"Chrome", "Edge"};
        JComboBox<String> browserSelect = new JComboBox<>(browsers);
        browserSelect.setFont(GUIVar.themeFont);
        browserSelect.setBounds(GUIVar.optPanelLeft, GUIVar.padding + 85, GUIVar.optPanelWidth, 30);
        SUP.add(browserSelect);

        // Add continue setup button
        JButton startSetup = new JButton("Continue");
        startSetup.setFont(GUIVar.themeFont);
        startSetup.setBounds(GUIVar.optPanelLeft, GUIVar.padding + 135, GUIVar.optPanelWidth, 30);
        SUP.add(startSetup);
        // --- End Building Setup Panel ---

        // --- Start Button Logic ---
        startSetup.addActionListener(e -> {
            Object browser = browserSelect.getSelectedItem();

            frame.remove(SUP);
            frame.add(NTH);
            frame.revalidate();

            Main.driver = setUpWebdriver(browser);
        });
        // --- End Button Logic ---

        frame.add(SUP);
        frame.setVisible(true);
    }

    public static WebDriver setUpWebdriver(Object browser) {
        WebDriver driver = null;
        if (browser == "Chrome") {
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new ChromeDriver(chromeOptions);
        } else if (browser == "Edge") {
            EdgeOptions edgeOptions = new EdgeOptions();
            driver = new EdgeDriver(edgeOptions);
        }
        return driver;
    }
}
