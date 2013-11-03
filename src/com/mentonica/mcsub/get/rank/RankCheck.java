package com.mentonica.mcsub.get.rank;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.yaml.snakeyaml.Yaml;

public class RankCheck extends TestCase {
    @SuppressWarnings("unchecked")
    public void testLoad() {
        Yaml yaml = new Yaml();
        String document = "\n- Hesperiidae\n- Papilionidae\n- Apatelodidae\n- Epiplemidae";
        List<String> list = (List<String>) yaml.load(document);
        assertEquals("[Hesperiidae, Papilionidae, Apatelodidae, Epiplemidae]", list.toString());
    }

    public void testLoadFromString() {
        Yaml yaml = new Yaml();
        String document = "hello: 25";
        @SuppressWarnings("unchecked")
        Map<String, Integer> map = (Map<String, Integer>) yaml.load(document);
        assertEquals("{hello=25}", map.toString());
        assertEquals(new Integer(25), map.get("hello"));
    }

    public void testLoadFromStream() throws IOException {
        InputStream input = new FileInputStream(new File("src/test/resources/reader/utf-8.txt"));
        Yaml yaml = new Yaml();
        Object data = yaml.load(input);
        assertEquals("test", data);
        //
        data = yaml.load(new ByteArrayInputStream("test2".getBytes("UTF-8")));
        assertEquals("test2", data);
        input.close();
    }

    public void testLoadManyDocuments() throws IOException {
        InputStream input = new FileInputStream(new File(
                "src/test/resources/specification/example2_28.yaml"));
        Yaml yaml = new Yaml();
        int counter = 0;
        for (Object data : yaml.loadAll(input)) {
            assertNotNull(data);
            assertTrue(data.toString().length() > 1);
            counter++;
        }
        assertEquals(3, counter);
        input.close();
    }
}