package Test;

import manager.HistoryManager;
import manager.Managers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task.Epic;
import task.Status;
import task.Task;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryHistoryManagerTest {

    private HistoryManager historyManager;
    private Task task1;
    private Task task2;

    @BeforeEach
    void setUp() {
        historyManager = Managers.getDefaultHistory();
        task1 = new Task("Task 1", "Description 1", Status.NEW);
        task1.setId(1);
        task2 = new Task("Task 2", "Description 2", Status.IN_PROGRESS);
        task2.setId(2);
    }

    @Test
    void shouldAddTaskToHistory() {
        historyManager.add(task1);
        List<Task> history = historyManager.getHistory();

        assertNotNull(history, "История не должна быть null после добавления задачи.");
        assertEquals(1, history.size(), "История должна содержать одну задачу.");
        assertEquals(task1, history.get(0), "Задача в истории не совпадает с добавленной.");
    }

    @Test
    void shouldNotDuplicateTasksInHistory() {
        historyManager.add(task1);
        historyManager.add(task1);

        List<Task> history = historyManager.getHistory();
        assertEquals(1, history.size(), "Задача не должна дублироваться в истории.");
    }

    @Test
    void shouldReturnEmptyHistoryWhenNoTasks() {
        List<Task> history = historyManager.getHistory();
        assertNotNull(history, "История не должна быть null.");
        assertTrue(history.isEmpty(), "История должна быть пустой при инициализации.");
    }

    @Test
    void shouldKeepOrderOfAccess() {
        historyManager.add(task1);
        historyManager.add(task2);
        historyManager.add(task1); // task1 снова в конец

        List<Task> history = historyManager.getHistory();
        assertEquals(2, history.size(), "История должна содержать две задачи.");
        assertEquals(task2, history.get(0), "Первая задача должна быть task2.");
        assertEquals(task1, history.get(1), "Вторая задача должна быть task1.");
    }

    @Test
    void epicShouldBeEqualIfIdsAreEqual() {
        Epic epic1 = new Epic("Test Epic", "Epic description");
        epic1.setId(1);

        Epic epic2 = new Epic("Another", "Another desc");
        epic2.setId(1);

        assertEquals(epic1, epic2, "Эпики с одинаковыми id должны быть равны.");
    }
}