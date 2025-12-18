package taskmaster

class Task {


    String title
    String status = "Todo" //  "Todo", "Doing","Done"
    Integer priority = 1   //  1 (Low) to 5 (High)
    Date dateCreated

    static constraints = {
        title blank: false, size: 5..100
        status inList: ["Todo", "Doing", "Done"]
        priority range: 1..5
    }

    // Reusable query: depends on the situation if it seems the query will be used a lot, then we should have this
    static nameQueries = {
        urgent {
            eq 'staus', 'Todo'
            gt 'priority', 3
        }
    }
}
