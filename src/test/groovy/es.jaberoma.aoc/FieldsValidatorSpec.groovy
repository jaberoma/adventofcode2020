package es.jaberoma.aoc

import es.jaberoma.aoc.day4.FieldsValidator
import spock.lang.Specification

class FieldsValidatorSpec extends Specification {

    void 'Validate fields'() {
        when:
        boolean isValid = FieldsValidator.validate(field)

        then:
        isValid == valid

        where:
        field            | valid
        'byr:2002'       | true
        'byr:2003'       | false
        'iyr:2020'       | true
        'iyr:2021'       | false
        'eyr:2030'       | true
        'eyr:2031'       | false
        'hgt:60in'       | true
        'hgt:190cm'      | true
        'hgt:190in'      | false
        'hgt:190 '       | false
        'pid:000000001'  | true
        'pid:0123456789' | false
        'hcl:#123abc'    | true
        'hcl:#123abz'    | false
        'hcl:123abc'     | false
        'ecl:brn'        | true
        'ecl:wat'        | false
    }
}
