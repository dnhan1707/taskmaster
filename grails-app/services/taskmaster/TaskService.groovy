package taskmaster

import grails.gorm.transactions.Transactional

@Transactional
class TaskService {

    def createNewTask(String title, Integer priority = 1, String status = "Todo") {
        Task newTaks = new Task(title: title, priority: priority)
        if(newTaks.save(flush: true)) {
            return newTaks
        }
        println("Error create new Task")
        return null
    }
}
