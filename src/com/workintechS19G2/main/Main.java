package com.workintechS19G2.main;

import com.workintechS19G2.model.Task;
import com.workintechS19G2.model.TaskData;
import com.workintechS19G2.model.enums.Priority;
import com.workintechS19G2.model.enums.Status;

import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Task task1 = new Task("ERP","Sac Metal ERP Sisteminin kurulumu", "ann", Priority.MED, Status.IN_QUEUE);
        Task task2 = new Task("Twitter Frontend","Bildirim kisminin tamamlanmasi", "bob", Priority.MED, Status.ASSIGNED);
        Task task3 = new Task("ERP","Sac Metal ERP Sisteminin kurulumu+Frontend", "bob", Priority.MED, Status.IN_QUEUE);
        Task task4 = new Task("ERP","Sac Metal ERP Sisteminin kurulumu+Backend", "carol", Priority.LOW, Status.IN_QUEUE);
        Task task5 = new Task("ERP","Sac Metal ERP Sisteminin kurulumu+CRUD", "ann", Priority.HIGH, Status.IN_QUEUE);
        Task task6 = new Task("Twitter Frontend","Bildirim kisminin tamamlanmasi Backend", "", Priority.HIGH, Status.IN_QUEUE);

        Set<Task> annsTasks = new LinkedHashSet<>();
        annsTasks.add(task1);
        annsTasks.add(task5);

        Set <Task> bobsTask = new LinkedHashSet<>();
        bobsTask.add(task2);
        bobsTask.add(task3);
        bobsTask.add(task5);

        Set <Task> carolsTask = new LinkedHashSet<>();
        carolsTask.add(task4);

        Set<Task> unassignedTasks = new LinkedHashSet<>();
        unassignedTasks.add(task6);

        TaskData taskData = new TaskData(annsTasks, bobsTask, carolsTask,unassignedTasks);

        System.out.println("All tasks: ");
        System.out.println("size= "+taskData.getTasks("all").size()+taskData.getTasks("all"));

        System.out.println("***********************");
        System.out.println("Ann's task: ");
        System.out.println(taskData.getTasks("ann"));
        System.out.println("***********************");

        System.out.println("Bob's task: ");
        System.out.println(taskData.getTasks("bob"));
        System.out.println("***********************");

        System.out.println("Carol's task: ");
        System.out.println(taskData.getTasks("carol"));
        System.out.println("***********************");

        System.out.println("Unassigned Tasks: ");
        System.out.println(taskData.getDifference(taskData.getTasks("all"), taskData.getTasks("allAssigned")));
        System.out.println("***********************");

        System.out.println("Ann+Carol: " + taskData.getIntersection(annsTasks, carolsTask));
        System.out.println("Bob+Carol: " + taskData.getIntersection(bobsTask, carolsTask));
        System.out.println("Ann+Bob: " + taskData.getIntersection(annsTasks, bobsTask));

    }


}