package com.salahsongr.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class AlbumController {
    @GetMapping("/albums")
    public String renderAlbum(Model model) {
        Album alhawaSultan = new Album("alhawaSultan","George Wassof","Helf Ala'amar",394,"data:image/jpeg;base64,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");
        Album salafWDayn = new Album("Salaf W. Dayn","George Wassof","Salaf W. Dayn",495,"data:image/jpeg;base64,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");
        Album abeebGarah = new Album("Tabeeb Garah","George Wassof","Tabeeb Garah",354,"https://m.media-amazon.com/images/I/91Z22JY5ZhL._SS500_.jpg");
        ArrayList<Album> albums = new ArrayList<Album>();
        albums.add(alhawaSultan);
        albums.add(salafWDayn);
        albums.add(abeebGarah);
        model.addAttribute("album",albums);
        return "album";
    }
}
