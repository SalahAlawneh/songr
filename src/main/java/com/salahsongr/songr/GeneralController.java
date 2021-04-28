package com.salahsongr.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GeneralController {
//    @OneToMany(mappedBy = "album")


    Song song;
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;

    @GetMapping("/")
    public String renderSplash() {
        return "splash";
    }

    @GetMapping("/songs")
    public String renderSongs() {
        return "songs";
    }

    @GetMapping("/albums")
    public String renderAlbum(Model model) {
        List<Album> albumList = (List<Album>) albumRepository.findAll();
        model.addAttribute("album", albumList);
        return "albums";
    }

    @PostMapping("/addAlbum")
    public RedirectView addAlbum(@RequestParam(value = "title") String title,
                                 @RequestParam(value = "artist") String artist,
                                 @RequestParam(value = "songCount") int songCount,
                                 @RequestParam(value = "length") int length,
                                 @RequestParam(value = "imageUrl") String imageUrl) {
        Album album = new Album(title, artist, songCount, length, imageUrl);
        albumRepository.save(album);
        return new RedirectView("/albums");

    }

    @GetMapping("/albums/{id}")
    public String renderOneAlbum(@PathVariable Integer id, Model model) {
//        List<AlbumRepository> oneAlbum = (List<AlbumRepository>) albumRepository.getOne(id);
        model.addAttribute("album", albumRepository.getOne(id));
        return "songs";
    }

    @PostMapping("/addSong")
    public RedirectView addSong(String title, int trackNumber, int length) {
        Song song = new Song(title, length, trackNumber);
        songRepository.save(song);
        return new RedirectView("/songs");
    }


}
