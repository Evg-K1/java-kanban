package manager;

import task.Epic;
import task.Subtask;
import task.Task;

import java.util.List;

public interface TaskManager {
    List<Task> getAllTasks();
    void createTask(Task task);
    void updateTask(Task task);
    void deleteTaskById(int id);

    List<Epic> getAllEpics();
    void createEpic(Epic epic);
    void deleteEpicById(int id);

    List<Subtask> getAllSubtasks();
    void createSubtask(Subtask subtask);
    void updateSubtask(Subtask subtask);

    Task getTaskById(int id);
    Epic getEpicById(int id);
    Subtask getSubtaskById(int id);

    List<Subtask> getSubtasksOfEpic(int epicId);

    List<Task> getHistory();
}

