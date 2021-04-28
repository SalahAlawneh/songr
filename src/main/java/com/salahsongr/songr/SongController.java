//package com.salahsongr.songr;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import java.util.List;
//import java.util.jar.Attributes;
//
//@Controller
//public class SongController {
//    @Autowired
//    SongRepository songRepository;
//
//    @GetMapping("/song/{id}")
//    public String renderOneAlbum(@PathVariable(value = "id") Integer id, Model model) {
//        Song song = songRepository.findById(id).get();
//        System.out.println(id);
//        model.addAttribute("song", song);
//        return "album";
//    }
//
//    @GetMapping("/addSong")
//    public String renderAddSong() {
//        return "addSong";
//    }
//
//
//
//    @PostMapping("/addSong")
//    public String postSong(String title, int length, int trackNumber) {
//        Song song = new Song(title, length, trackNumber);
//        songRepository.save(song);
//        return "songs";
//    }
//
//}
