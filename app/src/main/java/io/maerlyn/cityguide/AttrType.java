package io.maerlyn.cityguide;

import java.util.HashMap;
import java.util.Map;

/**
 * Used to differentiate between different types of attractions
 *
 * @author Maerlyn Broadbent
 */
public enum AttrType {
    VISIT(1),
    EAT(2),
    DRINK(3),
    SLEEP(4);

    private static Map map = new HashMap<>();

    // static initialiser to create a lookup map
    static {
        for (AttrType attrType : AttrType.values()) {
            map.put(attrType.value, attrType);
        }
    }

    private int value;

    /**
     * assigns values to the types
     *
     * @param value to assign
     */
    AttrType(int value) {
        this.value = value;
    }

    /**
     * Returns the AttrType for a given value
     *
     * @param value of the type to lookup
     * @return AttrType
     */
    public static AttrType valueOf(int value) {

        return (AttrType) map.get(value);
    }

    /**
     * returns the value of an AttrType
     *
     * @return value of an AttrType
     */
    public int getValue() {
        return value;
    }

}
