package org.ohiocdc

class ReportLayout {
    
    int year
    String[][] questions
    
    public static final String[] ANSWER_FORMATS = {"Integer","Currency","Yes/No","Written"}

    static constraints = {
        year unique: true, min: 2014
        questions blank: false, validator: {
            for(String[] q in it){
                if(q[0].isEmpty() || !(q[1] in ReportLayout.ANSWER_FORMATS){return false}
            }
        }
        
    }
    
    
}
