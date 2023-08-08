package com.workintechS19G2.model;

import java.util.*;

public class TaskData {

//    Set<Task> annsTasks = new HashSet<>();
//    Set<Task> bobsTasks = new HashSet<>();
//    Set<Task> carolsTasks = new HashSet<>();

    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;

    private Set<Task> unassignedTask;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks,Set<Task>unassignedTask) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTask = unassignedTask;
    }

    public Set<Task> getTasks(String tasksName){
        switch (tasksName){
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol" :
                return carolsTasks;
            case "allAssigned":
                List<Set<Task>> allAssignedTasks = new ArrayList<>();
                allAssignedTasks.add(annsTasks);
                allAssignedTasks.add(bobsTasks);
                allAssignedTasks.add(carolsTasks);
                return getUnion(allAssignedTasks);
            case "all":
                List<Set<Task>> allTasks = new ArrayList<>();
                allTasks.add(annsTasks);
                allTasks.add(bobsTasks);
                allTasks.add(carolsTasks);
                allTasks.add(unassignedTask);
                return getUnion(allTasks);
        }
        return null;
    }

    public Set<Task> getUnion(List<Set<Task>> taskList){//List<Set<Task>> instead of this you can do <Set<Task>...
        Set<Task> allTasksU = new LinkedHashSet<>();
        for (Set<Task> tasks:taskList){
            allTasksU.addAll(tasks);
        }
        return allTasksU;
    };
    public Set<Task> getIntersection(Set<Task> first, Set<Task> second){
        Set<Task> intersection = new HashSet<>(first);
        intersection.retainAll(second);
        return intersection;
    }

    public Set<Task> getDifference(Set<Task> first, Set<Task>second){
        System.out.println("first"+first.size()+first);
        System.out.println("second"+second.size()+second);
        Set<Task> difference = new HashSet<>(first);
        difference.removeAll(second);
        return difference;
    }
}



