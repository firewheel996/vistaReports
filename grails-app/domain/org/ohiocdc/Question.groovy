package org.ohiocdc

class Question {
    
    String question, answerFormat
    
    static hasMany = [uses: ReportLayout]
    static belongsTo = ReportLayout

    static constraints = {
        question blank:false
        answerFormat inList: ANSWER_FORMATS as List
    }
    
    String toString(){
        question
    }
    
    public static final String[] ANSWER_FORMATS = ["Integer","Currency","Yes/No","Written"]
}
