package org.ohiocdc

class Question {
    
    String question, answerFormat
    
    static hasMany = [instances: ReportLayout]

    static constraints = {
        question blank:false
        answerFormat inList: ANSWER_FORMATS
    }
    
    String toString(){
        question
    }
    
    public static final String[] ANSWER_FORMATS = ["Integer","Currency","Yes/No","Written"]
}
