package com.teslait.template.framework;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
public enum CountryEnum {

    CL("CL", "Chile"),
    AR("AR", "Argentina");

    private final String code;
    private final String description;

    private static final CountryEnum[] values ={CL, AR};

    CountryEnum(String code, String name){
        this.code = code;
        this.description = name;
    }

    public String code() {
        return code;
    }

    public String description() {
        return description;
    }
    public static CountryEnum resolve(String code) {
        for(CountryEnum value : values()){
            if(code.equals(value.code)){
                return value;
            }
        }
       throw new IllegalArgumentException(String.format("[%s] it is not valid", code));
    }

}
