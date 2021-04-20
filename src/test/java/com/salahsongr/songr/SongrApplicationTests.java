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
		alhawaSultan.setSongCount(5);
		alhawaSultan.setLength(2100);
		assertEquals("George Wassof", alhawaSultan.getArtist());
		assertEquals(5,alhawaSultan.getSongCount());
		assertEquals(2100,alhawaSultan.getLength());
	}
}
