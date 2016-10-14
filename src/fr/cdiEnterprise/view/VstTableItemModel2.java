package fr.cdiEnterprise.view;

import java.util.ArrayList;
import java.util.List;


import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import fr.cdiEnterprise.service.Items;

public class VstTableItemModel2<Item> extends AbstractTableModel {

    private Items users;
    private String[] columnIdentifiers;
    private String[] columnNames = {"Sender","Objet", "Date Envoie"};
    
    public VstTableItemModel2(Items users) {

        this.users = users;

    }





    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    
    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
 

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	
    	Object value = (Item) "??";
        
    	fr.cdiEnterprise.model.Item user =  users.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                value = user.getSender();
                break;
            case 1:
                value = user.getObject();
                break;
            case 2:
                value = user.getTimeStamp();
                break;
        }

        return value;

    }

//    @Override
//    public Class<?> getColumnClass(int columnIndex) {
//        return // Return the class that best represents the column...
//    }

    /* Override this if you want the values to be editable...
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //....
    }
    */

    /**
     * This will return the user at the specified row...
     * @param row
     * @return 
     */
    public fr.cdiEnterprise.model.Item getUserAt(int row) {
        return users.get(row);
    }





	public void addTableModelListener(TableModel tableModel) {
		// TODO Auto-generated method stub
		
	}





}