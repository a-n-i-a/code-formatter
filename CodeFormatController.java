package org.example.tpo7;

import com.google.googlejavaformat.java.FormatterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.Collection;
import java.util.Optional;

@Controller
public class CodeFormatController {
    private CodeFormat codeFormat;
    private Storage storage;

    public CodeFormatController(CodeFormat codeFormat, Storage storage){
        this.codeFormat = codeFormat;
        this.storage = storage;
    }

    @GetMapping("/")
    public String frontPage(Model model){
        model.addAttribute("formattedCode", "");
        return "front";
    }

@PostMapping("/formatted")
public String formatPage(Model model, @RequestParam("originalCode") String originalCode,
                         @RequestParam(value = "duration", defaultValue = "2", required = false) long duration,
                         @RequestParam(value = "id") String id) {

    if (originalCode == null) {
        model.addAttribute("error", "You have not provided a valid code for formatting!");
        return "front";
    }

    EntryDTO entryDTO = new EntryDTO(id, originalCode, duration);

    String formattedCode;
    formattedCode = codeFormat.formatCode(entryDTO.getOriginal());

    Entry entry = new Entry(entryDTO.getId(), entryDTO.getOriginal(), formattedCode, Duration.ofSeconds(entryDTO.getDuration()));
    boolean isSaved = storage.save(entry);
    if (!isSaved) {
        entry = new Entry(id, originalCode, formattedCode, Duration.ofSeconds(entryDTO.getDuration()));
        isSaved = storage.save(entry);
    }

    model.addAttribute("originalCode", entryDTO.getOriginal());
    model.addAttribute("formattedCode", formattedCode);
    model.addAttribute("id", id);
    return "front";
}




@GetMapping("/storage")
public String viewSaved(Model model){
    Collection<Entry> allEntries = storage.getAllEntries();
    model.addAttribute("entries", allEntries);
    return "storage";
    }

}
