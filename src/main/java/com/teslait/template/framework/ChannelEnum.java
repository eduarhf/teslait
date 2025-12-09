package com.teslait.template.framework;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
public enum ChannelEnum {

    WEB("WEB", "Web"),
    INTRANET("INTRANET", "Intranet");

    private final String code;
    private final String description;

    private static final ChannelEnum[] values ={WEB, INTRANET};

    ChannelEnum(String code, String name){
        this.code = code;
        this.description = name;
    }

    public String code() {
        return code;
    }

    public String description() {
        return description;
    }
    public static ChannelEnum resolve(String code) {
        for(ChannelEnum value : values()){
            if(code.equals(value.code)){
                return value;
            }
        }
        throw new IllegalArgumentException(String.format("[%s] it is not valid", code));
    }

}
