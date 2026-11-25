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
    static JProgressBar addStatRow(JPanel panel, int row, String name, int value, Color color) {
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
        bar.addChangeListener(e -> percent.setText(bar.getValue() + "%"));
        return bar;
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

    private static JPanel makePetImage(String type) {
        JPanel image = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

                int size = 10;
                int x = (getWidth() - 16 * size) / 2;
                int y = (getHeight() - 12 * size) / 2;

                if ("Dragon".equals(type)) {
                    g2.setColor(new Color(0x79C267));
                    g2.fillRect(x + 4 * size, y + 2 * size, 8 * size, 8 * size);
                    g2.fillRect(x + 2 * size, y + 4 * size, 12 * size, 5 * size);
                    g2.setColor(new Color(0x4B8C46));
                    g2.fillRect(x + 2 * size, y + 3 * size, 2 * size, 2 * size);
                    g2.fillRect(x + 12 * size, y + 3 * size, 2 * size, 2 * size);
                    g2.setColor(new Color(0xBDEB91));
                    g2.fillRect(x + 5 * size, y + 4 * size, 2 * size, 2 * size);
                    g2.fillRect(x + 9 * size, y + 4 * size, 2 * size, 2 * size);
                    g2.setColor(new Color(0x12324F));
                    g2.fillRect(x + 6 * size, y + 5 * size, size, size);
                    g2.fillRect(x + 9 * size, y + 5 * size, size, size);
                    g2.setColor(new Color(0xF8DDB0));
                    g2.fillRect(x + 7 * size, y + 7 * size, 3 * size, size);
                    g2.setColor(new Color(0xDC4339));
                    g2.fillRect(x + 8 * size, y + 7 * size, size, size);
                    g2.setColor(new Color(0xFAB432));
                    g2.fillRect(x + 3 * size, y, 2 * size, 3 * size);
                    g2.fillRect(x + 11 * size, y, 2 * size, 3 * size);
                } else if ("Yeti".equals(type)) {
                    g2.setColor(new Color(0xEAF6F6));
                    g2.fillRect(x + 3 * size, y + 2 * size, 10 * size, 9 * size);
                    g2.fillRect(x + size, y + 5 * size, 14 * size, 4 * size);
                    g2.setColor(new Color(0xB9DADF));
                    g2.fillRect(x + 2 * size, y + 3 * size, 2 * size, 3 * size);
                    g2.fillRect(x + 12 * size, y + 3 * size, 2 * size, 3 * size);
                    g2.setColor(new Color(0x12324F));
                    g2.fillRect(x + 5 * size, y + 5 * size, size, size);
                    g2.fillRect(x + 10 * size, y + 5 * size, size, size);
                    g2.fillRect(x + 7 * size, y + 8 * size, 2 * size, size);
                    g2.setColor(new Color(0x6DA7B1));
                    g2.fillRect(x + 4 * size, y + 7 * size, 2 * size, size);
                    g2.fillRect(x + 10 * size, y + 7 * size, 2 * size, size);
                } else {
                    g2.setColor(new Color(0x78C9FF));
                    g2.fillRect(x + 3 * size, y + 3 * size, 10 * size, 8 * size);
                    g2.fillRect(x + 2 * size, y + 5 * size, 12 * size, 5 * size);
                    g2.setColor(new Color(0xB8E6FF));
                    g2.fillRect(x + 4 * size, y + 4 * size, 3 * size, 2 * size);
                    g2.fillRect(x + 5 * size, y + 2 * size, 2 * size, 2 * size);
                    g2.setColor(new Color(0x12324F));
                    g2.fillRect(x + 5 * size, y + 6 * size, size, size);
                    g2.fillRect(x + 10 * size, y + 6 * size, size, size);
                    g2.fillRect(x + 7 * size, y + 8 * size, 3 * size, size);
                    g2.setColor(new Color(0x4DA3CF));
                    g2.fillRect(x + 3 * size, y + 10 * size, 10 * size, size);
                }

                g2.dispose();
            }
        };
        image.setPreferredSize(new Dimension(250, 150));
        image.setBackground(DARK_NAVY);
        image.setBorder(BorderFactory.createLineBorder(darker(DARK_NAVY), 4));
        return image;
    }

    private static void checkGameOver(Pet pet, JFrame frame) {
        boolean hungerDepleted = pet.getHunger() <= 0;
        boolean energyDepleted = pet.getEnergy() <= 0;
        boolean happinessDepleted = pet.getHappiness() <= 0;
        if (!hungerDepleted && !energyDepleted && !happinessDepleted) {
            return;
        }

        String message;
        if (hungerDepleted && energyDepleted && happinessDepleted) {
            message = pet.getName() + " collapsed from extreme hunger, exhaustion, and sadness!";
        } else if (hungerDepleted && energyDepleted) {
            message = pet.getName() + " collapsed from extreme hunger and exhaustion!";
        } else if (hungerDepleted && happinessDepleted) {
            message = pet.getName() + " starved and became too sad!";
        } else if (energyDepleted && happinessDepleted) {
            message = pet.getName() + " passed out from exhaustion and sadness!";
        } else if (hungerDepleted) {
            message = pet.getName() + " starved!";
        } else if (energyDepleted) {
            message = pet.getName() + " passed out from exhaustion!";
        } else {
            message = pet.getName() + " became sad!";
        }

        JOptionPane.showMessageDialog(
            frame,
            message,
            "Game Over",
            JOptionPane.INFORMATION_MESSAGE);
        frame.dispose();
    }

    // gets pet from main
    public static void show(Pet pet) {
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

            JPanel petBox = makePetImage(pet.getType());
            topRow.add(petBox);

            JPanel infoPanel = new JPanel(new GridLayout(4, 1, 0, 10));
            infoPanel.setOpaque(false);
            infoPanel.add(makeInfo("Name", pet.getName()));
            infoPanel.add(makeInfo("Type", pet.getType()));
            infoPanel.add(makeInfo("Likes", pet.getLikes()));
            infoPanel.add(makeInfo("Dislikes", pet.getDislikes()));
            topRow.add(infoPanel);

            // Stat bars
            JPanel statsPanel = new JPanel(new GridBagLayout());
            statsPanel.setOpaque(false);
            JProgressBar hungerBar = addStatRow(statsPanel, 0, "Hunger:", pet.getHunger(), RED);
            JProgressBar happinessBar = addStatRow(statsPanel, 1, "Happiness:", pet.getHappiness(), YELLOW);
            JProgressBar energyBar = addStatRow(statsPanel, 2, "Energy:", pet.getEnergy(), TEAL);

            JPanel statsWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
            statsWrapper.setOpaque(false);
            statsWrapper.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));
            statsWrapper.add(statsPanel);

            centerPanel.add(topRow, BorderLayout.NORTH);
            centerPanel.add(statsWrapper, BorderLayout.CENTER);
            frame.add(centerPanel, BorderLayout.CENTER);

            JPanel actionChoicesPanel = new JPanel(new BorderLayout());
            actionChoicesPanel.setOpaque(false);
            actionChoicesPanel.setVisible(false);

            // Food buttons: invisible until feed button is pressed
            JPanel foodPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
            foodPanel.setOpaque(false);
            for (FeedingAction food : FeedingAction.ALL) {
                JButton foodButton = makeButton(food.getName(), CREAM);
                foodButton.addActionListener(e -> {
                    food.onFed(pet);
                    hungerBar.setValue(pet.getHunger());
                    happinessBar.setValue(pet.getHappiness()); 
                    actionChoicesPanel.setVisible(false);
                    frame.revalidate();
                    frame.repaint();
                    checkGameOver(pet, frame);
                });
                foodPanel.add(foodButton);
            }

            // Play choices: hidden until Play is pressed
            JPanel playPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
            playPanel.setOpaque(false);
            for (PlayingAction action : PlayingAction.ALL) {
                JButton playButton = makeButton(action.getName(), YELLOW);
                playButton.setPreferredSize(new Dimension(150, 50));
                playButton.addActionListener(e -> {
                    action.play(pet);
                    hungerBar.setValue(pet.getHunger());
                    happinessBar.setValue(pet.getHappiness());
                    energyBar.setValue(pet.getEnergy());
                    actionChoicesPanel.setVisible(false);
                    frame.revalidate();
                    frame.repaint();
                    checkGameOver(pet, frame);
                });
                playPanel.add(playButton);
            }

            // Buttons
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
            buttonPanel.setOpaque(false);
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

            JButton feedButton = makeButton("Feed", RED);
            feedButton.addActionListener(e -> {
                boolean alreadyShowingFood = actionChoicesPanel.isVisible()
                    && actionChoicesPanel.getComponentCount() > 0
                    && actionChoicesPanel.getComponent(0) == foodPanel;
                actionChoicesPanel.removeAll();
                if (!alreadyShowingFood) {
                    actionChoicesPanel.add(foodPanel, BorderLayout.CENTER);
                }
                actionChoicesPanel.setVisible(!alreadyShowingFood);
                frame.revalidate();
                frame.repaint();
            });
            buttonPanel.add(feedButton);

            JButton playButton = makeButton("Play", YELLOW);
            playButton.addActionListener(e -> {
                boolean alreadyShowingPlay = actionChoicesPanel.isVisible()
                    && actionChoicesPanel.getComponentCount() > 0
                    && actionChoicesPanel.getComponent(0) == playPanel;
                actionChoicesPanel.removeAll();
                if (!alreadyShowingPlay) {
                    actionChoicesPanel.add(playPanel, BorderLayout.CENTER);
                }
                actionChoicesPanel.setVisible(!alreadyShowingPlay);
                frame.revalidate();
                frame.repaint();
            });
            buttonPanel.add(playButton);
            JButton sleepButton = makeButton("Sleep", TEAL);

            sleepButton.addActionListener(e -> {
                SleepAction.sleep(pet);

                // Update the progress bars
                hungerBar.setValue(pet.getHunger());
                energyBar.setValue(pet.getEnergy());
                checkGameOver(pet, frame);
            });
            buttonPanel.add(sleepButton);

            // Shows the selected food or play choices above the action buttons.
            JPanel bottomPanel = new JPanel(new BorderLayout());
            bottomPanel.setOpaque(false);
            bottomPanel.add(actionChoicesPanel, BorderLayout.NORTH);
            bottomPanel.add(buttonPanel, BorderLayout.CENTER);
            frame.add(bottomPanel, BorderLayout.SOUTH);

            frame.setVisible(true);
            checkGameOver(pet, frame);
        });
    }
}