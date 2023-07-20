package app.views.register;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MultiStepForm extends JFrame {

    private JPanel currentPanel;
    private JPanel step1Panel;
    private JPanel step2Panel;
    private JPanel step3Panel;
    private int currentStep;

    public MultiStepForm() {
        setTitle("Formulario de Múltiples Pasos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));
        setLayout(new BorderLayout());

        // Inicializar los paneles de cada paso del formulario
        step1Panel = createStep1Panel();
        step2Panel = createStep2Panel();
        step3Panel = createStep3Panel();

        // Panel inicial
        currentStep = 1;
        currentPanel = step1Panel;
        add(currentPanel, BorderLayout.CENTER);

        // Botones de navegación
        JPanel buttonPanel = new JPanel();
        JButton previousButton = new JButton("Anterior");
        JButton nextButton = new JButton("Siguiente");
        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Acción del botón "Anterior"
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentStep > 1) {
                    currentStep--;
                    switchStepPanel();
                }
            }
        });

        // Acción del botón "Siguiente"
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentStep < 3) {
                    currentStep++;
                    switchStepPanel();
                } else {
                    // Lógica para procesar los datos del formulario completo
                    JOptionPane.showMessageDialog(MultiStepForm.this, "¡Formulario completado!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    // Puedes cerrar el formulario o realizar alguna otra acción aquí
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    private void switchStepPanel() {
        remove(currentPanel);
        switch (currentStep) {
            case 1:
                currentPanel = step1Panel;
                break;
            case 2:
                currentPanel = step2Panel;
                break;
            case 3:
                currentPanel = step3Panel;
                break;
        }
        add(currentPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private JPanel createStep1Panel() {
        JPanel panel = new JPanel();
        
        panel.setLayout(new FlowLayout());

        // Agregar componentes para el primer paso del formulario
        JLabel label = new JLabel("Paso 1: Información personal");
        JTextField input = new JTextField("holaaaaa");
        panel.add(label);
        panel.add(input);
        

        return panel;
    }

    private JPanel createStep2Panel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Agregar componentes para el segundo paso del formulario
        JLabel label = new JLabel("Paso 2: Información de contacto");
        panel.add(label);

        return panel;
    }

    private JPanel createStep3Panel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Agregar componentes para el tercer paso del formulario
        JLabel label = new JLabel("Paso 3: Confirmación");
        panel.add(label);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MultiStepForm form = new MultiStepForm();
                form.setVisible(true);
            }
        });
    }
}
