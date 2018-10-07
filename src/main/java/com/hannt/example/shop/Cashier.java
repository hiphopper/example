package com.hannt.example.shop;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Date;
import java.util.Locale;

@Component
@Scope("prototype")
public class Cashier {
    @Setter private String fileName;
    @Setter private String path;
    private BufferedWriter writer;

    private MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void openFile() throws IOException{
        File targetDir = new File(path);
        if(!targetDir.exists()){
            targetDir.mkdir();
        }

        File checkoutFile = new File(targetDir, fileName+".txt");
        if(!checkoutFile.exists()){
            checkoutFile.createNewFile();
        }

        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(checkoutFile, true)));
    }

    public void closeFile() throws IOException{
        writer.close();
    }

    public void checkout(ShoppingCart shoppingCart) throws IOException{
        String alert = messageSource.getMessage("alert.inventory.checkout",
                new Object[]{shoppingCart.getItems(), new Date()}, Locale.US);
        writer.write(alert+"\r\n");
        writer.flush();
    }
}
