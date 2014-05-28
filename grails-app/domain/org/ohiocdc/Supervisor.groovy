package org.ohiocdc

class Supervisor {
    
    String firstName
    String lastName
    String email
    String cellPhone
    String officePhone
    

    static hasMany = [vistas:Vista]
    
    static belongsTo = [site: MemberSite]
    
    static constraints = {
    }
}
