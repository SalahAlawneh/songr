package com.salahsongr.songr;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testAlbumSetterAndGetter() {
		Album alhawaSultan=new Album();
		alhawaSultan.setArtist("George Wassof");
		alhawaSultan.setSongCount("Helf Ala'amar");
		alhawaSultan.setLength(394);
		assertEquals("George Wassof", alhawaSultan.getArtist());
		assertEquals("Helf Ala'amar",alhawaSultan.getSongCount());
		assertEquals(394,alhawaSultan.getLength());
	}
}
