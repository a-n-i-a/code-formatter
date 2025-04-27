package org.example.tpo7;

import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;
import org.springframework.stereotype.Component;

@Component
public class CodeFormat {
    private Formatter formatter;

    public CodeFormat(){
        this.formatter = new Formatter();

    }

    public String formatCode(String code){
        String result = "";
        try {
            result = formatter.formatSource(code);
        } catch (FormatterException e) {
            System.err.println("Error while formatting provided code: " + e.getMessage());
        }

        return result;
    }

}
