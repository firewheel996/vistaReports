package org.ohiocdc

class Report {
    
    Vista vista
    Date dateReported = new Date()
    int month
    
    static belongsTo = [layout: ReportLayout]
    
    static hasMany = [answers: Answer]

    static constraints = {
        vista blank: false
        answers blank: false
        dateReported min: new Date(), blank: false
        month range: 1..12, blank: false
    }
}
