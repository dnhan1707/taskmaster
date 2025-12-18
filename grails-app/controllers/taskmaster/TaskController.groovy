package taskmaster

import grails.converters.JSON

class TaskController {
    static  allowedMethods = [
            createNewTask: "POST"
    ]

    TaskService taskService

    //GET: task/
    def index() { }

    //POST: task/
    def createNewTask(String title, Integer priority = 1, String status = "Todo") {
        try{
            Task newTask = taskService.createNewTask(title, priority, status)
            render newTask as JSON
        } catch (Exception e) {
            render status: 500, text: e.message
        }
    }
}
