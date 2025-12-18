package taskmaster

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class TaskServiceSpec extends Specification implements ServiceUnitTest<TaskService>{

    void "test creating new task"() {
        given: "A task with specific information"
        String title = "Test task with all infor"
        String status = "Todo"
        Integer priority = 2

        when: "The service create it"
        Task createdTask = service.createNewTask(title, priority, status)

        then: "The task is saved correctly"
        createdTask != null
        createdTask.title == title
        createdTask.status == status
        createdTask.priority == priority

        // We cannot have the test below since unit tests does not act like it connect to DB (integration test does)
//        Task.count() == 1
//        Task.list()[0].title == title
    }
}
