package org.ohiocdc

class Vista {
    
    String firstName
    String lastName
    String password
    String personalEmail
    String workEmail
    String cellPhone
    String officePhone, extension
    

    static belongsTo = [supervisor: Supervisor, site: MemberSite]
    
    static constraints = {
        
        firstName blank: false
        
        lastName blank: false
        
        password password: true, blank: false
        
        workEmail blank: false, email: true
        
        personalEmail nullable: true, email: true
        
        officePhone blank: false, minSize: 10
        
        extension nullable: true
        
        cellPhone nullable: true, minSize: 10
        
    }
}
