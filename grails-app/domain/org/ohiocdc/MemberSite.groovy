package org.ohiocdc

class MemberSite {
    
    String name
    String street
    String city
    String state
    String zip
    String phone
    
    static hasOne = [supervisor: Supervisor]
    static hasMany = [vistas: Vista]

    static constraints = {
        name blank: false
        
        street blank: false
        
        city blank: false
        
        state blank: false, inList: ["AL","AK","AZ","AR","CA","CO","CT","DE","DC","FL","GA",
        "HI","ID","IL","IN","KA","KY","LA","ME","MD","MA","MI","MS","MO","MT","NE",
        "NV","NH","NJ","NM","MY","NC","ND","OH","OK","OR","PA","RI","SC","SD","TN","TX",
        "UT","VT","VA","WA","WI","WY"]
        
        zip blank: false, size: 5..9
        
        phone blank: false, minSize: 10
    }
}
