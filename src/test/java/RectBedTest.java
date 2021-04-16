
import garden_planner.model.RectBed;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectBedTest {

    @Test
    void testGetArea() {
        RectBed rBed = new RectBed();

        Assertions.assertEquals(1, rBed.getArea());

        rBed.setWidth(2);
        rBed.setHeight(3);
        assertEquals(6, rBed.getArea());
    }

}
