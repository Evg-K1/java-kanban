public class Main {

    public static void main(String[] args) {
        System.out.println("Поехали!");

        TaskManager manager = new TaskManager();

        Task tas1 = new Task("задача1", "задача2", Status.NEW);
        Task tas2 = new Task("приготовить обед", "помыть тарелки", Status.NEW);
        manager.createTask(tas1);
        manager.createTask(tas2);

        Epic epic1 = new Epic("собраться на тенировку", "подготовить вещи");
        manager.createEpic(epic1);

        Subtask subtask1 = new Subtask("майские праздники", "собрать друзей", Status.NEW, epic1.getId());
        Subtask subtask2 = new Subtask("плехать в  магазин", "купить шашлык", Status.NEW, epic1.getId());
        manager.createSubtask(subtask1);
        manager.createSubtask(subtask2);

        Epic epic2 = new Epic("починить велик", "купить запчасти");
        manager.createEpic(epic2);

        Subtask subtask3 = new Subtask("заказать запчасти", "забрать из пвз", Status.NEW, epic2.getId());

        System.out.println("Список задач");
        for (Task task : manager.getAllTasks()) {
            System.out.println(task);
        }

        System.out.println("Список эпиков");
        for (Epic epic : manager.getAllEpics()) {
            System.out.println(epic);
        }

        System.out.println("Список подзадач");
        for (Subtask subtask : manager.getAllSubtasks()) {
            System.out.println(subtask);
        }

        tas1.setStatus(Status.DONE);
        tas2.setStatus(Status.IN_PROGRESS);
        manager.updateTask(tas1);
        manager.updateTask(tas2);

        subtask1.setStatus(Status.DONE);
        subtask2.setStatus(Status.DONE);
        manager.updateSubtask(subtask1);
        manager.updateSubtask(subtask2);

        subtask3.setStatus(Status.IN_PROGRESS);
        manager.updateSubtask(subtask3);

        System.out.println("Список задач после изменения статусов");
        for (Task task : manager.getAllTasks()) {
            System.out.println(task);
        }

        System.out.println("Список эпиков после изменения статусов подзадач");
        for (Epic epic : manager.getAllEpics()) {
            System.out.println(epic);
        }

        System.out.println("Список подзадач после изменения статусов");
        for (Subtask subtask : manager.getAllSubtasks()) {
            System.out.println(subtask);
        }

        manager.deleteTaskById(tas1.getId());
        manager.deleteEpicById(epic1.getId());

        System.out.println("Список задач после удаления");
        for (Task task : manager.getAllTasks()) {
            System.out.println(task);
        }

        System.out.println("Список эпиков после удаления");
        for (Epic epic : manager.getAllEpics()) {
            System.out.println(epic);
        }

        System.out.println("Список подзадач после удаления");
        for (Subtask subtask : manager.getAllSubtasks()) {
            System.out.println(subtask);

        }
    }
}
