package com.henvealf.learn.java.enums;

import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hongliang.yin/Henvealf
 * @date 2019-07-11
 */
public class EunmLearn {

    public enum TYPE {
        BASIC("basic"), BASELING("baseline");

        String value;

        TYPE(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        private static final Map<String, TYPE> lookup = new HashMap<>();
        static
        {
            for(TYPE env : TYPE.values())
            {
                lookup.put(env.getValue(), env);
            }
        }

        public static TYPE getEnum(String value)
        {
            return lookup.get(value);
        }

        public static TYPE getEnum2(String value) {
            for(TYPE v : values())
                if(v.getValue().equalsIgnoreCase(value)) return v;
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {

        TYPE type = TYPE.getEnum("basic");
        TYPE type1 = TYPE.valueOf("BASIC");

        System.out.println(type == TYPE.BASIC);
        System.out.println(type1 == TYPE.BASIC);

    }

}
