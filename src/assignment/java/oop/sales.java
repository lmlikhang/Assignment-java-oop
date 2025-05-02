/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.java.oop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author alvin
 */
public class sales {
    
    private String ID;
    private String ItemName;
    private String Price;
    private int Quantity;
    
    public sales(String ID, String ItemName, String Price, int Quantity){
        this.ID = ID;
        this.ItemName = ItemName;
        this.Price = Price;
        this.Quantity = Quantity;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
    
    
    
    public sales(){
    
    }
    
    public void loadItemsToTable(javax.swing.JTable itemsTable) {
        String filePath = "item.txt"; 

        // Create the table columns
        String[] columns = {"ID", "Item name", "Price", "Quantity"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);  // Create a new table model with columns

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                // Split line into data (assuming comma-separated format)
                String[] itemData = line.split(",");

                // Ensure that the line has the expected number of elements
                if (itemData.length == 4) {
                    // Add the data to the table model
                    model.addRow(itemData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set the table model to update the JTable
        itemsTable.setModel(model);
    }
    public void loadTSupplieroTable(javax.swing.JTable supplierinfo) {
        String filePath = "suppliers.txt"; 

        // Create the table columns
        String[] columns = {"ID", "supplier name", "Email", "Product"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);  // Create a new table model with columns

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                // Split line into data (assuming comma-separated format)
                String[] itemData = line.split(",");

                // Ensure that the line has the expected number of elements
                if (itemData.length == 4) {
                    // Add the data to the table model
                    model.addRow(itemData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set the table model to update the JTable
        supplierinfo.setModel(model);
    }
    
    public void AddItem(javax.swing.JTable items) {
        String filePath = "item.txt";

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
        writer.write(ID + "," + ItemName + "," +"$"+ Price + "," + Quantity);
        writer.newLine();
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "An error occurred while saving items: " + e.getMessage());
    }
    }
    
    public void UpdateItem(javax.swing.JTable supplierinfo) {
        
    }
    
    public void RemoveItem(javax.swing.JTable supplierinfo) {
        
    }

}
