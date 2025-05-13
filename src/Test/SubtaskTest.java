package Test;

import org.junit.jupiter.api.Test;
import task.Status;
import task.Subtask;

import static org.junit.jupiter.api.Assertions.*;

class SubtaskTest {

    @Test
    void subtasksShouldBeEqualIfIdsAreEqual() {
        Subtask subtask1 = new Subtask("Subtask", "Description", Status.NEW, 100);
        Subtask subtask2 = new Subtask("Another Subtask", "Another Desc", Status.DONE, 100);

        subtask1.setId(1);
        subtask2.setId(1);

        assertEquals(subtask1, subtask2, "Подзадачи с одинаковыми id должны быть равны.");
    }

    @Test
    void subtaskShouldNotBeEqualToNullOrDifferentClass() {
        Subtask subtask = new Subtask("Subtask", "Description", Status.NEW, 100);
        subtask.setId(1);

        assertNotEquals(null, subtask, "Подзадача не должна быть равна null.");
        assertNotEquals("Some String", subtask, "Подзадача не должна быть равна объекту другого типа.");
    }

    @Test
    void epicIdShouldBeSetCorrectly() {
        Subtask subtask = new Subtask("Test", "Test desc", Status.NEW, 10);
        assertEquals(10, subtask.getEpicId(), "ID эпика установлен некорректно.");
    }
}
