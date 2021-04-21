package com.epam.geometry.data;

import com.epam.geometry.TriangleCreator;
import com.epam.geometry.model.Point;
import com.epam.geometry.model.Triangle;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DataReaderTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testCreatorSamePoint() throws DataException {
        exception.expect(DataException.class);
        DataReader reader = new DataReader();
        List<String> lines = reader.readLines("NoExistingFile.txt");
    }
}
