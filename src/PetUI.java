import javax.swing.*;
import java.awt.*;

public class PetUI {

    // palette
    static final Color NAVY = new Color(0x12324F);
    static final Color DARK_NAVY = new Color(0x0C2238);
    static final Color TRACK = new Color(0x1D4568);
    static final Color CREAM = new Color(0xF8DDB0);
    static final Color RED = new Color(0xDC4339);
    static final Color YELLOW = new Color(0xFAB432);
    static final Color TEAL = new Color(0x4DB5A6);
    static final String FONT = "Monospaced";
    static final double OUTLINE_SHADE = 0.7;

    // colors used for outlines
    static Color darker(Color c) {
        return new Color(
            (int) (c.getRed() * OUTLINE_SHADE),
            (int) (c.getGreen() * OUTLINE_SHADE),
            (int) (c.getBlue() * OUTLINE_SHADE));
    }

    // pet info method
    static JLabel makeInfo(String label, String value) {
        JLabel l = new JLabel("<html><b>" + label + ":</b> " + value + "</html>");
        l.setFont(new Font(FONT, Font.PLAIN, 18));
        l.setForeground(Color.WHITE);
        return l;
    }

    // create stat row method
    static void addStatRow(JPanel panel, int row, String name, int value, Color color) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = row;
        c.insets = new Insets(6, 10, 6, 10);

        JLabel label = new JLabel(name);
        label.setFont(new Font(FONT, Font.BOLD, 16));
        label.setForeground(Color.WHITE);
        c.gridx = 0;
        c.anchor = GridBagConstraints.EAST;
        panel.add(label, c);

        JProgressBar bar = new JProgressBar(0, 100);
        bar.setValue(value);
        bar.setForeground(color);
        bar.setBackground(TRACK);
        bar.setBorder(BorderFactory.createLineBorder(darker(color), 2));
        bar.setPreferredSize(new Dimension(250, 24));
        c.gridx = 1;
        c.anchor = GridBagConstraints.CENTER;
        panel.add(bar, c);

        JLabel percent = new JLabel(value + "%");
        percent.setFont(new Font(FONT, Font.PLAIN, 16));
        percent.setForeground(Color.WHITE);
        c.gridx = 2;
        c.anchor = GridBagConstraints.WEST;
        panel.add(percent, c);
    }

    // create button method
    static JButton makeButton(String text, Color bg) {
        JButton b = new JButton(text);
        b.setFont(new Font(FONT, Font.BOLD, 16));
        b.setBackground(bg);
        b.setForeground(Color.BLACK);
        b.setOpaque(true);
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createLineBorder(darker(bg), 2));
        b.setPreferredSize(new Dimension(110, 50));
        return b;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Pixel Pets");
            frame.setSize(650, 560);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.getContentPane().setBackground(NAVY);
            frame.setLayout(new BorderLayout());

            // Title
            JLabel title = new JLabel("Pixel Pets", SwingConstants.CENTER);
            title.setFont(new Font(FONT, Font.BOLD, 34));
            title.setForeground(YELLOW);
            title.setBorder(BorderFactory.createEmptyBorder(15, 0, 5, 0));
            frame.add(title, BorderLayout.NORTH);

            // Middle area
            JPanel centerPanel = new JPanel(new BorderLayout());
            centerPanel.setOpaque(false);

            // Pet box & info
            JPanel topRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 20));
            topRow.setOpaque(false);

            JLabel petBox = new JLabel("<Pet>", SwingConstants.CENTER);
            petBox.setFont(new Font(FONT, Font.PLAIN, 24));
            petBox.setForeground(CREAM);
            petBox.setPreferredSize(new Dimension(250, 150));
            petBox.setOpaque(true);
            petBox.setBackground(DARK_NAVY);
            petBox.setBorder(BorderFactory.createLineBorder(darker(DARK_NAVY), 4));
            topRow.add(petBox);

            JPanel infoPanel = new JPanel(new GridLayout(4, 1, 0, 10));
            infoPanel.setOpaque(false);
            infoPanel.add(makeInfo("Name", "Sparky"));
            infoPanel.add(makeInfo("Type", "Dragon"));
            infoPanel.add(makeInfo("Likes", "Takis"));
            infoPanel.add(makeInfo("Dislikes", "Water"));
            topRow.add(infoPanel);

            // Stat bars
            JPanel statsPanel = new JPanel(new GridBagLayout());
            statsPanel.setOpaque(false);
            addStatRow(statsPanel, 0, "Hunger:", 80, RED);
            addStatRow(statsPanel, 1, "Happiness:", 50, YELLOW);
            addStatRow(statsPanel, 2, "Energy:", 100, TEAL);

            JPanel statsWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
            statsWrapper.setOpaque(false);
            statsWrapper.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));
            statsWrapper.add(statsPanel);

            centerPanel.add(topRow, BorderLayout.NORTH);
            centerPanel.add(statsWrapper, BorderLayout.CENTER);
            frame.add(centerPanel, BorderLayout.CENTER);

            // Buttons
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
            buttonPanel.setOpaque(false);
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
            buttonPanel.add(makeButton("Feed", RED));
            buttonPanel.add(makeButton("Play", YELLOW));
            buttonPanel.add(makeButton("Sleep", TEAL));
            frame.add(buttonPanel, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }
}