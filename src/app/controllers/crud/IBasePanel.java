
package app.controllers.crud;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JPanel;


public interface IBasePanel {
    JButton btnCancel = new JButton();
    JButton btnCreate = new JButton();
    JButton btnDelete = new JButton();
    JButton btnEdit = new JButton();
    JButton btnSave = new JButton();
    JLabel infoTag = new JLabel();
    JTable table = new JTable();
    JPanel detailsPanel = new JPanel();
    
    public JTable getTable();
    public JPanel getDetailsPanel();
    public JButton getBtnCancel();
    public JButton getBtnCreate();
    public JButton getBtnDelete();
    public JButton getBtnEdit();
    public JButton getBtnSave();
    public JLabel getInfoTag();

}
