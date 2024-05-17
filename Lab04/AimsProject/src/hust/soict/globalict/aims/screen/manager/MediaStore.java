package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.disc.*;
import hust.soict.globalict.aims.media.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        ButtonListener btnListener = new ButtonListener();
        JLabel mediaType;

        if (media instanceof Book) {
            mediaType = new JLabel("(Book)");
        } else if (media instanceof CompactDisc) {
            mediaType = new JLabel("(CD)");
        } else if (media instanceof DigitalVideoDisc) {
            mediaType = new JLabel("(DVD)");
        }

        mediaType.setFont(new Font(mediaType.getFont().getName(), Font.PLAIN, 15));
        mediaType.setAlignmentX(CENTER_ALIGNMENT);

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + "$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(btnListener);
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(mediaType);
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String buttonCommand = e.getActionCommand();
            if (buttonCommand.equals("Play")) {
                if (media instanceof CompactDisc) {
                    CompactDisc cdToPlay = (CompactDisc) media;
                    cdToPlay.play();
                } else if (media instanceof DigitalVideoDisc) {
                    DigitalVideoDisc dvdToPlay = (DigitalVideoDisc) media;
                    dvdToPlay.play();
                }
            }
        }
    }
}
