package com.salahsongr.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
public class AlbumController {
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/albums")
    public String renderAlbum(Model model) {
        Album alhawaSultan = new Album("alhawaSultan", "George Wassof", "Helf Ala'amar", 394, "https://cdnarabic1.img.sputniknews.com/img/103157/86/1031578642_0:0:999:540_1000x541_80_0_0_e0e97ec28982625902dcbdb23d70cae4.jpg");
        Album salafWDayn = new Album("Salaf W. Dayn", "George Wassof", "Salaf W. Dayn", 495, "https://upload.wikimedia.org/wikipedia/commons/e/e9/George_Wassouf.jpg");
        Album tabeebGarah = new Album("Tabeeb Garah", "George Wassof", "Tabeeb Garah", 354, "https://m.media-amazon.com/images/I/91Z22JY5ZhL._SS500_.jpg");
////        ArrayList<Album> albums = new ArrayList<Album>();
        albumRepository.save(alhawaSultan);
        albumRepository.save(salafWDayn);
        albumRepository.save(tabeebGarah);
        model.addAttribute("album", albumRepository.findAll());
        return "album";
    }

    @GetMapping("/addAlbum")
    public String addAlbum() {
        return "addAlbum";
    }

    @PostMapping("/addAlbum")
    public RedirectView addAlbum(@RequestParam(value = "title") String title,
                                 @RequestParam(value = "artist") String artist,
                                 @RequestParam(value = "songCount") String songCount,
                                 @RequestParam(value = "length") int length,
                                 @RequestParam(value = "imageUrl") String imageUrl) {
        Album album = new Album(title, artist, songCount, length, imageUrl);
        albumRepository.save(album);
        return new RedirectView("/albums");

    }

}
