package com.salahsongr.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SongController {
    @Autowired
    SongRepository songRepository;
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/songs")
    public String renderSongsDB(Model model) {
        model.addAttribute("songs", songRepository.findAll());
        return "students";
    }

    @GetMapping("/songs/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable(value = "id") int id) {
        Song song = songRepository.findById(id).get();
        return new ResponseEntity(song, HttpStatus.OK);
    }

    @PostMapping("/songs")
    public ResponseEntity<Song> addSong(String title,int length,int trackNumber,Integer albumId) {
Album album =AlbumRepository.findById(albumId).get();
        Song newSong = new Song(title,length,trackNumber,album);
        songRepository.save(newSong);
        return new ResponseEntity(newSong,HttpStatus.OK);
    }

}
