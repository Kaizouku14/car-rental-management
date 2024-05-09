package Components.splashscreen;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

public class SlidePanel extends javax.swing.JPanel {
    
        public int getAnimate() {
        return animate;
    }

    public void setAnimate(int animate) {
        this.animate = animate;
    }

    public SlidePanel() {
        initComponents();
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                animate();
            }
        });
    }
    private int animate = 1;
    private Timer timer;
    private Component com1;
    private Component com2;
    private List<Component> list = new ArrayList<>();
    private int currentShowing;
    private boolean animateRight;

    public void init(Component... com) {
        if (com.length > 0) {
            for (Component c : com) {
                list.add(c);
                c.setSize(getSize());
                c.setVisible(false);
                this.add(c);
            }
            Component show = list.get(0);
            show.setVisible(true);
            show.setLocation(0, 0);
        }
    }

    public void show(int index) {
         
        if (!timer.isRunning()) {
            if (list.size() >= 2 && index < list.size() && index != currentShowing) {
                com2 = list.get(index);
                com1 = list.get(currentShowing);
                animateRight = index < currentShowing;
                currentShowing = index;
                com2.setVisible(true);
                if (animateRight) {
                    com2.setLocation(-com2.getWidth(), 0);
                } else {
                    com2.setLocation(getWidth(), 0);
                }
                timer.start();
            }
        }
    }

    private void animate() {
        if (animateRight) {
            if (com2.getLocation().x < 0) {
                com2.setLocation(com2.getLocation().x + animate, 0);
                com1.setLocation(com1.getLocation().x + animate, 0);
            } else {
                com2.setLocation(0, 0);
                timer.stop();
                com1.setVisible(true);
            }
        } else {
            if (com2.getLocation().x > 0) {
                com2.setLocation(com2.getLocation().x - animate, 0);
                com1.setLocation(com1.getLocation().x - animate, 0);
            } else {
                com2.setLocation(0, 0);
                timer.stop();
                com1.setVisible(true);
            }
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
