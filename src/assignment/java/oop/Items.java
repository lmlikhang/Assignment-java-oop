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
public class Items {
    
    public void loadItemsToTable(javax.swing.JTable table) {
        // Specify the columns for the table
        String[] columns = {"ID", "Item name", "Price", "Quantity"};
        // Create an empty data array
        Object[][] data = new Object[0][4];
        
        try (BufferedReader br = new BufferedReader(new FileReader("item.txt"))) {
            String line;
            int rowCount = 0;

            // Read the file line by line
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // Split by commas
                if (values.length == 4) {
                    // Add to the data array
                    data = expandArray(data, rowCount + 1);
                    data[rowCount][0] = values[0]; // ID
                    data[rowCount][1] = values[1]; // Item name
                    data[rowCount][2] = values[2]; // Price
                    data[rowCount][3] = values[3]; // Quantity
                    rowCount++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set the table model with the data
        DefaultTableModel model = new DefaultTableModel(data, columns);
        table.setModel(model);
    }

    // Helper method to expand the data array when reading new data
    private Object[][] expandArray(Object[][] original, int newLength) {
        Object[][] newArray = new Object[newLength][original[0].length];
        System.arraycopy(original, 0, newArray, 0, original.length);
        return newArray;
    }

}
