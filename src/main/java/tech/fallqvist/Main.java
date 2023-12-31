package tech.fallqvist;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static JFrame window;

    public static void main(String[] args) throws SQLException, IOException {
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Adventure");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        gamePanel.getConfig().loadConfig();

        if (gamePanel.isFullScreenOn()) {
            window.setUndecorated(true);
        }

        window.pack(); // Use the JPanel component to determine window configuration

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setUpGame();
        gamePanel.startGameThread();
    }
}
