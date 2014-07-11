package org.ohiocdc

class ReportLayout {
    
    int year
    
    static hasMany = [questions: Question]

    static constraints = {
        year unique: true, min: 2014
        questions blank: false, minSize: 1
    }
    
    
}
