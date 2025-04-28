/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.java.oop;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author alvin
 */
public class sales {
    
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
    
    
    

    

}
