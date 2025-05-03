
package assignment.java.oop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class sales {
    
    private String ID;
    private String ItemName;
    private String Price;
    private int Quantity;
    private String SupplierName;
    private String Email;
    private String Product;  
    
    public sales(String ID, String ItemName, String Price, int Quantity){
        this.ID = ID;
        this.ItemName = ItemName;
        this.Price = Price;
        this.Quantity = Quantity;
    }
    
    public sales(String ID, String SupplierName, String Email, String Product){
        this.ID = ID;
        this.SupplierName = SupplierName;
        this.Email = Email;
        this.Product = Product;
    }
    
    public sales(){
    
    }
    
    public void loadItemsToTable(javax.swing.JTable itemsTable) {
        String filePath = "item.txt"; 


        String[] columns = {"ID", "Item name", "Price", "Quantity"};
        DefaultTableModel model = new DefaultTableModel(columns, 0); 

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;


            while ((line = reader.readLine()) != null) {

                String[] itemData = line.split(",");


                if (itemData.length == 4) {

                    model.addRow(itemData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        itemsTable.setModel(model);
    }
    public void loadTSupplieroTable(javax.swing.JTable supplierinfo) {
        String filePath = "suppliers.txt"; 


        String[] columns = {"ID", "supplier name", "Email", "Product"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;


            while ((line = reader.readLine()) != null) {

                String[] itemData = line.split(",");


                if (itemData.length == 4) {

                    model.addRow(itemData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        supplierinfo.setModel(model);
    }
    
    public void AddItem(javax.swing.JTable items) {
        String filePath = "item.txt";
        String generatedID = generateNextID(filePath);
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
        writer.write(generatedID + "," + ItemName + "," +"$"+ Price + "," + Quantity);
        writer.newLine();
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "An error occurred while saving items: " + e.getMessage());
    }
    }
    public String generateNextID(String filePath) {
        String lastLine = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null){
                lastLine = line;
            }
        }catch (IOException e){
            
        }
        if (!lastLine.isEmpty()){
            String[] parts = lastLine.split(",");
            if (parts.length > 0){
                try {
                    int lastID = Integer.parseInt(parts[0]);
                    return String.format("%04d",lastID + 1);
                }catch (NumberFormatException e){
                    
                }
            }
        }
        return "101";
        
    }
    
    public void RemoveItem(String idToRemove) {
        String filePath = "item.txt";
        File inputFile = new File(filePath);
        File tempFile = new File("temp.txt");

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
        ) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] data = currentLine.split(",");
                if (data.length > 0 && data[0].equals(idToRemove)) {
                    continue; // skip this line (deletes it)
                }
                writer.write(currentLine);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error removing item: " + e.getMessage());
            return;
        }

        // Replace old file with updated file
        if (inputFile.delete()) {
            tempFile.renameTo(inputFile);
        } else {
        JOptionPane.showMessageDialog(null, "Could not replace the file.");
    }
    }
    
    public void AddSuppliers(javax.swing.JTable items){
        String filePath = "suppliers.txt";
        String generatedID = generateNextID(filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(generatedID + "," + SupplierName + "," + Email + "," + Product);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while saving items: " + e.getMessage());
        }
    }
    public void RemoveSupplier(String idToRemove) {
        String filePath = "suppliers.txt";
        File inputFile = new File(filePath);
        File tempFile = new File("temp.txt");

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
        ) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] data = currentLine.split(",");
                if (data.length > 0 && data[0].equals(idToRemove)) {
                    continue; // skip this line (deletes it)
                }
                writer.write(currentLine);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error removing item: " + e.getMessage());
            return;
        }

        // Replace old file with updated file
        if (inputFile.delete()) {
            tempFile.renameTo(inputFile);
        } else {
        JOptionPane.showMessageDialog(null, "Could not replace the file.");
    }
    }

}
