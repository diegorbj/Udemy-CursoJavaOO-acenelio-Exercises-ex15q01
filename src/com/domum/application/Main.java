package com.domum.application;

import com.domum.entities.OrderItem;
import com.domum.entities.Product;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String filePath = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            File file = new File(filePath);
            boolean success = new File(file.getParent() + "\\out").mkdir();

            boolean appendFile = false;

            String productLine = br.readLine();
            int id = 0;
            while (productLine != null) {
                System.out.println(productLine);
                String[] item = productLine.split(",");

                Product product = new Product(item[0], Double.parseDouble(item[1]));
                int quantity = Integer.parseInt(item[2]);
                OrderItem orderItem = new OrderItem(++id, product, quantity);

                try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.getParent() + "\\out\\summary.csv", appendFile))) {
                    appendFile = true;
                    bw.write(String.format("%s,%.2f", orderItem.getProduct().getName(), orderItem.subTotal()));
                    bw.newLine();
                } catch (IOException e) {
                    System.out.println("Could not write de summary to the file.");
                }
                productLine = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
