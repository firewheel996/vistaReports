package org.ohiocdc

class Report {
    
    Vista vista
    String[] answers
    Date dateReported = new Date()
    int month
    
    static belongsTo = [layout: ReportLayout]

    static constraints = {
        vista blank: false
        answers blank: false, validator:{ val, obj ->
            return val.length == layout.questions.length
        }
        dateReported min: new Date(), blank: false
        month range: 1..12, blank: false
    }
}
