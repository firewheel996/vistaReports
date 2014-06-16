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
        firstName blank: false
        lastName blank: false
        email email: true, blank: false
        cellPhone size: 7..10, matches: "[^-]"
    }
}
