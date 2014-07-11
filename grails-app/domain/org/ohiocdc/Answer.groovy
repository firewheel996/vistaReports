package org.ohiocdc

class Answer {
    
    String answer
    Question question
    Report report
    
    static belongsTo = [Report]

    static constraints = {
        answer blank: false
    }
}
