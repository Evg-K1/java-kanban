package task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EpicTest {

    private Epic epic;

    @BeforeEach
    void setUp() {
        epic = new Epic("Test Epic", "Epic description");
        epic.setId(1);
    }

    @Test
    void epicShouldBeEqualIfIdsAreEqual() {
        Epic otherEpic = new Epic("Another", "Another desc");
        otherEpic.setId(epic.getId());

        assertEquals(epic, otherEpic, "Эпики с одинаковыми id должны быть равны.");
    }

    @Test
    void epicShouldNotBeEqualIfIdsAreDifferent() {
        Epic otherEpic = new Epic("Another", "Another desc");
        otherEpic.setId(2);

        assertNotEquals(epic, otherEpic, "Эпики с разными id не должны быть равны.");
    }

    @Test
    void epicHasEmptySubtaskListOnInit() {
        assertTrue(epic.getSubtaskIds().isEmpty(), "У нового эпика не должно быть подзадач.");
    }

}
